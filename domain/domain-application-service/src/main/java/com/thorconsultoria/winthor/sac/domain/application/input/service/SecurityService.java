package com.thorconsultoria.winthor.sac.domain.application.input.service;

import com.thorconsultoria.winthor.sac.domain.core.entities.User;

public interface SecurityService {
    User getAuthenticatedUser();
    boolean isTokenValid(String token);
}
