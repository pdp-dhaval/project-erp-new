package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.ProductMaster;

public interface ProductRepository extends JpaRepository<ProductMaster, Long>{

	@Modifying
	@Query("update ProductMaster am set am.isActive = false,am.modifiedDate = NOW() where am.id =:id")
	public int setInActive(@Param("id") Long id);
	
	@Query( "from AccountMaster am where isActive=true" )
	List<ProductMaster> listAll();
	
	@Query( "from ProductMaster am where isActive=true" )
	public List<ProductMaster> listByRange(Pageable pageable);
}
