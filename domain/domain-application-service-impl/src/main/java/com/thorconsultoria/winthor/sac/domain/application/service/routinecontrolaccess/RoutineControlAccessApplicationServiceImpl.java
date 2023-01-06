package com.thorconsultoria.winthor.sac.domain.application.service.routinecontrolaccess;

import com.thorconsultoria.winthor.sac.domain.application.dto.routinecontrolaccess.CheckPermissionControlAccessRequest;
import com.thorconsultoria.winthor.sac.domain.application.input.service.RoutineAccessControlApplicationService;
import com.thorconsultoria.winthor.sac.domain.application.input.service.SecurityService;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.RoutineAccessControlRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoutineControlAccessApplicationServiceImpl implements RoutineAccessControlApplicationService {

    private final RoutineAccessControlRepository routineAccessControlRepository;
    private final SecurityService securityService;

    @Override
    public boolean hasAccess(CheckPermissionControlAccessRequest request) {
        var userId = request.getUserId() == null ? securityService.getAuthenticatedUser().getId() : request.getUserId();

        var user = User.builder().id(userId).build();

        var routineControlAccess = routineAccessControlRepository.findById(user, request.getControlCode(), request.getRoutineCode());
        if(routineControlAccess.isEmpty())
            return false;

        return routineControlAccess.get().isAccess();
    }
}
