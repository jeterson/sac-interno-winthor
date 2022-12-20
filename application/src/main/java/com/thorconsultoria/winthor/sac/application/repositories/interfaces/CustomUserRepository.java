package com.thorconsultoria.winthor.sac.application.repositories.interfaces;

import com.thorconsultoria.winthor.sac.application.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomUserRepository {
    @Query(nativeQuery = true, value = "SELECT nome, decrypt(senhabd, usuariobd) senhabd, usuariobd, matricula FROM PCEMPR WHERE USUARIOBD = :username")
    Optional<User> findByUsername(String username);
}
