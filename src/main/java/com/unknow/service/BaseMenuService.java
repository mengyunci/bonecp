package com.unknow.service;

import com.unknow.entity.BaseMenu;

import java.util.List;

/**
 * Created by mac on 16/3/24.
 */
public interface BaseMenuService {

    List<BaseMenu> loadMenuTree(int moduleId);

}
