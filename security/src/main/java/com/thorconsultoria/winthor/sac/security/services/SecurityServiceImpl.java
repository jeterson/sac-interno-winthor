package com.thorconsultoria.winthor.sac.security.services;

import com.thorconsultoria.winthor.sac.domain.application.input.service.SecurityService;
import com.thorconsultoria.winthor.sac.domain.application.input.service.UserApplicationService;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import com.thorconsultoria.winthor.sac.security.UserDetailsData;
import com.thorconsultoria.winthor.sac.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.RuntimeMBeanException;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserApplicationService userApplicationService;

    @Override
    public User getAuthenticatedUser() {
        if(SecurityContextHolder.getContext().getAuthentication() == null)
            throw new RuntimeException("No one user authenticated");

        var username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(username == null)
            throw new RuntimeException("Username not found in authentication");

        var user = userApplicationService.findByUsername(username);

        return user;
    }

    @Override
    public boolean isTokenValid(String token) {
        if(token == null || token.isEmpty() || token.isBlank())
            return false;

        return JwtUtils.getInstance().isTokenValid(token);
    }
}
