package com.zyapaar.api.impl;

import com.zyapaar.api.entities.User;
import com.zyapaar.api.pyloads.UserDto;
import com.zyapaar.api.repo.UserRepo;
import com.zyapaar.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import java.util.List;

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
    public UserDto UpdateUser(UserDto userDto, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }


    private User dtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;


    }

    private UserDto userToDto(User user){
        UserDto userDto=new UserDto();

        userDto.setId(user.getId());
        userDto.setAbout(user.getAbout());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
