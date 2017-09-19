package com.erp.service.master.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.controller.master.MasterController;
import com.erp.domain.master.AccountMaster;
import com.erp.domain.master.AddressMaster;
import com.erp.domain.master.CategoryMaster;
import com.erp.domain.master.CompanyMaster;
import com.erp.domain.master.CustomerMaster;
import com.erp.domain.master.ProductMaster;
import com.erp.domain.master.RouteMaster;
import com.erp.repository.master.AccountMasterRepository;
import com.erp.repository.master.AddressMasterRepository;
import com.erp.repository.master.CategoryMasterRepository;
import com.erp.repository.master.CompanyMasterRepository;
import com.erp.repository.master.CustomerMasterRepository;
import com.erp.repository.master.ProductMasterRepository;
import com.erp.repository.master.RouteMasterRepository;
import com.erp.service.master.MasterService;

import model.AccountMasterRequest;
import model.AddressMasterRequest;
import model.CategoryMasterRequest;
import model.CompanyMasterRequest;
import model.CustomerMasterRequest;
import model.ErpResponse;
import model.ProductMasterRequest;
import model.RouteMasterRequest;
import utils.CommonUtils;

@Service
@Transactional
public class MasterServiceImpl implements MasterService{

	private static Logger log = LoggerFactory.getLogger(MasterController.class);
	
	@Autowired
	private AccountMasterRepository accountMasterRepository;
	
	@Autowired
	private AddressMasterRepository addressMasterRepository;
	
	@Autowired
	private CategoryMasterRepository categoryMasterRepository;
	
	@Autowired
	private CompanyMasterRepository companyMasterRepository;
	
	@Autowired
	private CustomerMasterRepository customerMasterRepository;
	
	@Autowired
	private ProductMasterRepository productMasterRepository;
	
	@Autowired
	private RouteMasterRepository routeMasterRepository;
	

	@Override
	public ErpResponse get(Long id, Integer classId) {
		// TODO Auto-generated method stub
		
		try {
			
			switch (classId) {
			case 1:
			{
				// for get AccountMasterRequest Details
				AccountMasterRequest accountMasterRequest = new AccountMasterRequest();
				AccountMaster accountMaster=accountMasterRepository.findOne(id);
				BeanUtils.copyProperties(accountMaster, accountMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(accountMasterRequest);
				return res; 
				
			}
			case 2:
			{
				// for get AddressMasterRequest Details
				AddressMasterRequest addressMasterRequest = new AddressMasterRequest();
				AddressMaster addressMaster=addressMasterRepository.findOne(id);
				BeanUtils.copyProperties(addressMaster, addressMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(addressMasterRequest);
				return res; 
				
			}
			case 3:
			{
				// for get CategoryMasterRequest Details
				CategoryMasterRequest categoryMasterRequest = new CategoryMasterRequest();
				CategoryMaster categoryMaster=categoryMasterRepository.findOne(id);
				BeanUtils.copyProperties(categoryMaster, categoryMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(categoryMasterRequest);
				return res; 
				
			}
			case 4:
			{
				// for get CompanyMasterRequest Details
				CompanyMasterRequest companyMasterRequest = new CompanyMasterRequest();
				CompanyMaster companyMaster=companyMasterRepository.findOne(id);
				BeanUtils.copyProperties(companyMaster, companyMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(companyMasterRequest);
				return res; 
				
			}
			case 5:
			{
				// for get CustomerMasterRequest Details
				CustomerMasterRequest customerMasterRequest = new CustomerMasterRequest();
				CustomerMaster customerMaster=customerMasterRepository.findOne(id);
				BeanUtils.copyProperties(customerMaster, customerMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(customerMasterRequest);
				return res; 
				
			}
			case 6:
			{
				// for get ProductMasterRequest Details
				ProductMasterRequest productMasterRequest = new ProductMasterRequest();
				ProductMaster productMaster=productMasterRepository.findOne(id);
				BeanUtils.copyProperties(productMaster, productMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(productMasterRequest);
				return res; 
				
			}
			case 7:
			{
				// for get RouteMasterRequest Details
				RouteMasterRequest routeMasterRequest = new RouteMasterRequest();
				RouteMaster routeMaster=routeMasterRepository.findOne(id);
				BeanUtils.copyProperties(routeMaster, routeMasterRequest);
				
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(routeMaster);
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
		
		
		try {
			
			switch (classId) {
			case 1:
			{
				List<AccountMasterRequest> listOfAccountMasterRequest=new ArrayList<AccountMasterRequest>();
				List<AccountMaster> listOfAccountMaster=new ArrayList<AccountMaster>();
				if(startNo == -1 || endNo == -1)
				{
					listOfAccountMaster=accountMasterRepository.listAll();
				}
				else
				{
					//listOfAccountMaster=accountMasterRepository.listByStartNoAndEndNo(startNo,endNo);
					listOfAccountMaster=accountMasterRepository.listAll();
				}

				for(AccountMaster accountMaster:listOfAccountMaster)
				{
					AccountMasterRequest accountMasterRequest=new AccountMasterRequest();
					BeanUtils.copyProperties(accountMaster, accountMasterRequest);
					listOfAccountMasterRequest.add(accountMasterRequest);
				}
				
				ErpResponse res=new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfAccountMasterRequest);
				return res; 
			}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("error while fetching list of master detail");
			return new ErpResponse("Error while fetching list of master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return null;
	}

	@Override
	public ErpResponse inactive(Long id, Integer classId) {
		// TODO Auto-generated method stub
		
		try {
			
			switch (classId) {
			case 1:
			{
				int count=accountMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			case 2:
			{
				int count=addressMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			case 3:
			{
				int count=categoryMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			case 4:
			{
				int count=companyMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			case 5:
			{
				int count=customerMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			case 6:
			{
				int count=productMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			case 7:
			{
				int count=routeMasterRepository.setInActive(id);
				ErpResponse res=new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res; 
				
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			log.error("error while set inactive master detail");
			return new ErpResponse("Error while set inactive master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	
		return null;
	}
}
	
			

