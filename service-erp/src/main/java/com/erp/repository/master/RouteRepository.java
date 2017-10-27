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
	@Query("update RouteMaster am set am.isActive = false,am.modifiedDate = NOW() where am.id =:id")
	public int setInActive(@Param("id") Long id);

	@Query("from RouteMaster am where am.isActive = true")
	List<RouteMaster> listAll();

	@Query("from RouteMaster am where am.isActive = true")
	public List<RouteMaster> listByRange(Pageable pageable);
}
