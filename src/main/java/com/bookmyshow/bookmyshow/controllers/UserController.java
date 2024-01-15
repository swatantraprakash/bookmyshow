package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.ResponseStatus;
import com.bookmyshow.bookmyshow.dtos.SignUpRequestDto;
import com.bookmyshow.bookmyshow.dtos.SignUpResponseDto;
import com.bookmyshow.bookmyshow.models.User;
import com.bookmyshow.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto request) {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        User user;

        try{
            user = userService.sinUp(request.getEmail(), request.getPassword());
            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            System.out.println("User Already Exists");
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return signUpResponseDto;
    }
}
