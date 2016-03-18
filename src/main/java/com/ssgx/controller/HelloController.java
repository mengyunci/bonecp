package com.ssgx.controller;

import com.ssgx.entity.ShPlan;
import com.ssgx.service.ShPlanService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 16/3/1.
 */

@Controller
public class HelloController {

    @Resource
    private ShPlanService service;


    @RequestMapping("/")
    public String index() {
        return "welcome";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public List<ShPlan> hello(@RequestParam(required = false,defaultValue = "0") int page,@RequestParam(required = false,defaultValue = "10") int size) {

        Pageable pageable = new PageRequest(page,size);
        return service.findAll(pageable).getContent();

    }

    @RequestMapping("/m")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "hehe");
        return "welcome";
    }


    @Resource(name = "wbmJdbc")
    private JdbcTemplate wbm;

    @RequestMapping("he")
    @ResponseBody
    public String he() {
        long id = wbm.query("select top 1 id from base_menu", resultSet -> {
            if (resultSet.next())
                return resultSet.getLong("id");
            return null;
        });
        return id + "";
    }
}
