package com.sim.apimodule.user.dto.request;

import com.sim.domainmodule.domain.user.User;

public record UserCreateRequest(
    String username,
    String password,
    String email
) {
    public User createDomain(){
        return new User(null, username, password, email);
    }
}
