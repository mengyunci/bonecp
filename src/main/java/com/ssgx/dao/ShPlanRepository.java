package com.ssgx.dao;

import com.ssgx.entity.ShPlan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by mac on 16/3/2.
 */
@Repository
public interface ShPlanRepository extends PagingAndSortingRepository<ShPlan,Long> {

}
