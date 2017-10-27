package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.CustomerMaster;

public interface CustomerRepository extends JpaRepository<CustomerMaster, Long>{

	@Modifying
	@Query("update CustomerMaster am set am.isActive = false,am.modifiedDate = NOW() where am.id =:id")
	public int setInActive(@Param("id") Long id);
	
	@Query( "from CustomerMaster am where isActive=true" )
	List<CustomerMaster> listAll();
	
	@Query( "from CustomerMaster am where isActive=true" )
	public List<CustomerMaster> listByRange(Pageable pageable);
}
