package com.sim.storagemodule.jpa.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@Table(name = "user")
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    protected UserEntity() {
    }

    public UserEntity(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static UserEntity of(Long id, String username, String password, String email) {
        return new UserEntity(id, username, password, email);
    }
}
