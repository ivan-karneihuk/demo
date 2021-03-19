package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Advertisers;
import com.example.demo.models.Campaings;
import com.example.demo.role.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
//@CrossOrigin(origins = "*")
public class UserRestController 
{
    @Autowired
    private UserService userService;

    @GetMapping("/api/userList")
    public ResponseEntity<Map<String, Object>> getAdvertisersList(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "2") int size
        )
    {
        List<User> usersList = new ArrayList<User>();
        Pageable paging = PageRequest.of(page, size);
        Page<User> UsersPage = userService.getAll(paging);
        usersList = UsersPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("users", usersList);
        response.put("currentPage", UsersPage.getNumber());
        response.put("totalItems", UsersPage.getTotalElements());
        response.put("totalPages", UsersPage.getTotalPages());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
