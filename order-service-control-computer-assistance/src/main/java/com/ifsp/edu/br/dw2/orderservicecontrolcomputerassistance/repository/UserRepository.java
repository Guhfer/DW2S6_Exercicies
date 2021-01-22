package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.repository;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
