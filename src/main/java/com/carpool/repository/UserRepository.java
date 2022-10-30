package com.carpool.repository;
import org.springframework.data.repository.CrudRepository;

import com.carpool.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}