package com.thorconsultoria.winthor.sac.domain.core.exception;

public class UserNotFoundException extends UserDomainException{

    public UserNotFoundException(Integer id) {
        this("User with id " + id + " not found");
    }
    public UserNotFoundException(String username) {
        super("User with username " + username + " not found");
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
