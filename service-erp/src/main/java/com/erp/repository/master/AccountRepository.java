package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.AccountMaster;

public interface AccountRepository extends JpaRepository<AccountMaster, Long> {

	@Modifying
	@Query("update AccountMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true and accm.userId =:userId")
	public int inActivate(@Param("id") Long id, @Param("userId") Long userId);

	@Modifying
	@Query("update AccountMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id);
	
	@Modifying
	@Query("update AccountMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true and accm.userId =:userId")
	public int inActivateByUserId(@Param("userId") Long userId);
	
	@Modifying
	@Query("update AccountMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.isActive = true")
	public int inActivateAll();

	@Query("from AccountMaster accm where accm.userId =:userId")
	public List<AccountMaster> getAll(@Param("userId") Long userId);

	@Query("from AccountMaster accm")
	public List<AccountMaster> getAll();

	@Query("from AccountMaster accm where accm.isActive =:isActive and accm.userId =:userId")
	public List<AccountMaster> getAllByStaus(@Param("isActive") Boolean isActive, @Param("userId") Long userId);

	@Query("from AccountMaster accm where accm.isActive =:isActive")
	public List<AccountMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from AccountMaster accm where accm.isActive =:isActive and accm.erpId =:id and accm.userId =:userId")
	public AccountMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive,
			@Param("userId") Long userId);

	@Query("select accm from AccountMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public AccountMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("from AccountMaster accm where accm.userId =:userId")
	public List<AccountMaster> getAllByRange(Pageable pageable, @Param("userId") Long userId);

	@Query("from AccountMaster accm")
	public List<AccountMaster> getAllByRange(Pageable pageable);

	@Query("from AccountMaster accm where accm.isActive =:isActive and accm.userId =:userId")
	public List<AccountMaster> getAllByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive,
			@Param("userId") Long userId);

	@Query("from AccountMaster accm where accm.isActive =:isActive")
	public List<AccountMaster> getAllByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive);

}
