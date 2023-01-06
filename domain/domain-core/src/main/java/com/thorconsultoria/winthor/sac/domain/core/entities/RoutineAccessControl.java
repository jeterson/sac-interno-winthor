package com.thorconsultoria.winthor.sac.domain.core.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoutineAccessControl {

    private User user;
    private Integer controlCode;
    private Integer routineCode;
    private boolean access;
}
