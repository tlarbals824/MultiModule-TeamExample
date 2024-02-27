package com.sim.storagemodule.jpa.user;

import com.sim.domainmodule.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToEntity(User user) {
        return UserEntity.of(user.getId(), user.getUsername(), user.getPassword(),user.getEmail());
    }

    public User mapToDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }
}
