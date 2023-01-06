package com.thorconsultoria.winthor.sac.dataaccess.dataaccesscontrol.adapter;

import com.thorconsultoria.winthor.sac.dataaccess.dataaccesscontrol.mapper.DataAccessControlDataAccessMapper;
import com.thorconsultoria.winthor.sac.dataaccess.dataaccesscontrol.repository.DataAccessControlJpaRepository;
import com.thorconsultoria.winthor.sac.dataaccess.user.mapper.UserDataAccessMapper;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.DataAccessControlRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.DataAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import com.thorconsultoria.winthor.sac.domain.core.valueobjects.DataAccessControlTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@RequiredArgsConstructor
public class DataAccessControlRepositoryImpl implements DataAccessControlRepository{

    private final DataAccessControlJpaRepository dataAccessControlJpaRepository;
    private final DataAccessControlDataAccessMapper dataAccessControlDataAccessMapper;
    private final UserDataAccessMapper userDataAccessMapper;


    @Override
    public DataAccessControl getDataAccess(DataAccessControlTable table, User user) {
        var items = dataAccessControlJpaRepository.findByUserAndTable(userDataAccessMapper.userToUserEntity(user), table.getValue());
        var dataAccessControl = dataAccessControlDataAccessMapper.entityToDataAccessControl(items, table, user);
        return dataAccessControl;
    }
}
