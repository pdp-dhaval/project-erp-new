package com.erp.service.master.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.erp.controller.master.MasterController;
import com.erp.domain.master.AccountMaster;
import com.erp.repository.master.AccountMasterRepository;
import com.erp.service.master.MasterService;

import model.AccountMasterRequest;
import model.ErpResponse;
import utils.CommonUtils;

@Service
public class MasterServiceImpl implements MasterService{

	private static Logger log = LoggerFactory.getLogger(MasterController.class);
	
	@Autowired
	private AccountMasterRepository accountMasterRepository;

	@Override
	public ErpResponse get(Long id, Integer classId) {
		// TODO Auto-generated method stub
		
		try {
			
			switch (classId) {
			case 1:
			{
				// for get Account Master Details
				AccountMasterRequest accountMasterRequest = new AccountMasterRequest();
				AccountMaster accountMaster=accountMasterRepository.findOne(id);
				BeanUtils.copyProperties(accountMaster, accountMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESS, HttpStatus.OK.value());
				res.setData(accountMasterRequest);
				return res; 
				
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			log.error("error while fetching master detail");
			return new ErpResponse("Error while fetching master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		return null;
	}

	@Override
	public ErpResponse list(Integer classId, Integer startNo, Integer endNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErpResponse inactive(Long id, Integer classId) {
		// TODO Auto-generated method stub
		
		try {
			
			switch (classId) {
			case 1:
			{
				// for inactive Account Master Details
				AccountMasterRequest accountMasterRequest = new AccountMasterRequest();
				AccountMaster accountMaster=accountMasterRepository.findOne(id);
				BeanUtils.copyProperties(accountMaster, accountMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESS, HttpStatus.OK.value());
				res.setData(accountMasterRequest);
				return res; 
				
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			log.error("error while fetching master detail");
			return new ErpResponse("Error while fetching master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	
		return null;
	}
}
	
			

