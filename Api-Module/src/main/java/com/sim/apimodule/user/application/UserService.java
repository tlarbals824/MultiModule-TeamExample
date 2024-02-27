package com.sim.apimodule.user.application;

import com.sim.apimodule.user.dto.request.UserCreateRequest;
import com.sim.apimodule.user.dto.request.UserLoginRequest;
import com.sim.apimodule.user.dto.request.UserUpdateRequest;
import com.sim.apimodule.user.dto.response.UserDetailsResponse;
import com.sim.apimodule.user.dto.response.UserLoginResponse;
import com.sim.domainmodule.domain.user.User;
import com.sim.domainmodule.domain.user.service.UserAppender;
import com.sim.domainmodule.domain.user.service.UserModifier;
import com.sim.domainmodule.domain.user.service.UserReader;
import com.sim.domainmodule.domain.user.service.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserReader userReader;
    private final UserValidator userValidator;
    private final UserAppender userAppender;
    private final UserModifier userModifier;

    @Transactional
    public void createUser(UserCreateRequest request){
        userValidator.checkIfUserExists(request.email());
        userAppender.appendUser(request.createDomain());
    }

    @Transactional(readOnly = true)
    public UserLoginResponse loginUser(UserLoginRequest request){
        final Long userId = userReader.findUserIdByEmailAndPassword(request.email(), request.password());
        return new UserLoginResponse(userId);
    }

    @Transactional
    public void updateUser(UserUpdateRequest request){
        userModifier.modify(request.toQuery());
    }

    @Transactional(readOnly = true)
    public UserDetailsResponse getUserDetails(Long userId){
        final User user = userReader.findById(userId);
        return new UserDetailsResponse(user.getId(), user.getUsername(), user.getEmail());
    }

}
