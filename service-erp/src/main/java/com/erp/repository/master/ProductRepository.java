package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.ProductMaster;

public interface ProductRepository extends JpaRepository<ProductMaster, Long> {

	@Modifying
	@Query("update ProductMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id);

	@Query("from ProductMaster accm")
	public List<ProductMaster> getAll();

	@Query("from ProductMaster accm where accm.organizationId =:organizationId and accm.isActive =:isActive")
	public List<ProductMaster> getAll(@Param("isActive") Boolean isActive);

	@Query("from ProductMaster accm where accm.organizationId =:organizationId")
	public List<ProductMaster> getAll(@Param("organizationId") Long organizationId);

	@Query("from ProductMaster accm where accm.isActive =:isActive")
	public List<ProductMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from ProductMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public ProductMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("from ProductMaster accm where accm.organizationId =:organizationId")
	public List<ProductMaster> listByRange(Pageable pageable, @Param("organizationId") Long organizationId);

	@Query("from ProductMaster accm where accm.isActive =:isActive and accm.organizationId =:organizationId")
	public List<ProductMaster> listByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive,
			@Param("organizationId") Long organizationId);
}
