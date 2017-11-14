package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.RouteMaster;

public interface RouteRepository extends JpaRepository<RouteMaster, Long> {

	@Modifying
	@Query("update RouteMaster accm set accm.isActive = false,accm.modifiedDate = NOW() where accm.erpId =:id and accm.isActive = true")
	public int inActivate(@Param("id") Long id);

	@Query("from RouteMaster accm")
	public List<RouteMaster> getAll();

	@Query("from RouteMaster accm where accm.userId =:userId and accm.isActive =:isActive")
	public List<RouteMaster> getAll(@Param("isActive") Boolean isActive);

	@Query("from RouteMaster accm where accm.userId =:userId and accm.isActive = true")
	public List<RouteMaster> getAll(@Param("userId") Long userId);

	@Query("from RouteMaster accm where accm.isActive =:isActive")
	public List<RouteMaster> getAllByStaus(@Param("isActive") Boolean isActive);

	@Query("select accm from RouteMaster accm where accm.isActive =:isActive and accm.erpId =:id")
	public RouteMaster getById(@Param("id") Long erpId, @Param("isActive") Boolean isActive);

	@Query("from RouteMaster accm")
	public List<RouteMaster> listByRange(Pageable pageable);

	@Query("from RouteMaster accm where accm.isActive =:isActive")
	public List<RouteMaster> listByRangeAndStatus(Pageable pageable, @Param("isActive") Boolean isActive);
}
