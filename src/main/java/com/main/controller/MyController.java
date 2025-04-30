package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.entity.User;
import com.main.repo.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
	public class MyController {

	    @Autowired
	    private UserRepository userRepo;

	    @GetMapping("/register")
	    public String showRegister(Model model) {
	        model.addAttribute("user", new User());
	        return "register";
	    }

	    @PostMapping("/register")
	    public String register(@ModelAttribute User user) {
	        userRepo.save(user);
	        return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String showLogin(Model model) {
	        model.addAttribute("user", new User());
	        return "login";
	    }

	    @PostMapping("/login")
	    public String login(@ModelAttribute User user, HttpSession session, Model model) {
	        User existingUser = userRepo.findByUsername(user.getUsername());
	        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	            session.setAttribute("user", existingUser);
	            return "redirect:/";
	        }
	        model.addAttribute("error", "Invalid credentials");
	        return "login";
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
	}

