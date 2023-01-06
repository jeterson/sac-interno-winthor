package com.thorconsultoria.winthor.sac.domain.application.service.dataaccesscontrol;

import com.thorconsultoria.winthor.sac.domain.application.dto.datacontrolaccess.DataAccessControlRequest;
import com.thorconsultoria.winthor.sac.domain.application.input.service.DataAccessControlApplicationService;
import com.thorconsultoria.winthor.sac.domain.application.input.service.SecurityService;
import com.thorconsultoria.winthor.sac.domain.application.output.repository.DataAccessControlRepository;
import com.thorconsultoria.winthor.sac.domain.core.entities.DataAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.entities.User;
import com.thorconsultoria.winthor.sac.domain.core.valueobjects.DataAccessControlTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataAccessControlApplicationServiceImpl implements DataAccessControlApplicationService {

    private final DataAccessControlRepository dataAccessControlRepository;
    private final SecurityService securityService;

    @Override
    public boolean hasAccess(DataAccessControlTable table, User user, String alphaValue) {
        var items = dataAccessControlRepository.getDataAccess(table, user);
        if(items.isEmpty())
            return false;

        if(items.containsAlphaCodes()){
            return items.getAlphaCode().contains(alphaValue);
        }
        return false;


    }

    @Override
    public boolean hasAccess(DataAccessControlTable table, User user, Integer numberValue) {
        var items = dataAccessControlRepository.getDataAccess(table, user);
        if(items.isEmpty())
            return false;

        if(items.containsNumberCodes()){
            return items.getNumberCode().contains(numberValue);
        }
        return false;
    }

    @Override
    public boolean hasAccess(DataAccessControlTable table, Integer numberValue) {
       var user = securityService.getAuthenticatedUser();
       return hasAccess(table, user, numberValue);
    }

    @Override
    public boolean hasAccess(DataAccessControlTable table, String alphaValue) {
        var user = securityService.getAuthenticatedUser();
        return hasAccess(table, user, alphaValue);
    }

    @Override
    public DataAccessControl getDataAccess(DataAccessControlTable table, User user) {
        var control = dataAccessControlRepository.getDataAccess(table, user);
        return control;
    }

    @Override
    public DataAccessControl getDataAccess(DataAccessControlTable table) {
        var user = securityService.getAuthenticatedUser();
        var control = dataAccessControlRepository.getDataAccess(table, user);
        return control;
    }

    @Override
    public DataAccessControl getDataAccess(DataAccessControlRequest dataAccessControlRequest) {
        User user = null;
        if(dataAccessControlRequest.getUserId() == null)
            user = securityService.getAuthenticatedUser();
        else
            user = User.builder().id(dataAccessControlRequest.getUserId()).build();


        var table = getDataAccessTable(dataAccessControlRequest.getTableId());

        return getDataAccess(table, user);

    }

    private DataAccessControlTable getDataAccessTable(String tableId) {
        try {
            return DataAccessControlTable.valueOf(tableId);
        }catch (IllegalArgumentException ex) {
            if(DataAccessControlTable.of(tableId) == null)
                return DataAccessControlTable.NONE;
            return DataAccessControlTable.of(tableId);

        }
    }
}
