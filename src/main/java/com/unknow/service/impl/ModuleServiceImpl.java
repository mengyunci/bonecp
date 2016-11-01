package com.unknow.service.impl;

import com.unknow.dao.ModuleRepository;
import com.unknow.entity.Module;
import com.unknow.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mac on 16/3/25.
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleRepository repository;

    @Override
    public List<Module> findModules() {
        return repository.findModules();
    }
}
