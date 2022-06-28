

package com.teameth.moviebooking.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class Role {
    @Id
    private int roleId;

    private String name;
    private String description;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;


/* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Users_inRoles",
            joinColumns = {
                    @JoinColumn(name = "roleId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "useridid" ) })
*/

//Set<User> users = new HashSet<>();

    public Role() {

    }

    public Role(int roleId, String name, String description) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }



    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public int getRoleId() {
        return roleId;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


