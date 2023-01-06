package com.thorconsultoria.winthor.sac.domain.application.dto.routinecontrolaccess;


public interface CheckPermissionControlAccessRequest {
    Integer getControlCode();
    Integer getRoutineCode();
    Integer getUserId();
}
