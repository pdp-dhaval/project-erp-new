package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.CompanyMaster;

public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Long>{

	@Modifying
	@Query("update CompanyMaster am set am.isActive = false,am.modifiedDate = NOW() where am.id =:id")
	public int setInActive(@Param("id") Long id);
	
	@Query( "from CompanyMaster am where isActive=true" )
	List<CompanyMaster> listAll();
	
	@Query( "from CompanyMaster am where isActive=true" )
	public List<CompanyMaster> listByRange(Pageable pageable);
}
