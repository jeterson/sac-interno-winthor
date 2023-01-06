package com.thorconsultoria.winthor.sac.domain.core.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;

    public void setPassword(String password) {
        this.password = password;
    }

    public void removePassword() {
        password = null;
    }
}
