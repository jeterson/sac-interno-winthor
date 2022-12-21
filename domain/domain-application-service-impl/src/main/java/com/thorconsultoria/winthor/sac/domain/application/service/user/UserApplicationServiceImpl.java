package com.thorconsultoria.winthor.sac.domain.application.service.user;

import com.thorconsultoria.winthor.sac.domain.application.input.service.UserApplicationService;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.UserRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return User.builder()
                    .id(user.get().getId())
                    .username(user.get().getUsername())
                    .password(user.get().getPassword())
                    .name(user.get().getName())
                    .build();
        }
        return null;
    }
}
