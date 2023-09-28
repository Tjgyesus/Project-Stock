package com.takeo.controller;

import com.takeo.dto.UserDto;
import com.takeo.entity.User;
import com.takeo.service.implts.UserServiceImplt;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImplt userServiceImplt;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userServiceImplt.userRegistration(userDto),HttpStatus.CREATED);
    }


    @GetMapping("/viewuser/{userId}")
    public ResponseEntity<User> viewUserById(@PathVariable int userId) {
        return ResponseEntity.ok(userServiceImplt.viewUser(userId));
    }
    @GetMapping("/viewall") public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userServiceImplt.viewAllUsers());
    }
    @GetMapping("/login/{username}/{password}")
    public  ResponseEntity<User> login(@PathVariable String username, @PathVariable  String password){
        return new ResponseEntity<>(userServiceImplt.userLogin(username,password),HttpStatus.ACCEPTED);

    }
    @PutMapping("/updateUser")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserDto userDto) {

        String updateUserDetails = userServiceImplt.updateUser(userDto);
        Map<String, Object> map = new HashMap<>();
        map.put("message", updateUserDetails);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }
}
