package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.CategoryMaster;

public interface CategoryRepository extends JpaRepository<CategoryMaster, Long> {

	@Modifying
	@Query("update CategoryMaster accm set accm.isActive = false,accm.modifiedDate = NOW(),accm.modifiedBy =:modifiedBy where accm.erpId =:id and accm.isActive = true and accm.organizationId =:organizationId")
	public int inActivate(@Param("id") Long id, @Param("organizationId") Long organizationId,
			@Param("modifiedBy") Long modifiedBy);

	@Modifying
	@Query("update CategoryMaster accm set accm.isActive = false,accm.modifiedDate = NOW(),accm.modifiedBy =:modifiedBy where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id, @Param("modifiedBy") Long modifiedBy);

	@Modifying
	@Query("update CategoryMaster accm set accm.isActive = false,accm.modifiedDate = NOW(),accm.modifiedBy =:modifiedBy where accm.isActive = true and accm.organizationId =:organizationId")
	public int inActivateByOrgId(@Param("organizationId") Long organizationId, @Param("modifiedBy") Long modifiedBy);

	@Modifying
	@Query("update CategoryMaster accm set accm.isActive = false,accm.modifiedDate = NOW(),accm.modifiedBy =:modifiedBy where accm.isActive = true and accm.organizationId IN :organizationIds")
	public int inActivateByOrgIds(@Param("organizationIds") List<Long> organizationIds,
			@Param("modifiedBy") Long modifiedBy);

	@Modifying
	@Query("update CategoryMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true")
	public int inActivateAll();

	@Query("from CategoryMaster accm where accm.organizationId =:organizationId")
	public List<CategoryMaster> getAll(@Param("organizationId") Long organizationId);

	@Query("from CategoryMaster accm where accm.organizationId IN :organizationIds and accm.isActive =:isActive")
	public List<CategoryMaster> getAll(@Param("organizationIds") List<Long> organizationIds,
			@Param("isActive") Boolean isActive);

	@Query("from CategoryMaster accm where accm.organizationId IN :organizationIds")
	public List<CategoryMaster> getAll(@Param("organizationIds") List<Long> organizationIds);

	@Query("from CategoryMaster accm")
	public List<CategoryMaster> getAll();

	@Query("from CategoryMaster accm where accm.isActive =:isActive and accm.organizationId =:organizationId")
	public List<CategoryMaster> getAllByStaus(@Param("isActive") Boolean isActive,
			@Param("organizationId") Long organizationId);

	@Query("from CategoryMaster accm where accm.isActive =:isActive")
	public List<CategoryMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from CategoryMaster accm where accm.isActive =:isActive and accm.erpId =:id and accm.organizationId =:organizationId")
	public CategoryMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive,
			@Param("organizationId") Long organizationId);

	@Query("select accm from CategoryMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public CategoryMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("select accm from CategoryMaster accm where accm.isActive = true and accm.erpId =:id")
	public CategoryMaster getById(@Param("id") Long erpId);

	// @Query("from CategoryMaster accm where accm.organizationId =:organizationId")
	// public List<CategoryMaster> getAllByRange(Pageable pageable,
	// @Param("organizationId") Long organizationId);
	//
	// @Query("from CategoryMaster accm")
	// public List<CategoryMaster> getAllByRange(Pageable pageable);
	//
	@Query("from CategoryMaster accm where accm.isActive =:isActive and accm.organizationId =:organizationId")
	public List<CategoryMaster> getAllByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive,
			@Param("organizationId") Long organizationId);
	//
	// @Query("from CategoryMaster accm where accm.isActive =:isActive")
	// public List<CategoryMaster> getAllByRangeAndStatus(Pageable pageable,
	// @Param("isActive") Boolean isActive);
}
