package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.User;
import com.bookmyshow.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User sinUp(String email,String password){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException();
        }
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
