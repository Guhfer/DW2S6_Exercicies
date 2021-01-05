package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.repository;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
