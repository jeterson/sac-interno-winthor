package com.thorconsultoria.winthor.sac.dataaccess.user.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class WinThorDecryptPasswordRepository {

    private final JdbcTemplate jdbcTemplate;

    public String decryptPassword(Integer id) {
        var sql = "SELECT decrypt(senhabd, usuariobd) senhabd FROM PCEMPR WHERE matricula = :id";
        try {


            var decryptedPassword = jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
                @Override
                public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        return rs.getString("senhabd");
                    }
                    return "";
                }
            }, id);

            return decryptedPassword;
        }catch (Exception ex){
            log.error("Error when decrypting WinThor password", ex);
            throw ex;
        }
    }
}
