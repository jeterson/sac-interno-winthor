package com.thorconsultoria.winthor.sac.domain.core.exception;

import com.thorconsultoria.winthor.sac.common.domain.exception.DomainException;

public class UserDomainException extends DomainException {

    public UserDomainException(String message) {
        super(message);
    }

    public UserDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
