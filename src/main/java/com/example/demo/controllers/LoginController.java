package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{


	@GetMapping("@{/login}")
	public String login(Model model) 
	{
		return "redirect:/";
	}

    @GetMapping("/logout")
	public String logout(Model model) 
	{
		return "redirect:/login?logout";
	}


}