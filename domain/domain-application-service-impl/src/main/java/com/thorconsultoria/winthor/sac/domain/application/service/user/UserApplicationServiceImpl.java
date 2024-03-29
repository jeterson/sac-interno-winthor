package com.thorconsultoria.winthor.sac.domain.application.service.user;

import com.thorconsultoria.winthor.sac.domain.application.input.service.UserApplicationService;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.UserRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import com.thorconsultoria.winthor.sac.domain.core.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("userApplicationService")
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if(user.isEmpty())
            throw new UserNotFoundException(username);

        user.get().removePassword();
        return user.get();

    }
}
