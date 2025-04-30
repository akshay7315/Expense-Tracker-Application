package com.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Expense;
import com.main.entity.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}

