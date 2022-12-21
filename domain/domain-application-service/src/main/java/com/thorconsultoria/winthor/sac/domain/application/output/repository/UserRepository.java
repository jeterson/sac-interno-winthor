package com.thorconsultoria.winthor.sac.domain.application.output.repository;

import com.thorconsultoria.winthor.sac.domain.core.entities.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}
