package com.enterprise.recipe_sharing_app.Repository;

import com.enterprise.recipe_sharing_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
