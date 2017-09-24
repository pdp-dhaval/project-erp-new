package com.erp.service.master;

import model.MasterModel;
import model.common.ErpResponse;
public interface MasterService {

	// for get single object from master table
	public ErpResponse get(Long id,Integer classId);
	
	// for get list of rows master table
	public ErpResponse list(Integer classId,Integer pageSize,Integer pageNo);
	
	// for inactive object of master table
	public ErpResponse inactive(Long id,Integer classId);
	
	public Boolean save(MasterModel request);
}
