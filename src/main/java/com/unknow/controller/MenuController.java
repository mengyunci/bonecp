package com.unknow.controller;

import com.unknow.entity.BaseMenu;
import com.unknow.service.BaseMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 16/3/24.
 */
@Controller
public class MenuController {

    @Resource
    private BaseMenuService service;

    @RequestMapping("/menuview/{moduleId}")
    public String menuView(@PathVariable(value = "moduleId")int moduleId, Map<String,Object> model) {
        model.put("moduleId",moduleId);
        return "common/treeModel";
    }


    @RequestMapping("/menu/{moduleId}")
    @ResponseBody
    public List<BaseMenu> loadMenuTree(@PathVariable(value = "moduleId")int moduleId) {
        return service.loadMenuTree(moduleId);
    }


}
