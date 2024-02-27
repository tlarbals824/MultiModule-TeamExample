package com.sim.storagemodule.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
