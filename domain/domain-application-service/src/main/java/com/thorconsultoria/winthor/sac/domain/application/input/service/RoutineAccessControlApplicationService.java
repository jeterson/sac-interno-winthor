package com.thorconsultoria.winthor.sac.domain.application.input.service;

import com.thorconsultoria.winthor.sac.domain.application.dto.routinecontrolaccess.CheckPermissionControlAccessRequest;

public interface RoutineAccessControlApplicationService {

    boolean hasAccess(CheckPermissionControlAccessRequest request);

}
