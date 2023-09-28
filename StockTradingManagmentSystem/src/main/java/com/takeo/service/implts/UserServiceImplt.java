package com.takeo.service.implts;

import com.takeo.dto.UserDto;
import com.takeo.entity.User;
import com.takeo.exceptions.UserNotFoundException;
import com.takeo.repo.UserRepo;
import com.takeo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplt implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User userRegistration(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        User userSave = userRepo.save(user);
        return userSave;
    }
    @Override
    public User viewUser(int userId) {
        User user = new User();
        user = userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found with an id : " + userId));

        return user;
    }
    @Override
    public List<User> viewAllUsers() {
        List<User> user = userRepo.findAll();
        return user;
    }
    @Override
    public String updateUser(UserDto userDto) {
        Optional <User> user = userRepo.findByEmail(userDto.getEmail());
        String message = "failed to update";
        if(!user.isEmpty()){
            User userDetails = user.get();
            BeanUtils.copyProperties(userDto,user);
            userRepo.save(userDetails);
            message = "updated Successfully";
        }
        return message;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> userByEmail = userRepo.findByEmail(email);
        if(!userByEmail.isEmpty())
            return userByEmail;
        else {
            System.out.println("User not found");
        }
        return null;
    }
    @Override
    public User userLogin(String email, String password) {
        User user=new User();
        Optional<User> checkUser = findByEmail(email);
            if(checkUser!=null) {
                System.out.println("user found");
                if (password.equals(user.getPassword()))
                    System.out.println("Valid User");
                else
                    System.out.println("Invalid User");

            }
            return user;
        }
    }



