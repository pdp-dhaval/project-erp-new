package com.erp.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.domain.master.OrganizationMaster;

public interface OrganizationRepository extends JpaRepository<OrganizationMaster, Long>{

}
