package com.src.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.app.domain.User;
import com.src.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers(){
        return userRepository.findAll();
    }
}
