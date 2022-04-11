package com.zyapaar.api.services;

import com.zyapaar.api.pyloads.UserDto;

import java.util.List;

public interface UserServices {

    UserDto CreateUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,String userId);
    UserDto getUserById(String userId);
    List<UserDto> getAllUser();
    void deleteUser(String userId);
    void deleteAllUser();

}
