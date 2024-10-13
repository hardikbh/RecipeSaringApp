package com.enterprise.recipe_sharing_app.controller;

import com.enterprise.recipe_sharing_app.Repository.UserRepository;
import com.enterprise.recipe_sharing_app.configuration.JWTProvider;
import com.enterprise.recipe_sharing_app.model.User;
import com.enterprise.recipe_sharing_app.serviceImpl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception{
      String email = user.getEmail();
      String password = user.getPassword();
      String fullName = user.getFullname();
      User isExistEmail = userRepository.findByEmail(email);
      if(isExistEmail!=null)
      {
          throw new Exception(" Email is already use with another account ");
      }
      User createadUser = new User();
      createadUser.setEmail(email);
      createadUser.setPassword(passwordEncoder.encode(password));

      User savedUser = userRepository.save(createadUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse response = new AuthResponse();
        response.setJwt(token);
        response.setMessage(" Sign up sucess ");
        return response;
    }


}
