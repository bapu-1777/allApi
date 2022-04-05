package com.zyapaar.api.services;

import com.zyapaar.api.pyloads.UserDto;

import java.util.List;

public interface UserServices {

    UserDto CreateUser(UserDto userDto);
    UserDto UpdateUser(UserDto userDto,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);



}
