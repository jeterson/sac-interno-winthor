package com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.repository;


import com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntity;
import com.thorconsultoria.winthor.sac.dataaccess.routineaccesscontrol.entity.RoutineAccessControlEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineAccessControlJpaRepository extends JpaRepository<RoutineAccessControlEntity, RoutineAccessControlEntityPK> {
}
