package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.repository;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
