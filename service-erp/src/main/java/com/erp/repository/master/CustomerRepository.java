package com.erp.repository.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.CustomerMaster;

public interface CustomerRepository extends JpaRepository<CustomerMaster, Long> {

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true and accm.organizationId =:organizationId")
	public int inActivate(@Param("id") Long id, @Param("organizationId") Long organizationId);

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id);

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.organizationId =:organizationId")
	public int inActivateByOrgId(@Param("organizationId") Long organizationId);

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.organizationId IN :organizationIds")
	public int inActivateByOrgIds(@Param("organizationIds") List<Long> organizationIds);

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.userId IN :userIds")
	public int inActivateByUserIds(@Param("userIds") List<Long> userIds);

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.userId =:userId")
	public int inActivateByUserId(@Param("userId") Long userId);

	@Modifying
	@Query("update CustomerMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true")
	public int inActivateAll();

	@Query("from CustomerMaster accm where accm.organizationId =:organizationId")
	public List<CustomerMaster> getAll(@Param("organizationId") Long organizationId);

	@Query("from CustomerMaster accm where accm.organizationId IN :organizationIds and accm.isActive =:isActive")
	public List<CustomerMaster> getAllByOrgIdsAndStatus(@Param("organizationIds") List<Long> organizationIds,
			@Param("isActive") Boolean isActive);

	@Query("from CustomerMaster accm where accm.organizationId IN :organizationIds")
	public List<CustomerMaster> getAllByOrgIds(@Param("organizationIds") List<Long> organizationIds);

	@Query("from CustomerMaster accm")
	public List<CustomerMaster> getAll();

	@Query("from CustomerMaster accm where accm.userId =:userId")
	public List<CustomerMaster> getAllByUserId(@Param("userId") Long userId);

	@Query("from CustomerMaster accm where accm.userId =:userId and accm.isActive =:isActive")
	public List<CustomerMaster> getAllByUserId(@Param("userId") Long userId, @Param("isActive") Boolean isActive);

//	@Query("from CustomerMaster accm where accm.isActive =:isActive and accm.organizationId =:organizationId")
//	public List<CustomerMaster> getAllByStaus(@Param("isActive") Boolean isActive,
//			@Param("organizationId") Long organizationId);

	@Query("from CustomerMaster accm where accm.isActive =:isActive")
	public List<CustomerMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from CustomerMaster accm where accm.isActive =:isActive and accm.erpId =:id and accm.organizationId =:organizationId")
	public CustomerMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive,
			@Param("organizationId") Long organizationId);

	@Query("select accm from CustomerMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public CustomerMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("select accm from CustomerMaster accm where accm.isActive = true and accm.erpId =:id")
	public CustomerMaster getById(@Param("id") Long erpId);

	// @Query("from CustomerMaster accm where accm.organizationId =:organizationId")
	// public List<CustomerMaster> getAllByRange(Pageable pageable,
	// @Param("organizationId") Long organizationId);
	//
	// @Query("from CustomerMaster accm")
	// public List<CustomerMaster> getAllByRange(Pageable pageable);
	//
	// @Query("from CustomerMaster accm where accm.isActive =:isActive and
	// accm.organizationId =:organizationId")
	// public List<CustomerMaster> getAllByRangeAndStatus(Pageable pageable,
	// @Param("isActive") Boolean isActive,
	// @Param("organizationId") Long organizationId);
	//
	// @Query("from CustomerMaster accm where accm.isActive =:isActive")
	// public List<CustomerMaster> getAllByRangeAndStatus(Pageable pageable,
	// @Param("isActive") Boolean isActive);
}
