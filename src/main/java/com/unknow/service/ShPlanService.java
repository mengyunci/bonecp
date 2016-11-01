package com.unknow.service;

import com.unknow.entity.ShPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by mac on 16/3/2.
 */
public interface ShPlanService {

    Page<ShPlan> findAll(Pageable pageable);

}
