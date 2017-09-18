package com.erp.service.master;

import model.ErpResponse;

public interface MasterService {

	// for get single object from master table
	public ErpResponse get(Long id,Integer classId);
	
	// for get list of rows master table
	public ErpResponse list(Integer classId,Integer startNo,Integer endNo);
	
	// for inactive object of master table
	public ErpResponse inactive(Long id,Integer classId);
}
