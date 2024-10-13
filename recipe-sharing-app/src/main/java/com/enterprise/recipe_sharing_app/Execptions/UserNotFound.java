package com.enterprise.recipe_sharing_app.Execptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String message)
    {
        super(message);
    }
}
