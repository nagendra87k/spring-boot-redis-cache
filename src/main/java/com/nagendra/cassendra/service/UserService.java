package com.nagendra.cassendra.service;

import com.nagendra.cassendra.model.User;
import com.nagendra.cassendra.reposiotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @CacheEvict(cacheNames = "users", allEntries = true)
    public User addUser(User user){
        return userRepository.save(user);
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    public User updateUser(User user){
        return userRepository.save(user);
    }

    @Cacheable(cacheNames = "users")
    public List<User> retrieveUser(){
        List<User> listUser = userRepository.findAll();
        return listUser;
    }

    @Cacheable(cacheNames = "user", key = "#id", unless = "#result == null")
    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
