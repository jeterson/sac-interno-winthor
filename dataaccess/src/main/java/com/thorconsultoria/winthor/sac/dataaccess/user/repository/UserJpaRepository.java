package com.thorconsultoria.winthor.sac.dataaccess.user.repository;

import com.thorconsultoria.winthor.sac.dataaccess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);
}
