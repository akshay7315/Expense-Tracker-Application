package com.main.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.main.entity.Expense;
import com.main.entity.User;
import com.main.repo.ExpenseRepository;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepo;

    @GetMapping("/")
    public String viewHome(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        model.addAttribute("expenses", expenseRepo.findByUser(user));
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/login";
        model.addAttribute("expense", new Expense());
        return "expense_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Expense expense, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        expense.setUser(user);
        expenseRepo.save(expense);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        Expense expense = expenseRepo.findById(id).orElseThrow();
        if (!expense.getUser().getId().equals(user.getId())) return "redirect:/";
        model.addAttribute("expense", expense);
        return "expense_form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        Expense expense = expenseRepo.findById(id).orElseThrow();
        if (expense.getUser().getId().equals(user.getId())) {
            expenseRepo.deleteById(id);
        }
        return "redirect:/";
    }
    
   
}