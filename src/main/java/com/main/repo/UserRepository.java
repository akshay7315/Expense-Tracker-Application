package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}