package com.cdc.requisitionapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends CrudRepository<com.cdc.requisitionapi.entity.Requisition, Long> {

}
