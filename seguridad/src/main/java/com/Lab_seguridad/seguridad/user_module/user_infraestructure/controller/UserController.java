package com.Lab_seguridad.seguridad.user_module.user_infraestructure.controller;

import com.Lab_seguridad.seguridad.user_module.user_core.entities.User;
import com.Lab_seguridad.seguridad.user_module.user_infraestructure.complements.UserLoginRequest.UserLoginRequest;
import com.Lab_seguridad.seguridad.user_module.user_service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServiceImpl userService;

    @GetMapping("/getAllUsers")
    public ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{userId}")
    public Optional<User> getUserLogin(@PathVariable int userId, @RequestBody UserLoginRequest userLoginRequest){
        return userService.getUserLogin(userId, userLoginRequest.getUsername(), userLoginRequest.getPassword());
    }

    // This is using a SQL Query.
    @GetMapping("/getUsers")
    public List<User> getUsersByQuery(){
        return userService.getUsers();
    }

    @PostMapping("/getUser")
    public User getUserByQuery(@RequestBody UserLoginRequest userLoginRequest){
        return userService.getUser(userLoginRequest.getUsername(), userLoginRequest.getPassword());
    }
}
