package com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.entity;

import com.thorconsultoria.winthor.sac.dataaccess.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Data
public class RoutineAccessControlEntityPK implements Serializable {

    @Column(name = "CODCONTROLE")
    private Integer controlCode;
    @Column(name = "CODROTINA")
    private Integer routineCode;
    @ManyToOne
    @JoinColumn(name = "CODUSUARIO")
    private UserEntity user;
}
