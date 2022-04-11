package com.zyapaar.api.services.impl;

import com.zyapaar.api.entities.User;
import com.zyapaar.api.exceptions.*;
import com.zyapaar.api.pyloads.UserDto;
import com.zyapaar.api.repo.UserRepo;
import com.zyapaar.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto CreateUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResoursourceNotFound("User","id",userId));


        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser=this.userRepo.save(user);
        UserDto userDto1=this.userToDto(updatedUser);


        return userDto1;
    }

    @Override
    public UserDto getUserById(String userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResoursourceNotFound("User","id",userId));
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>users = this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(this::userToDto).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(String userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResoursourceNotFound("User","id",userId));

        this.userRepo.delete(user);
    }

    @Override
    public void deleteAllUser() {
        this.userRepo.deleteAll();
    }


    public User dtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;


    }

    public UserDto userToDto(User user){
        UserDto userDto=new UserDto();

        userDto.setId(user.getId());
        userDto.setAbout(user.getAbout());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
