package com.carpool.repository;
import org.springframework.data.repository.CrudRepository;

import com.carpool.model.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}