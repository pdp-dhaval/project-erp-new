package com.erp.service.master;

import com.erp.model.common.ErpResponse;
import com.erp.model.master.MasterModel;
import com.erp.model.master.MasterRequest;

public interface MasterService {

	// for get single object from master table
	public ErpResponse get(MasterRequest masterRequest) throws Exception;

	// for get list of rows master table
	public ErpResponse list(MasterRequest masterRequest) throws Exception;

	// for inactive object of master table
	public ErpResponse inactive(MasterRequest masterRequest) throws Exception;

	public boolean save(MasterModel request) throws Exception;
}
