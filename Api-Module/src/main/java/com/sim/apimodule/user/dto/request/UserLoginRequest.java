package com.sim.apimodule.user.dto.request;

public record UserLoginRequest(
    String email,
    String password
) {

}
