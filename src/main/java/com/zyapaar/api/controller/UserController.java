package com.zyapaar.api.controller;

import com.zyapaar.api.pyloads.ApiResponse;
import com.zyapaar.api.pyloads.UserDto;
import com.zyapaar.api.services.UserServices;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/user")
    public ResponseEntity<?> getAllUser(){
        try {
            List<UserDto> users=this.userServices.getAllUser();
            if (users.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("database has nothing to show",true));
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId){
        UserDto userDto1=this.userServices.getUserById(userId);
        return ResponseEntity.ok(userDto1);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto userDto1=this.userServices.CreateUser(userDto);
        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") String userId){
        UserDto userDto1=this.userServices.updateUser(userDto,userId);
        return ResponseEntity.ok(userDto1);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId){
        this.userServices.deleteUser(userId);
//        return ResponseEntity.ok(Map.of("massage","User Delete Successfully"));
        return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);

    }
    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser(){
        this.userServices.deleteAllUser();
//        return ResponseEntity.ok(Map.of("massage","User Delete Successfully"));
        return new ResponseEntity(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);

    }



}
