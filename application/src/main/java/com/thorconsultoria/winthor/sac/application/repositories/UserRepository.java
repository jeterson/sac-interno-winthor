package com.thorconsultoria.winthor.sac.application.repositories;

import com.thorconsultoria.winthor.sac.application.entities.User;
import com.thorconsultoria.winthor.sac.application.repositories.interfaces.CustomUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
}
