package com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.adapter;

import com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntityPK;
import com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.mapper.RoutineAccessControlDataAccessMapper;
import com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.repository.RoutineAccessControlJpaRepository;
import com.thorconsultoria.winthor.sac.dataaccess.user.mapper.UserDataAccessMapper;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.RoutineAccessControlRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.RoutineAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoutineAccessControlRepositoryImpl implements RoutineAccessControlRepository {

    private final RoutineAccessControlJpaRepository routineAccessControlJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;
    private final RoutineAccessControlDataAccessMapper routineAccessControlDataAccessMapper;

    @Override
    public Optional<RoutineAccessControl> findById(User user, Integer controlCode, Integer routineCode) {
        var id = new RoutineAccessControlEntityPK();
        id.setRoutineCode(routineCode);
        id.setControlCode(controlCode);
        id.setUser(userDataAccessMapper.userToUserEntity(user));

        return routineAccessControlJpaRepository
                .findById(id)
                .map(routineAccessControlDataAccessMapper::entityToRoutineAccessControl);

    }
}
