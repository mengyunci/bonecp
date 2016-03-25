package com.ssgx.service.impl;

import com.ssgx.dao.BaseMenuRepository;
import com.ssgx.entity.BaseMenu;
import com.ssgx.service.BaseMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mac on 16/3/24.
 */
@Service
public class BaseMenuServiceImpl implements BaseMenuService {

    @Resource
    private BaseMenuRepository repository;


    @Override
    public List<BaseMenu> loadMenuTree(int moduleId) {
        List<BaseMenu> menus = repository.findTreeByModel(moduleId);
        if (menus.isEmpty())
            return menus;


        Map<Integer, BaseMenu> pMenu = new HashMap<>();
        Map<Integer, List<BaseMenu>> cMenu = new HashMap<>();
        menus.stream().forEach(m -> {
            if (m.getPrentId() == null) {
                pMenu.put(m.getId(), m);
            } else {
                if (cMenu.get(m.getPrentId()) == null) {
                    cMenu.put(m.getPrentId(), new ArrayList<>());
                }
                cMenu.get(m.getPrentId()).add(m);
            }
        });

        pMenu.forEach((integer, baseMenu) -> baseMenu.setChildren(cMenu.get(integer)));

        return pMenu.values().stream().collect(Collectors.toList());
    }
}
