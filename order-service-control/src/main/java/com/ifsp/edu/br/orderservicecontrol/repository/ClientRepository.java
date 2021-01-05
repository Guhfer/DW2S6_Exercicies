package com.ifsp.edu.br.orderservicecontrol.repository;

import com.ifsp.edu.br.orderservicecontrol.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
