package com.takeo.service;

import com.takeo.dto.UserDto;
import com.takeo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User userRegistration(UserDto userDto);

    public User viewUser(int userId);
    public List<User> viewAllUsers();


    public User userLogin(String email, String password);
    public String updateUser(UserDto userDto);


}
