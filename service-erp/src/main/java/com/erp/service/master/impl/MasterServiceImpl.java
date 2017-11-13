package com.erp.service.master.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.controller.master.MasterController;
import com.erp.exception.ErpException;
import com.erp.model.common.ErpResponse;
import com.erp.model.master.CategoryRequest;
import com.erp.model.master.MasterModel;
import com.erp.model.master.MasterRequest;
import com.erp.service.master.CategoryService;
import com.erp.service.master.MasterService;

import utils.CommonUtils;
import utils.CommonUtils.Master;
import utils.MultipleJSONObjectHelper;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

	private static Logger logger = Logger.getLogger(MasterController.class.getName());

	@Autowired
	private CategoryService categoryService;

	@Override
	public ErpResponse get(MasterRequest masterRequest) throws Exception {
		logger.log(Level.INFO, "Start get() Method");

		try {
			Master masterType = CommonUtils.Master.getType(masterRequest.getClassId());
			if (masterType == null) {
				return new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			switch (masterType) {
			case CATEGORY_MASTER: {
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
						categoryService.getById(masterRequest.getId(), true, masterRequest.getUserData()));
			}
			// case COMPANY_MASTER: {
			// // for get CompanyMasterRequest Details
			// CompanyMaster companyMaster = companyMasterRepository.findOne(id);
			// if (!CommonUtils.isObjectNullOrEmpty(companyMaster)) {
			// CompanyRequest companyMasterRequest = new CompanyRequest();
			// BeanUtils.copyProperties(companyMaster, companyMasterRequest);
			// ErpResponse res = new ErpResponse(CommonUtils.SUCCESS_MSG,
			// HttpStatus.OK.value(),
			// companyMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			//
			// }
			// case CUSTMER_MASTER: {
			// // for get CustomerMasterRequest Details
			// CustomerMaster customerMaster = customerMasterRepository.findOne(id);
			// if (!CommonUtils.isObjectNullOrEmpty(customerMaster)) {
			// CustomerRequest customerMasterRequest = new CustomerRequest();
			// BeanUtils.copyProperties(customerMaster, customerMasterRequest);
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// customerMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			// }
			// case PRODUCT_MASTER: {
			// // for get ProductMasterRequest Details
			// ProductMaster productMaster = productMasterRepository.findOne(id);
			// if (!CommonUtils.isObjectNullOrEmpty(productMaster)) {
			// ProductRequest productMasterRequest = new ProductRequest();
			// BeanUtils.copyProperties(productMaster, productMasterRequest);
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// productMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			//
			// }
			// case ROUTE_MASTER: {
			// // for get RouteMasterRequest Details
			// RouteMaster routeMaster = routeMasterRepository.findOne(id);
			// if (!CommonUtils.isObjectNullOrEmpty(routeMaster)) {
			// RouteRequest routeMasterRequest = new RouteRequest();
			// BeanUtils.copyProperties(routeMaster, routeMasterRequest);
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// routeMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			// }
			default:
				break;
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "error while fetching master detail");
			return new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public ErpResponse list(MasterRequest masterRequest) throws Exception {
		try {
			Master masterType = CommonUtils.Master.getType(masterRequest.getClassId());
			if (masterType == null) {
				return new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}

			switch (masterType) {
			case CATEGORY_MASTER: {
				List<CategoryRequest> actegories = null;
				if (masterRequest.getPageSize() == -1 || masterRequest.getPageNo() == -1) {
					actegories = categoryService.getAll(masterRequest.getUserData());
				} else {
					Pageable pageable = new PageRequest(masterRequest.getPageNo(), masterRequest.getPageSize());
					actegories = categoryService.listByRange(pageable, masterRequest.getUserData());
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), actegories);
			}
			// case COMPANY_MASTER: {
			// List<CompanyMaster> listOfCompanyMaster = new ArrayList<CompanyMaster>();
			// if (pageSize == -1 || pageNo == -1) {
			// listOfCompanyMaster = companyMasterRepository.listAll();
			// } else {
			// listOfCompanyMaster = companyMasterRepository.listByRange(pageable);
			// }
			// List<CompanyRequest> listOfCompanyMasterRequest = new
			// ArrayList<CompanyRequest>(
			// listOfCompanyMaster.size());
			// for (CompanyMaster companyMaster : listOfCompanyMaster) {
			// CompanyRequest companyMasterRequest = new CompanyRequest();
			// BeanUtils.copyProperties(companyMaster, companyMasterRequest);
			// listOfCompanyMasterRequest.add(companyMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// listOfCompanyMasterRequest);
			// }
			//
			// case CUSTMER_MASTER: {
			// List<CustomerMaster> listOfCustomerMaster = new ArrayList<CustomerMaster>();
			// if (pageSize == -1 || pageNo == -1) {
			// listOfCustomerMaster = customerMasterRepository.listAll();
			// } else {
			// listOfCustomerMaster = customerMasterRepository.listByRange(pageable);
			// }
			// List<CustomerRequest> listOfCustomerMasterRequest = new
			// ArrayList<CustomerRequest>(
			// listOfCustomerMaster.size());
			// for (CustomerMaster customerMaster : listOfCustomerMaster) {
			// CustomerRequest customerMasterRequest = new CustomerRequest();
			// BeanUtils.copyProperties(customerMaster, customerMasterRequest);
			// listOfCustomerMasterRequest.add(customerMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// listOfCustomerMasterRequest);
			// }
			//
			// case PRODUCT_MASTER: {
			// List<ProductMaster> listOfProductMaster = new ArrayList<ProductMaster>();
			// if (pageSize == -1 || pageNo == -1) {
			// listOfProductMaster = productMasterRepository.listAll();
			// } else {
			// listOfProductMaster = productMasterRepository.listByRange(pageable);
			// }
			// List<ProductRequest> listOfProductMasterRequest = new
			// ArrayList<ProductRequest>(
			// listOfProductMaster.size());
			// for (ProductMaster productMaster : listOfProductMaster) {
			// ProductRequest productMasterRequest = new ProductRequest();
			// BeanUtils.copyProperties(productMaster, productMasterRequest);
			// listOfProductMasterRequest.add(productMasterRequest);
			// }
			//
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// listOfProductMasterRequest);
			// }
			//
			// case ROUTE_MASTER: {
			// List<RouteMaster> listOfRouteMaster = new ArrayList<RouteMaster>();
			// if (pageSize == -1 || pageNo == -1) {
			// listOfRouteMaster = routeMasterRepository.listAll();
			// } else {
			// listOfRouteMaster = routeMasterRepository.listByRange(pageable);
			// }
			// List<RouteRequest> listOfRouteMasterRequest = new
			// ArrayList<RouteRequest>(listOfRouteMaster.size());
			// for (RouteMaster routeMaster : listOfRouteMaster) {
			// RouteRequest routeMasterRequest = new RouteRequest();
			// BeanUtils.copyProperties(routeMaster, routeMasterRequest);
			// listOfRouteMasterRequest.add(routeMasterRequest);
			// }
			// return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
			// listOfRouteMasterRequest);
			// }
			default: {
				return new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.log(Level.SEVERE, "error while fetching list of master detail");
			e.printStackTrace();
			return new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ErpResponse inactive(MasterRequest masterRequest) throws Exception {
		// TODO Auto-generated method stub

		try {
			int count = 0;
			boolean isInvalid = false;
			Master masterType = CommonUtils.Master.getType(masterRequest.getClassId());
			if (masterType == null) {
				return new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}

			switch (masterType) {
			case CATEGORY_MASTER: {
				count = categoryService.inActivate(masterRequest.getId(), masterRequest.getUserData());
				break;
			}
			// case COMPANY_MASTER: {
			// count = companyMasterRepository.setInActive(id);
			// break;
			// }
			// case CUSTMER_MASTER: {
			// count = customerMasterRepository.setInActive(id);
			// break;
			// }
			// case PRODUCT_MASTER: {
			// count = productMasterRepository.setInActive(id);
			// break;
			// }
			// case ROUTE_MASTER: {
			// count = routeMasterRepository.setInActive(id);
			// break;
			// }
			default: {
				isInvalid = true;
				break;
			}
			}
			return new ErpResponse(isInvalid ? CommonUtils.INVALID_REQUEST : CommonUtils.INACTIVATED,
					isInvalid ? HttpStatus.BAD_REQUEST.value() : HttpStatus.OK.value(), count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.log(Level.SEVERE, "error while set inactive master detail");
			e.printStackTrace();
			return new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean save(MasterModel request) throws Exception {
		try {
			Master masterType = CommonUtils.Master.getType(request.getClassId());
			if (masterType == null) {
				return false;
			}

			switch (masterType) {
			case CATEGORY_MASTER: {
				CategoryRequest categoryMasterRequest = (CategoryRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CategoryRequest.class);
				categoryService.save(categoryMasterRequest, request.getUserData());
				break;
			}
			// case COMPANY_MASTER: {
			// CompanyRequest companyMasterRequest = (CompanyRequest)
			// MultipleJSONObjectHelper
			// .getObjectFromMap((Map<String, Object>) request.getMaster(),
			// CompanyRequest.class);
			//
			// CompanyMaster companyMaster = null;
			// if (CommonUtils.isObjectNullOrEmpty(companyMasterRequest.getErpId())) {
			// companyMaster = new CompanyMaster();
			// } else {
			// companyMaster =
			// companyMasterRepository.findOne(companyMasterRequest.getErpId());
			// }
			// BeanUtils.copyProperties(companyMasterRequest, companyMaster,
			// CommonUtils.Ignore.ACTIVITY_KEYS);
			// erpMaster = companyMaster;
			// break;
			// }
			// case CUSTMER_MASTER: {
			// CustomerRequest customerMasterRequest = (CustomerRequest)
			// MultipleJSONObjectHelper
			// .getObjectFromMap((Map<String, Object>) request.getMaster(),
			// CustomerRequest.class);
			//
			// CustomerMaster customerMaster = null;
			// if (CommonUtils.isObjectNullOrEmpty(customerMasterRequest.getErpId())) {
			// customerMaster = new CustomerMaster();
			// } else {
			// customerMaster =
			// customerMasterRepository.findOne(customerMasterRequest.getErpId());
			// }
			// BeanUtils.copyProperties(customerMasterRequest, customerMaster,
			// CommonUtils.Ignore.ACTIVITY_KEYS);
			// erpMaster = customerMaster;
			// break;
			// }
			// case PRODUCT_MASTER: {
			// ProductRequest productMasterRequest = (ProductRequest)
			// MultipleJSONObjectHelper
			// .getObjectFromMap((Map<String, Object>) request.getMaster(),
			// ProductRequest.class);
			//
			// ProductMaster productMaster = null;
			// if (CommonUtils.isObjectNullOrEmpty(productMasterRequest.getErpId())) {
			// productMaster = new ProductMaster();
			// } else {
			// productMaster =
			// productMasterRepository.findOne(productMasterRequest.getErpId());
			// }
			// BeanUtils.copyProperties(productMasterRequest, productMaster,
			// CommonUtils.Ignore.ACTIVITY_KEYS);
			// erpMaster = productMaster;
			// break;
			// }
			// case ROUTE_MASTER: {
			// RouteRequest routeMasterRequest = (RouteRequest) MultipleJSONObjectHelper
			// .getObjectFromMap((Map<String, Object>) request.getMaster(),
			// RouteRequest.class);
			// RouteMaster routeMaster = null;
			// if (CommonUtils.isObjectNullOrEmpty(routeMasterRequest.getErpId())) {
			// routeMaster = new RouteMaster();
			// } else {
			// routeMaster = routeMasterRepository.findOne(routeMasterRequest.getErpId());
			// }
			// BeanUtils.copyProperties(routeMasterRequest, routeMaster,
			// CommonUtils.Ignore.ACTIVITY_KEYS);
			// erpMaster = routeMaster;
			// break;
			// }
			default: {
				logger.log(Level.WARNING, "Invalid ClassId==>{0}" + request.getClassId());
				return false;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error while Saving Master=>{0}", e);
			throw new ErpException(CommonUtils.SOMETHING_WENT_WRONG);
		}
		return true;
	}
}
