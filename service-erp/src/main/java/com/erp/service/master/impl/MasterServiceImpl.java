package com.erp.service.master.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.controller.master.MasterController;
import com.erp.domain.master.AccountMaster;
import com.erp.domain.master.AddressMaster;
import com.erp.domain.master.CategoryMaster;
import com.erp.domain.master.CompanyMaster;
import com.erp.domain.master.CustomerMaster;
import com.erp.domain.master.ErpMstr;
import com.erp.domain.master.ProductMaster;
import com.erp.domain.master.RouteMaster;
import com.erp.repository.common.ERPRepository;
import com.erp.repository.master.AccountRepository;
import com.erp.repository.master.AddressRepository;
import com.erp.repository.master.CategoryRepository;
import com.erp.repository.master.CompanyRepository;
import com.erp.repository.master.CustomerRepository;
import com.erp.repository.master.ProductRepository;
import com.erp.repository.master.RouteRepository;
import com.erp.service.master.MasterService;

import model.common.ErpResponse;
import model.master.AccountRequest;
import model.master.AddressRequest;
import model.master.CategoryRequest;
import model.master.CompanyRequest;
import model.master.CustomerRequest;
import model.master.MasterModel;
import model.master.ProductRequest;
import model.master.RouteRequest;
import utils.CommonUtils;
import utils.CommonUtils.Master;
import utils.MultipleJSONObjectHelper;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

	private static Logger log = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private AccountRepository accountMasterRepository;

	@Autowired
	private ERPRepository erpMasterRepository;

	@Autowired
	private AddressRepository addressMasterRepository;

	@Autowired
	private CategoryRepository categoryMasterRepository;

	@Autowired
	private CompanyRepository companyMasterRepository;

	@Autowired
	private CustomerRepository customerMasterRepository;

	@Autowired
	private ProductRepository productMasterRepository;

	@Autowired
	private RouteRepository routeMasterRepository;

	@Override
	public ErpResponse get(Long id, Integer classId) {
		// TODO Auto-generated method stub

		try {
			Master masterType = CommonUtils.Master.getType(classId);
			switch (masterType) {
			case ACCOUNT_MASTER: {
				// for get AccountMasterRequest Details
				AccountMaster accountMaster = accountMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(accountMaster)) {
					AccountRequest accountMasterRequest = new AccountRequest();
					BeanUtils.copyProperties(accountMaster, accountMasterRequest);
					return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), accountMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			}
			case ADDRERSS_MASTER: {
				// for get AddressMasterRequest Details
				ErpResponse erpResponse = new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
				;
				AddressMaster addressMaster = addressMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(addressMaster)) {
					AddressRequest addressMasterRequest = new AddressRequest();
					BeanUtils.copyProperties(addressMaster, addressMasterRequest);
					erpResponse.setData(addressMasterRequest);
				}
				return erpResponse;
			}
			case CATEGORY_MASTER: {
				// for get CategoryMasterRequest Details
				CategoryMaster categoryMaster = categoryMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(categoryMaster)) {
					CategoryRequest categoryMasterRequest = new CategoryRequest();
					BeanUtils.copyProperties(categoryMaster, categoryMasterRequest);
					return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), categoryMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());

			}
			case COMPANY_MASTER: {
				// for get CompanyMasterRequest Details
				CompanyMaster companyMaster = companyMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(companyMaster)) {
					CompanyRequest companyMasterRequest = new CompanyRequest();
					BeanUtils.copyProperties(companyMaster, companyMasterRequest);
					ErpResponse res = new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(),
							companyMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());

			}
			case CUSTMER_MASTER: {
				// for get CustomerMasterRequest Details
				CustomerMaster customerMaster = customerMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(customerMaster)) {
					CustomerRequest customerMasterRequest = new CustomerRequest();
					BeanUtils.copyProperties(customerMaster, customerMasterRequest);
					return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), customerMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			}
			case PRODUCT_MASTER: {
				// for get ProductMasterRequest Details
				ProductMaster productMaster = productMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(productMaster)) {
					ProductRequest productMasterRequest = new ProductRequest();
					BeanUtils.copyProperties(productMaster, productMasterRequest);
					return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), productMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());

			}
			case ROUTE_MASTER: {
				// for get RouteMasterRequest Details
				RouteMaster routeMaster = routeMasterRepository.findOne(id);
				if (!CommonUtils.isObjectNullOrEmpty(routeMaster)) {
					RouteRequest routeMasterRequest = new RouteRequest();
					BeanUtils.copyProperties(routeMaster, routeMasterRequest);
					return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), routeMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			}
			}
			return null;

		} catch (Exception e) {
			log.error("error while fetching master detail");
			e.printStackTrace();
			return new ErpResponse("Error while fetching master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public ErpResponse list(Integer classId, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub

		Pageable pageable = new PageRequest(pageNo, pageSize);
		try {

			Master masterType = CommonUtils.Master.getType(classId);
			switch (masterType) {
			case ACCOUNT_MASTER: {
				List<AccountMaster> listOfAccountMaster = new ArrayList<AccountMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfAccountMaster = accountMasterRepository.listAll();
				} else {

					listOfAccountMaster = accountMasterRepository.listByRange(pageable);
				}
				List<AccountRequest> listOfAccountMasterRequest = new ArrayList<AccountRequest>(
						listOfAccountMaster.size());
				for (AccountMaster accountMaster : listOfAccountMaster) {
					AccountRequest accountMasterRequest = new AccountRequest();
					BeanUtils.copyProperties(accountMaster, accountMasterRequest);
					listOfAccountMasterRequest.add(accountMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfAccountMasterRequest);
			}
			case ADDRERSS_MASTER: {
				List<AddressMaster> listOfAddressMaster = new ArrayList<AddressMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfAddressMaster = addressMasterRepository.listAll();
				} else {
					listOfAddressMaster = addressMasterRepository.listByRange(pageable);
				}
				List<AddressRequest> listOfAddressMasterRequest = new ArrayList<AddressRequest>(
						listOfAddressMaster.size());
				for (AddressMaster addressMaster : listOfAddressMaster) {
					AddressRequest addressMasterRequest = new AddressRequest();
					BeanUtils.copyProperties(addressMaster, addressMasterRequest);
					listOfAddressMasterRequest.add(addressMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfAddressMasterRequest);
			}
			case CATEGORY_MASTER: {
				List<CategoryMaster> listOfCategoryMaster = new ArrayList<CategoryMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfCategoryMaster = categoryMasterRepository.listAll();
				} else {
					listOfCategoryMaster = categoryMasterRepository.listByRange(pageable);
				}
				List<CategoryRequest> listOfCategoryMasterRequest = new ArrayList<CategoryRequest>(
						listOfCategoryMaster.size());
				for (CategoryMaster categoryMaster : listOfCategoryMaster) {
					CategoryRequest categoryMasterRequest = new CategoryRequest();
					BeanUtils.copyProperties(categoryMaster, categoryMasterRequest);
					listOfCategoryMasterRequest.add(categoryMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfCategoryMasterRequest);
			}
			case COMPANY_MASTER: {
				List<CompanyMaster> listOfCompanyMaster = new ArrayList<CompanyMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfCompanyMaster = companyMasterRepository.listAll();
				} else {
					listOfCompanyMaster = companyMasterRepository.listByRange(pageable);
				}
				List<CompanyRequest> listOfCompanyMasterRequest = new ArrayList<CompanyRequest>(
						listOfCompanyMaster.size());
				for (CompanyMaster companyMaster : listOfCompanyMaster) {
					CompanyRequest companyMasterRequest = new CompanyRequest();
					BeanUtils.copyProperties(companyMaster, companyMasterRequest);
					listOfCompanyMasterRequest.add(companyMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfCompanyMasterRequest);
			}

			case CUSTMER_MASTER: {
				List<CustomerMaster> listOfCustomerMaster = new ArrayList<CustomerMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfCustomerMaster = customerMasterRepository.listAll();
				} else {
					listOfCustomerMaster = customerMasterRepository.listByRange(pageable);
				}
				List<CustomerRequest> listOfCustomerMasterRequest = new ArrayList<CustomerRequest>(
						listOfCustomerMaster.size());
				for (CustomerMaster customerMaster : listOfCustomerMaster) {
					CustomerRequest customerMasterRequest = new CustomerRequest();
					BeanUtils.copyProperties(customerMaster, customerMasterRequest);
					listOfCustomerMasterRequest.add(customerMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfCustomerMasterRequest);
			}

			case PRODUCT_MASTER: {
				List<ProductMaster> listOfProductMaster = new ArrayList<ProductMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfProductMaster = productMasterRepository.listAll();
				} else {
					listOfProductMaster = productMasterRepository.listByRange(pageable);
				}
				List<ProductRequest> listOfProductMasterRequest = new ArrayList<ProductRequest>(
						listOfProductMaster.size());
				for (ProductMaster productMaster : listOfProductMaster) {
					ProductRequest productMasterRequest = new ProductRequest();
					BeanUtils.copyProperties(productMaster, productMasterRequest);
					listOfProductMasterRequest.add(productMasterRequest);
				}

				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfProductMasterRequest);
			}

			case ROUTE_MASTER: {
				List<RouteMaster> listOfRouteMaster = new ArrayList<RouteMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfRouteMaster = routeMasterRepository.listAll();
				} else {
					listOfRouteMaster = routeMasterRepository.listByRange(pageable);
				}
				List<RouteRequest> listOfRouteMasterRequest = new ArrayList<RouteRequest>(
						listOfRouteMaster.size());
				for (RouteMaster routeMaster : listOfRouteMaster) {
					RouteRequest routeMasterRequest = new RouteRequest();
					BeanUtils.copyProperties(routeMaster, routeMasterRequest);
					listOfRouteMasterRequest.add(routeMasterRequest);
				}
				return new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value(), listOfRouteMasterRequest);
			}
			default: {
				return new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}

			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error while fetching list of master detail");
			e.printStackTrace();
			return new ErpResponse("Error while fetching list of master detail",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public ErpResponse inactive(Long id, Integer classId) {
		// TODO Auto-generated method stub

		try {
			int count = 0;
			boolean isInvalid = false;
			Master masterType = CommonUtils.Master.getType(classId);
			switch (masterType) {
			case ACCOUNT_MASTER: {
				count = accountMasterRepository.setInActive(id);
				break;
			}
			case ADDRERSS_MASTER: {
				count = addressMasterRepository.setInActive(id);
				break;
			}
			case CATEGORY_MASTER: {
				count = categoryMasterRepository.setInActive(id);
				break;
			}
			case COMPANY_MASTER: {
				count = companyMasterRepository.setInActive(id);
				break;
			}
			case CUSTMER_MASTER: {
				count = customerMasterRepository.setInActive(id);
				break;
			}
			case PRODUCT_MASTER: {
				count = productMasterRepository.setInActive(id);
				break;
			}
			case ROUTE_MASTER: {
				count = routeMasterRepository.setInActive(id);
				break;
			}
			default: {
				isInvalid = true;
				break;
			}
			}
			return new ErpResponse(isInvalid ? CommonUtils.INVALID_REQUEST : CommonUtils.INACTIVATED,
					isInvalid ? HttpStatus.BAD_REQUEST.value() : HttpStatus.OK.value(), count);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error while set inactive master detail");
			e.printStackTrace();
			return new ErpResponse("Error while set inactive master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean save(MasterModel request, Long userId) throws Exception {
		ErpMstr erpMaster = null;
		try {
			Master masterType = CommonUtils.Master.getType(request.getClassId());
			switch (masterType) {
			case ACCOUNT_MASTER: {
				AccountRequest accountMasterRequest = (AccountRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), AccountRequest.class);
				AccountMaster accountMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(accountMasterRequest.getErpId())) {
					accountMaster = new AccountMaster();
				} else {
					accountMaster = accountMasterRepository.findOne(accountMasterRequest.getErpId());
				}
				BeanUtils.copyProperties(accountMasterRequest, accountMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				accountMaster.setUserId(userId);
				erpMaster = accountMaster;
				break;
			}
			case ADDRERSS_MASTER: {
				AddressRequest addressMasterRequest = (AddressRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), AddressRequest.class);

				AddressMaster addressMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(addressMasterRequest.getErpId())) {
					addressMaster = new AddressMaster();
				} else {
					addressMaster = addressMasterRepository.findOne(addressMasterRequest.getErpId());
				}
				BeanUtils.copyProperties(addressMasterRequest, addressMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				erpMaster = addressMaster;
				break;
			}
			case CATEGORY_MASTER: {
				CategoryRequest categoryMasterRequest = (CategoryRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CategoryRequest.class);

				CategoryMaster categoryMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(categoryMasterRequest.getErpId())) {
					categoryMaster = new CategoryMaster();
				} else {
					categoryMaster = categoryMasterRepository.findOne(categoryMasterRequest.getErpId());
				}

				BeanUtils.copyProperties(categoryMasterRequest, categoryMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				erpMaster = categoryMaster;
				break;
			}
			case COMPANY_MASTER: {
				CompanyRequest companyMasterRequest = (CompanyRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CompanyRequest.class);

				CompanyMaster companyMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(companyMasterRequest.getErpId())) {
					companyMaster = new CompanyMaster();
				} else {
					companyMaster = companyMasterRepository.findOne(companyMasterRequest.getErpId());
				}
				BeanUtils.copyProperties(companyMasterRequest, companyMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				erpMaster = companyMaster;
				break;
			}
			case CUSTMER_MASTER: {
				CustomerRequest customerMasterRequest = (CustomerRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CustomerRequest.class);

				CustomerMaster customerMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(customerMasterRequest.getErpId())) {
					customerMaster = new CustomerMaster();
				} else {
					customerMaster = customerMasterRepository.findOne(customerMasterRequest.getErpId());
				}
				BeanUtils.copyProperties(customerMasterRequest, customerMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				erpMaster = customerMaster;
				break;
			}
			case PRODUCT_MASTER: {
				ProductRequest productMasterRequest = (ProductRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), ProductRequest.class);

				ProductMaster productMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(productMasterRequest.getErpId())) {
					productMaster = new ProductMaster();
				} else {
					productMaster = productMasterRepository.findOne(productMasterRequest.getErpId());
				}
				BeanUtils.copyProperties(productMasterRequest, productMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				erpMaster = productMaster;
				break;
			}
			case ROUTE_MASTER: {
				RouteRequest routeMasterRequest = (RouteRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), RouteRequest.class);
				RouteMaster routeMaster = null;
				if (CommonUtils.isObjectNullOrEmpty(routeMasterRequest.getErpId())) {
					routeMaster = new RouteMaster();
				} else {
					routeMaster = routeMasterRepository.findOne(routeMasterRequest.getErpId());
				}
				BeanUtils.copyProperties(routeMasterRequest, routeMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				erpMaster = routeMaster;
				break;
			}
			default: {
				log.warn("Invalid ClassId==>" + request.getClassId());
				return false;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while Saving Master=>{0}", e);
			throw new Exception(CommonUtils.SOMETHING_WENT_WRONG);
		}

		if (CommonUtils.isObjectNullOrEmpty(erpMaster.getErpId())) {
			erpMaster.setCreatedDate(new Date());
			erpMaster.setCreatedBy(userId);
		} else {
			erpMaster.setModifiedDate(new Date());
			erpMaster.setModifiedBy(userId);
		}
		erpMaster.setIsActive(true);
		erpMasterRepository.save(erpMaster);
		log.info("SuccessFully Saved==>");
		return true;
	}
}
