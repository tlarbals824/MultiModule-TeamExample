package com.sim.domainmodule.domain.user.service;

import com.sim.domainmodule.domain.user.User;
import com.sim.domainmodule.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAppender {
    private final UserRepository userRepository;

    public void appendUser(User user){
        userRepository.save(user);
    }
}
