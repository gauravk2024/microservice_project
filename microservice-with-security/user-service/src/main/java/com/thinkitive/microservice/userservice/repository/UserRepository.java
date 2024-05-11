package com.thinkitive.microservice.userservice.repository;

import com.thinkitive.microservice.userservice.entity.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserService, Integer> {
}