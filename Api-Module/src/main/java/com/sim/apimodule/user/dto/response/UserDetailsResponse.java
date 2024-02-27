package com.sim.apimodule.user.dto.response;

public record UserDetailsResponse(
    Long userId,
    String username,
    String email
) {
}
