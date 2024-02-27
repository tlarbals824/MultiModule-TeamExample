package com.sim.domainmodule.domain.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;

    public void update(String username){
        Assert.notNull(username, "Username cannot be null");
        this.username = username;
    }
}
