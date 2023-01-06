package com.thorconsultoria.winthor.sac.dataaccess.dataaccesscontrol.entity;

import com.thorconsultoria.winthor.sac.dataaccess.user.entity.UserEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "PCLIB")
@Entity
public class DataAccessControlEntity {

    @EmbeddedId
    private DataAccessControlEntityPK id = new DataAccessControlEntityPK();

    public void setUser(UserEntity user) {
        id.setUser(user);
    }
    public void setTableId(String tableId) {
        id.setTableId(tableId);
    }
    public void setAlphaValue(String alphaValue) {
        id.setAlphaValue(alphaValue);
    }
    public void setNumberValue(Integer numberValue) {
        id.setNumberValue(numberValue);
    }
    public String getTableId() {
        return id.getTableId();
    }
    public String getAlphaValue() {
        return id.getAlphaValue();
    }
    public Integer getNumberValue() {
        return id.getNumberValue();
    }
    public UserEntity getUser() {
        return id.getUser();
    }
}
