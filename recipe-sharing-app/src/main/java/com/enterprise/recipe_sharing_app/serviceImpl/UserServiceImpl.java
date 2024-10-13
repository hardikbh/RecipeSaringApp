package com.enterprise.recipe_sharing_app.serviceImpl;

import com.enterprise.recipe_sharing_app.Execptions.UserNotFound;
import com.enterprise.recipe_sharing_app.Repository.UserRepository;
import com.enterprise.recipe_sharing_app.model.User;
import com.enterprise.recipe_sharing_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUserById(Long id) throws UserNotFound {

      Optional<User> user = userRepository.findById(id);
      if(user.isPresent())
      {
          return user.get();
      }
      throw new UserNotFound("No user with "+id+" is present");

    }

    @Override
    public User createUser(User user) throws Exception {
        User oldUser = userRepository.findByEmail(user.getEmail());
        if(oldUser!=null)
        {
            throw new Exception("User is already present with the email : "+user.getEmail());
        }
        User newUser = User.builder().email(user.getEmail()).fullname(user.getFullname()).password(user.getPassword()).build();
       return  userRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> isExist = userRepository.findById(id);
        if(!isExist.isPresent())
        {
            throw new UserNotFound("No user is present with this : "+ id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> allUsers() throws Exception{
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
        {
            throw new Exception("No user is present currently");
        }
        return users;
    }


}
