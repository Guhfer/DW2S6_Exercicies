package com.br.ifsp.dw2.taskmanager.repository;

import com.br.ifsp.dw2.taskmanager.entity.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
}
