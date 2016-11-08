package com.unknow.controller;

import com.unknow.dao.BaseMenuRepository;
import com.unknow.entity.BaseMenu;
import com.unknow.entity.ShPlan;
import com.unknow.service.ShPlanService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Resource
    private BaseMenuRepository baseMenuRepository;

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

    @RequestMapping("/bm")
    @ResponseBody
    public List<BaseMenu> bm() {
        return (List<BaseMenu>) baseMenuRepository.findAll();
    }
}
