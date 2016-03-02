package com.ssgx.service.impl;

import com.ssgx.dao.ShPlanRepository;
import com.ssgx.entity.ShPlan;
import com.ssgx.service.ShPlanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
