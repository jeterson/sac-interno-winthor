package com.thorconsultoria.winthor.sac.application.rest;

import com.thorconsultoria.winthor.sac.domain.application.dto.datacontrolaccess.DataAccessControlRequest;
import com.thorconsultoria.winthor.sac.domain.application.input.service.DataAccessControlApplicationService;
import com.thorconsultoria.winthor.sac.domain.core.entities.DataAccessControl;
import com.thorconsultoria.winthor.sac.domain.core.valueobjects.DataAccessControlTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data-access-control")
@RequiredArgsConstructor
public class DataAccessControlController {

    private final DataAccessControlApplicationService dataAccessControlApplicationService;

    @GetMapping
    public ResponseEntity<DataAccessControl> getAccess(DataAccessControlRequest dataAccessControlRequest) {
        var access = dataAccessControlApplicationService.getDataAccess(dataAccessControlRequest);
        return ResponseEntity.ok(access);
    }
}
