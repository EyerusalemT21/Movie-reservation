
package com.teameth.moviebooking.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class User {
    @Id
    private int userid;

    private String username;
    private String password;

    private String name;
    @ManyToMany( cascade = CascadeType.ALL)//fetch = FetchType.EAGER,
    @JoinTable(name = "user_with_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "roleId")})
    private Set<Role> roles= new HashSet<>();





/* @ManyToMany(mappedBy = "Users_inRoles")
   *//*
*/
/* @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_roles",referencedColumnName="userid" nullable = false)
    private Role career;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_section", nullable = false)

            */

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> role) {
        this.roles = role;
    }
// private List<Role> roles= new ArrayList<>();


    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }*/

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return userid;
    }

   // public Set<Role> getRoles(){
    //    return roles;
  //  }

  //  public void setRoles(Set<Role> roles) {
   //     this.roles = roles;
   // }
}

