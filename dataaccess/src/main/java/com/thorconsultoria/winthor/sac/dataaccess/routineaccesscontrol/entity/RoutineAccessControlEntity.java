package com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.entity;

import com.thorconsultoria.winthor.sac.dataaccess.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "PCCONTROI")
@Entity
public class RoutineAccessControlEntity {

    @EmbeddedId
    private RoutineAccessControlEntityPK id = new RoutineAccessControlEntityPK();

    @Getter
    @Setter
    @Column(name = "ACESSO")
    private String access;

    public void setRoutineCode(Integer routineCode) {
        id.setRoutineCode(routineCode);
    }
    public void setControlCode(Integer controlCode) {
        id.setControlCode(controlCode);
    }
    public void setUser(UserEntity user) {
        id.setUser(user);
    }
    public UserEntity getUser() {
        return id.getUser();
    }
    public Integer getRoutineCode() {
        return  id.getRoutineCode();
    }
    public Integer getControlCode() {
        return id.getControlCode();
    }
}
