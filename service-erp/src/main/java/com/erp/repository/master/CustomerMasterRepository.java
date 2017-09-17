package com.erp.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.domain.master.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long>{

}
