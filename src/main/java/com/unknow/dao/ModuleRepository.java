package com.unknow.dao;

import com.unknow.entity.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mac on 16/3/25.
 */
@Repository
public interface ModuleRepository extends CrudRepository<Module,Integer> {

    @Query(value = "select * from module where authorize = 1 order by priority",nativeQuery = true)
    List<Module> findModules();


}
