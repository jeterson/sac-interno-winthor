package com.thorconsultoria.winthor.sac.domain.core.entities;


import lombok.*;

@Getter
@Builder
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
