package com.ssgx.service;

import com.ssgx.entity.ShPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by mac on 16/3/2.
 */
public interface ShPlanService {

    Page<ShPlan> findAll(Pageable pageable);

}
