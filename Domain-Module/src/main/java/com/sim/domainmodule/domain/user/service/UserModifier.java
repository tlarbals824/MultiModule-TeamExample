package com.sim.domainmodule.domain.user.service;

import com.sim.domainmodule.domain.user.User;
import com.sim.domainmodule.domain.user.UserRepository;
import com.sim.domainmodule.domain.user.service.query.UserUpdateQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserModifier {
    private final UserReader userReader;
    private final UserRepository userRepository;

    public void modify(UserUpdateQuery userUpdateQuery){
        final User user = userReader.findById(userUpdateQuery.userId());
        user.update(
            userUpdateQuery.username()
        );
        userRepository.update(user);
    }

}
