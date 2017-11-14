package com.erp.repository.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.CompanyMaster;

public interface CompanyRepository extends JpaRepository<CompanyMaster, Long> {

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true and accm.organizationId =:organizationId")
	public int inActivate(@Param("id") Long id, @Param("organizationId") Long organizationId);

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id);

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.organizationId =:organizationId")
	public int inActivateByOrgId(@Param("organizationId") Long organizationId);

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.organizationId IN :organizationIds")
	public int inActivateByOrgIds(@Param("organizationIds") List<Long> organizationIds);

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.userId IN :userIds")
	public int inActivateByUserIds(@Param("userIds") List<Long> userIds);

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.userId =:userId")
	public int inActivateByUserId(@Param("userId") Long userId);

	@Modifying
	@Query("update CompanyMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true")
	public int inActivateAll();

	@Query("from CompanyMaster accm where accm.organizationId =:organizationId")
	public List<CompanyMaster> getAll(@Param("organizationId") Long organizationId);

	@Query("from CompanyMaster accm where accm.organizationId IN :organizationIds and accm.isActive =:isActive")
	public List<CompanyMaster> getAllByOrgIdsAndStatus(@Param("organizationIds") List<Long> organizationIds,
			@Param("isActive") Boolean isActive);

	@Query("from CompanyMaster accm where accm.organizationId IN :organizationIds")
	public List<CompanyMaster> getAllByOrgIds(@Param("organizationIds") List<Long> organizationIds);

	@Query("from CompanyMaster accm")
	public List<CompanyMaster> getAll();

	@Query("from CompanyMaster accm where accm.userId =:userId")
	public List<CompanyMaster> getAllByUserId(@Param("userId") Long userId);

	@Query("from CompanyMaster accm where accm.userId =:userId and accm.isActive =:isActive")
	public List<CompanyMaster> getAllByUserId(@Param("userId") Long userId, @Param("isActive") Boolean isActive);

	// @Query("from CompanyMaster accm where accm.isActive =:isActive and
	// accm.organizationId =:organizationId")
	// public List<CompanyMaster> getAllByStaus(@Param("isActive") Boolean isActive,
	// @Param("organizationId") Long organizationId);

	@Query("from CompanyMaster accm where accm.isActive =:isActive")
	public List<CompanyMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from CompanyMaster accm where accm.isActive =:isActive and accm.erpId =:id and accm.organizationId =:organizationId")
	public CompanyMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive,
			@Param("organizationId") Long organizationId);

	@Query("select accm from CompanyMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public CompanyMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("select accm from CompanyMaster accm where accm.isActive = true and accm.erpId =:id")
	public CompanyMaster getById(@Param("id") Long erpId);

	// @Query("from CompanyMaster accm where accm.organizationId =:organizationId")
	// public List<CompanyMaster> getAllByRange(Pageable pageable,
	// @Param("organizationId") Long organizationId);
	//
	// @Query("from CompanyMaster accm")
	// public List<CompanyMaster> getAllByRange(Pageable pageable);
	//
	// @Query("from CompanyMaster accm where accm.isActive =:isActive and
	// accm.organizationId =:organizationId")
	// public List<CompanyMaster> getAllByRangeAndStatus(Pageable pageable,
	// @Param("isActive") Boolean isActive,
	// @Param("organizationId") Long organizationId);
	//
	// @Query("from CompanyMaster accm where accm.isActive =:isActive")
	// public List<CompanyMaster> getAllByRangeAndStatus(Pageable pageable,
	// @Param("isActive") Boolean isActive);
}
