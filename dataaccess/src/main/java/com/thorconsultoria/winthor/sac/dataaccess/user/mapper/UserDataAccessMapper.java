package com.thorconsultoria.winthor.sac.dataaccess.user.mapper;

import com.thorconsultoria.winthor.sac.dataaccess.user.entity.UserEntity;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {

    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .name(userEntity.getName())
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername())
                .build();
    }
    public UserEntity userToUserEntity(User user) {
        var userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());

        return userEntity;
    }
}
