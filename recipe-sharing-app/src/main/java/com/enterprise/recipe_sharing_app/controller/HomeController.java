package com.enterprise.recipe_sharing_app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/home")
public class HomeController {

    @GetMapping
   public String homeController()
    {
        return "This is the home page";
    }


}
