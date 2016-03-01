package com.ssgx.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by mac on 16/3/1.
 */

@Controller
public class HelloController {

    @Resource(name = "mesJdbc")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        long plancode = jdbcTemplate.query("select top 1 plancode from sh_plan", resultSet -> {
            if (resultSet.next())
                return resultSet.getLong("plancode");
            return null;
        });
        return plancode + "ss 方法" ;
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
