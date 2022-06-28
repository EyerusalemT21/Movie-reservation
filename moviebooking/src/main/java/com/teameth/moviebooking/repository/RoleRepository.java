
package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Role findByName(String name);
}

