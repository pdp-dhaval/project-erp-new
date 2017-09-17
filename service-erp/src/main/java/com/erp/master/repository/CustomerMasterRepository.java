package com.erp.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.master.domain.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long>{

}
