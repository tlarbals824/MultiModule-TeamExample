package com.sim.domainmodule.domain.user;

import java.util.Optional;

public interface UserRepository {

    Boolean existsByEmail(String email);

    void save(User user);
    void update(User user);
//    Long findUserIdByEmailAndPassword(String email, String password);
    Optional<Long> findUserIdByEmailAndPassword(String email, String password);
//    User findById(Long id);

    Optional<User> findById(Long id);
}
