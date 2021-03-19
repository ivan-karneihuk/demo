package com.example.demo.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repo.UserRepo;
import com.example.demo.role.Role;
import com.example.demo.role.User;

    @Controller
    public class registr 
    {
        @Autowired
        private UserRepo userRepo;
        
        @GetMapping("/registr")
        public String reg(Model model)
        {
        
            return "registr";   
        }

        @PostMapping("/registr")
        public String addUser(User user, Map<String, Object> model)
        {
            User userFromDb = userRepo.findByUsername(user.getUsername());

            if (userFromDb != null)
            {
                model.put("message", "Польzователь создан");
                return "registr";
            }

            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);

            return "redirect:/";
        }

        @GetMapping("@{/registr}")
        public String login(Model model) 
        {
            model.addAttribute("title", "Главная страница");
            return "redirect:/";
        }
    }
