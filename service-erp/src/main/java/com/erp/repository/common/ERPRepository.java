package com.erp.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.domain.master.ErpMstr;

public interface ERPRepository extends JpaRepository<ErpMstr, Long> {

}
