package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.OrganizationMaster;

public interface OrganizationRepository extends JpaRepository<OrganizationMaster, Long> {

	@Modifying
	@Query("update OrganizationMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id);

	@Query("from OrganizationMaster accm")
	public List<OrganizationMaster> getAll();

	@Query("from OrganizationMaster accm where accm.userId =:userId and accm.isActive =:isActive")
	public List<OrganizationMaster> getAll(@Param("isActive") Boolean isActive);

	@Query("from OrganizationMaster accm where accm.userId =:userId and accm.isActive = true")
	public List<OrganizationMaster> getAll(@Param("userId") Long userId);

	@Query("from OrganizationMaster accm where accm.isActive =:isActive")
	public List<OrganizationMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from OrganizationMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public OrganizationMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("from OrganizationMaster accm")
	public List<OrganizationMaster> listByRange(Pageable pageable);

	@Query("from OrganizationMaster accm where accm.isActive =:isActive")
	public List<OrganizationMaster> listByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive);
}
