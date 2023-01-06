package com.thorconsultoria.winthor.sac.domain.application.output.repository;

import com.thorconsultoria.winthor.sac.domain.core.entities.DataAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import com.thorconsultoria.winthor.sac.domain.core.valueobjects.DataAccessControlTable;

public interface DataAccessControlRepository {

    DataAccessControl getDataAccess(DataAccessControlTable table, User user);
}
