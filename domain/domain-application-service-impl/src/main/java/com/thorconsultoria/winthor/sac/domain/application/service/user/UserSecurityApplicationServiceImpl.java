package com.thorconsultoria.winthor.sac.domain.application.service.user;

import com.thorconsultoria.winthor.sac.domain.application.input.service.UserApplicationService;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.UserRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("userSecurityApplicationService")
@RequiredArgsConstructor
public class UserSecurityApplicationServiceImpl implements UserApplicationService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if(user.isPresent())
            return User.builder()
                    .id(user.get().getId())
                    .name(user.get().getName())
                    .username(user.get().getUsername().toLowerCase())
                    .password(user.get().getPassword().toLowerCase())
                    .build();

        return null;
    }
}
