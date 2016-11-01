package com.unknow.service.impl;

import com.unknow.dao.ShPlanRepository;
import com.unknow.entity.ShPlan;
import com.unknow.service.ShPlanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mac on 16/3/2.
 */
@Service
public class ShPlanServiceImpl implements ShPlanService {

    @Resource
    private ShPlanRepository repository;


    @Override
    public Page<ShPlan> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
