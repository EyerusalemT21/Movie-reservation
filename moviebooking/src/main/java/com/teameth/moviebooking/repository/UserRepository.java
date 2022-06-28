
package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}


