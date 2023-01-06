package com.thorconsultoria.winthor.sac.domain.application.input.service;

import com.thorconsultoria.winthor.sac.domain.application.dto.datacontrolaccess.DataAccessControlRequest;
import com.thorconsultoria.winthor.sac.domain.core.entities.DataAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import com.thorconsultoria.winthor.sac.domain.core.valueobjects.DataAccessControlTable;

public interface DataAccessControlApplicationService {

    boolean hasAccess(DataAccessControlTable table, User user, String alphaValue);

    boolean hasAccess(DataAccessControlTable table, User user, Integer numberValue);
    boolean hasAccess(DataAccessControlTable table, Integer numberValue);
    boolean hasAccess(DataAccessControlTable table, String alphaValue);
    DataAccessControl getDataAccess(DataAccessControlTable table, User user);
    DataAccessControl getDataAccess(DataAccessControlTable table);

    DataAccessControl getDataAccess(DataAccessControlRequest dataAccessControlRequest);
}
