package com.sim.apimodule.user.dto.request;

import com.sim.domainmodule.domain.user.service.query.UserUpdateQuery;

public record UserUpdateRequest(
    Long userId,
    String username
) {

    public UserUpdateQuery toQuery(){
        return new UserUpdateQuery(userId, username);
    }
}
