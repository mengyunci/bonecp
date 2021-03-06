package com.unknow.service.impl;

import com.unknow.dao.BaseMenuRepository;
import com.unknow.entity.BaseMenu;
import com.unknow.service.BaseMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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
                cMenu.putIfAbsent(m.getPrentId(), new ArrayList<>());
                cMenu.get(m.getPrentId()).add(m);
            }
        });

        pMenu.forEach((integer, baseMenu) -> baseMenu.setChildren(cMenu.get(integer)));

        return pMenu.values().stream().collect(Collectors.toList());
    }
    
//    private List<Menu> getChildren(List<Menu> result,String rootId ) {
//        List<Menu> r = new ArrayList<>();
//        for (int i = 0; i < result.size(); i++) {
//            Menu t = result.get(i);
//            if (rootId.equals(t.getParentId())) {
//                List<Menu> children = getChildren(result,t.getId());
//
//                if (!children.isEmpty()) {
//                    t.setChildren(children);
//                } else {
//                    t.setLeaf(true);
//                }
//                r.add(t);
//            }
//        }
//        return r;
//    }
    
}
