package com.sim.domainmodule.domain.user.service;

import com.sim.domainmodule.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidator {
    private final UserRepository userRepository;
    public void checkIfUserExists(String email) {
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("User already exists");
        }
    }
}
