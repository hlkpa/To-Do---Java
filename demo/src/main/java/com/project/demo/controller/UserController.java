package com.project.demo.controller;

import com.project.demo.models.RegisterDto;
import com.project.demo.models.UserApp;
import com.project.demo.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;
    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
    	
    	RegisterDto register = new RegisterDto();
    	model.addAttribute(register);
    	model.addAttribute("success", false);
    	
    	return "register";
    }
    
    
    @PostMapping("/register")
    @Operation(summary = "User Registration")
    public String register(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult result) {
    	
    	var bcryptEncoder = new BCryptPasswordEncoder();
    	UserApp userregistered = new UserApp();
    	userregistered.setName(registerDto.getName());
    	userregistered.setLastname(registerDto.getLastname());
    	userregistered.setUsername(registerDto.getUsername());
    	userregistered.setEmail(registerDto.getEmail());
    	userregistered.setCreationDate(LocalDate.now());
    	userregistered.setPwd(bcryptEncoder.encode(registerDto.getPwd()));
    	
        userRepo.save(userregistered);
        
        model.addAttribute("registrationDto", new RegisterDto());
        model.addAttribute("success", true);
        
        return "register";
    }
    
	
}
