package com.nagendra.cassendra.service;

import com.nagendra.cassendra.model.User;
import com.nagendra.cassendra.reposiotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public List<User> retrieveUser(){
        List<User> listUser = userRepository.findAll();
        return listUser;
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
