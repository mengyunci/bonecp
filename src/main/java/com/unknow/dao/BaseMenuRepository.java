package com.unknow.dao;

import com.unknow.entity.BaseMenu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mac on 16/3/24.
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface BaseMenuRepository extends CrudRepository<BaseMenu,Integer> {

    @Cacheable
    @Query(value = "select * from menu where moduid = ?1 order by parentId",nativeQuery = true)
    List<BaseMenu> findTreeByModel(int moduleId);

}
