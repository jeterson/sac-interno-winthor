package com.thorconsultoria.winthor.sac.application.exception;

import com.thorconsultoria.winthor.sac.common.application.handler.ErrorDTO;
import com.thorconsultoria.winthor.sac.domain.core.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserApplicationExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(UserNotFoundException financialInstitutionNotFoundException) {
        log.error(financialInstitutionNotFoundException.getMessage(), financialInstitutionNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(financialInstitutionNotFoundException.getMessage())
                .build();
    }
}
