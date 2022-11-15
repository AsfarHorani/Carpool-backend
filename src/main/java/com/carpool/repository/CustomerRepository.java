package com.carpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.carpool.model.*;

public interface CustomerRepository extends JpaRepository<Customer,Long>{ 

}
