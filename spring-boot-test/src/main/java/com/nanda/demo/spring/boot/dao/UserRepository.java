package com.nanda.demo.spring.boot.dao;

import com.nanda.demo.spring.boot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nthatiko on 9/22/2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}
