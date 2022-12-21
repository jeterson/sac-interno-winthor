package com.thorconsultoria.winthor.sac.domain.application.input.service;

import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserApplicationService {

    User findByUsername(String username);
}
