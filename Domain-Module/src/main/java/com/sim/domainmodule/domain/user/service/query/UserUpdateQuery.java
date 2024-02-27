package com.sim.domainmodule.domain.user.service.query;

public record UserUpdateQuery(
    Long userId,
    String username
){
}
