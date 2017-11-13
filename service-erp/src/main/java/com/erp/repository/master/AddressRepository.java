package com.erp.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.domain.master.AddressMaster;

public interface AddressRepository extends JpaRepository<AddressMaster, Long>{

//	@Modifying
//	@Query("update AddressMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
//	public int inActivate(@Param("id") Long id);
//
//	@Query("from AddressMaster accm")
//	public List<AddressMaster> getAll();
//
//	@Query("from AddressMaster accm where accm.isActive =:isActive")
//	public List<AddressMaster> getAllByStaus(@Param("isActive") Boolean isActive);
//
//	@Query("select accm from AddressMaster accm where accm.isActive =:isActive and accm.erpId =:id")
//	public AddressMaster getById(@Param("id") Long erpId,@Param("isActive") Boolean isActive);
//
//	@Query("from AddressMaster accm")
//	public List<AddressMaster> listByRange(Pageable pageable);
//
//	@Query("from AddressMaster accm where accm.isActive =:isActive")
//	public List<AddressMaster> listByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive);
}
