package com.enterprise.recipe_sharing_app.service;

import com.enterprise.recipe_sharing_app.Execptions.UserNotFound;
import com.enterprise.recipe_sharing_app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findUserById(Long id) throws UserNotFound;

    User createUser(User user) throws Exception;
    void deleteUser(Long id) throws Exception;
    List<User> allUsers() throws Exception;
}
