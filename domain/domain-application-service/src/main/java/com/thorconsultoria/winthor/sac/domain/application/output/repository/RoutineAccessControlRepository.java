package com.thorconsultoria.winthor.sac.domain.application.output.repository;

import com.thorconsultoria.winthor.sac.domain.core.entities.RoutineAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;

import java.util.Optional;

public interface RoutineAccessControlRepository {

    Optional<RoutineAccessControl> findById(User user, Integer controlCode, Integer routineCode);
}
