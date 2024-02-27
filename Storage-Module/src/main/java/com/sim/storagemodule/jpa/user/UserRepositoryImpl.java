package com.sim.storagemodule.jpa.user;

import com.sim.domainmodule.domain.user.User;
import com.sim.domainmodule.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public void save(User user) {
        final UserEntity userEntity = userMapper.mapToEntity(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public void update(User user) {
        final UserEntity userEntity = userMapper.mapToEntity(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public Long findUserIdByEmailAndPassword(String email, String password) {
        return userJpaRepository.findByEmailAndPassword(email, password)
            .map(UserEntity::getId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userJpaRepository.findById(id)
            .map(userMapper::mapToDomain)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }


}
