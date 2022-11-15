package com.carpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.model.*;

public interface RiderRepository extends JpaRepository<Rider,Long> {

}
