package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.AccountMaster;

public interface AccountRepository extends JpaRepository<AccountMaster, Long>{

	@Modifying
	@Query("update AccountMaster am set am.isActive = false,am.modifiedDate = NOW() where am.id =:id")
	public int setInActive(@Param("id") Long id);

	@Query( "from AccountMaster am where isActive=true" )
	List<AccountMaster> listAll();

	@Query( "from AccountMaster am where isActive=true" )
	public List<AccountMaster> listByRange(Pageable pageable);
	
}
