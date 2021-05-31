package com.nagendra.cassendra.controller;

import com.nagendra.cassendra.exception.ResouceNotFoundException;
import com.nagendra.cassendra.model.User;
import com.nagendra.cassendra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CacheConfig(cacheNames = "userCache")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User userReq){
        User user = userService.addUser(userReq);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/update",produces = "application/json",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User userReq){
         User user = userService.addUser(userReq);
         return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/read",produces = "application/json",method = RequestMethod.GET)
    public ResponseEntity<List<User>> retrieveUser(){
        List<User> userList = userService.retrieveUser();
        return ResponseEntity.ok(userList);
    }

    @RequestMapping(value = "/delete/{id}",produces = "application/json",method = RequestMethod.DELETE)
    @Caching(evict = { @CacheEvict(cacheNames = "user", key = "#id"),
            @CacheEvict(cacheNames = "users", allEntries = true) })
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Integer id){
        User user = userService.findById(id).orElseThrow(
                () -> new ResouceNotFoundException("Product not found::: " + id));
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}
