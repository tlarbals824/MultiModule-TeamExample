package com.sim.domainmodule.domain.user.service;

import com.sim.domainmodule.domain.user.User;
import com.sim.domainmodule.domain.user.UserRepository;
import com.sim.domainmodule.domain.user.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReader {
    private final UserRepository userRepository;

    public Long findUserIdByEmailAndPassword(String email, String password){
        return userRepository.findUserIdByEmailAndPassword(email, password)
            .orElseThrow(UserException::new);
    }

    public User findById(Long id){
        return userRepository.findById(id)
            .orElseThrow(UserException::new);
    }
}
