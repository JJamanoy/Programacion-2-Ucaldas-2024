package com.src.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long id;
    @Column(name="fullname")
    private String fullname;
    @Column (name="user_email")
    private String user_email;
    @Column (name= "current_password")
    private String current_password;
    @Column (name="role")
    private String role;
    @Column (name= "avatar")
    private String avatar;
    @Column (name = "activate_state")
    private boolean active_state;

    public User(){}

    public String getFullname(){
        return fullname;
    }
    public String getUser_email(){
        return user_email;
    }
    public String getCurrent_password(){
        return current_password;
    }
    public String getRole(){
        return role;
    }
    public String geAavatar(){
        return avatar;
    }
    public boolean getActive_state(){
        return active_state;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public void setUser_email(String user_email){
        this.user_email = user_email;
    }

    public void setCurrent_password(String current_password){
        this.current_password = current_password;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public void setActive_state(boolean active_state){
        this.active_state = active_state;
    }




}
