package com.enterprise.recipe_sharing_app.controller;


import com.enterprise.recipe_sharing_app.Execptions.UserNotFound;
import com.enterprise.recipe_sharing_app.Repository.UserRepository;
import com.enterprise.recipe_sharing_app.model.User;
import com.enterprise.recipe_sharing_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;
    @PostMapping()
     public User createUser(@RequestBody User user) throws Exception
     {

         return userService.createUser(user);
     }

     @GetMapping("/{userId}")
      public User getUserById(@PathVariable Long userId) throws UserNotFound
     {
         return userService.findUserById(userId);
     }

     @DeleteMapping("/{userId}")
     public String  deleteUserById(@PathVariable Long userId) throws Exception
       {
             userService.deleteUser(userId);
             return "User is deleted successfully";
       }

       @GetMapping()
        public List<User> getAllUsers() throws Exception
       {
           return userService.allUsers();
       }

}

