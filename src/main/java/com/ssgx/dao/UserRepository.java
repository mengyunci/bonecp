package com.ssgx.dao;

import com.ssgx.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mac on 16/3/22.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findByUsername(String username);

}
