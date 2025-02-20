package com.dineease.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dineease.userservice.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
}
