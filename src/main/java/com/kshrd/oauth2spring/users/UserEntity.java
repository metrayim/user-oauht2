package com.kshrd.oauth2spring.users;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Entity(name="userss")
@Data
public class UserEntity
{

    @PrePersist
    void prePersist(){
        this.id=UUID.randomUUID().toString();
        this.status=true;
    }
    @Id
    @Column(unique = true)
    String id;
    @Column(nullable = false,length = 100)
    String username;
    @Column(nullable = false,length = 100)
    String password;
    boolean status;
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}