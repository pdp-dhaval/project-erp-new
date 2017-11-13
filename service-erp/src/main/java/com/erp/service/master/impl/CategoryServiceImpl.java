package com.erp.service.master.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.domain.master.CategoryMaster;
import com.erp.exception.ErpException;
import com.erp.model.common.UserData;
import com.erp.model.master.CategoryRequest;
import com.erp.repository.master.CategoryRepository;
import com.erp.service.master.CategoryService;

import utils.CommonUtils;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public int inActivate(Long id, UserData data) throws Exception {
		logger.log(Level.INFO, "Start inActivate()  Method");
		try {

			// Get Current OrganizationId from User
			Long orgId = 3l;
			logger.log(Level.INFO, "End inActivate()  Method");
			return categoryRepository.inActivate(id, orgId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.INFO, "End inActivate()  Method in Catch Block");
			logger.log(Level.SEVERE, "Error While inactivating Category");
			throw new ErpException(CommonUtils.SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public List<CategoryRequest> getAll(UserData data) throws Exception {
		logger.log(Level.INFO, "Start getAll()  Method");
		try {
			// Get Current OrganizationId from User
			Long orgId = 3l;
			List<CategoryMaster> list = categoryRepository.getAll(orgId);
			List<CategoryRequest> response = new ArrayList<CategoryRequest>();
			for (CategoryMaster cat : list) {
				CategoryRequest target = new CategoryRequest();
				BeanUtils.copyProperties(cat, target);
				response.add(target);
			}
			logger.log(Level.INFO, "End getAll()  Method");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.INFO, "End getAll() Method in Catch Block");
			logger.log(Level.SEVERE, "Error While getting all Category");
			throw new ErpException(CommonUtils.SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public CategoryRequest getById(Long erpId, Boolean isActive, UserData data) throws Exception {
		logger.log(Level.INFO, "Start getById()  Method");
		try {
			CategoryMaster categoryMaster = categoryRepository.getById(erpId, isActive);
			if (!CommonUtils.isObjectNullOrEmpty(categoryMaster)) {
				CategoryRequest target = new CategoryRequest();
				BeanUtils.copyProperties(categoryMaster, target);
				return target;
			} else {
				throw new ErpException("Invalid erpId for Category===============>" + erpId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.INFO, "End getById() Method in Catch Block");
			logger.log(Level.SEVERE, "Error While getting Category");
			throw new ErpException(CommonUtils.SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public List<CategoryRequest> listByRange(Pageable pageable, UserData data) throws Exception {
		logger.log(Level.INFO, "Start listByRange()  Method");
		try {
			// Get Current OrganizationId from User
			Long orgId = 3l;
			List<CategoryMaster> list = categoryRepository.getAllByRangeAndStatus(pageable, true, orgId);
			List<CategoryRequest> response = new ArrayList<CategoryRequest>();
			for (CategoryMaster cat : list) {
				CategoryRequest target = new CategoryRequest();
				BeanUtils.copyProperties(cat, target);
				response.add(target);
			}
			logger.log(Level.INFO, "End listByRange()  Method");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.INFO, "End listByRange() Method in Catch Block");
			logger.log(Level.SEVERE, "Error While getting list by Range Category");
			throw new ErpException(CommonUtils.SOMETHING_WENT_WRONG);
		}
	}

	@Override
	public void save(CategoryRequest categoryRequest, UserData data) throws Exception {
		logger.log(Level.INFO, "Start save() Method");
		try {
			Long mainUserId = CommonUtils.getMainUserId(data);
			// get Current Organization Id
			Long organizationId = 3l;
			CategoryMaster categoryMaster = categoryRepository.getById(categoryRequest.getErpId(), true,
					organizationId);
			if (CommonUtils.isObjectNullOrEmpty(categoryMaster)) {
				categoryMaster = new CategoryMaster();
				BeanUtils.copyProperties(categoryRequest, categoryMaster, CommonUtils.Ignore.ACTIVITY_KEYS);
				categoryMaster.setCreatedBy(mainUserId);
				categoryMaster.setCreatedDate(new Date());
				categoryMaster.setIsActive(true);
				categoryMaster.setOrganizationId(organizationId);
			} else {
				categoryMaster.setModifiedBy(mainUserId);
				categoryMaster.setModifiedDate(new Date());
			}
			categoryRepository.save(categoryMaster);
			logger.log(Level.INFO, "End save()  Method");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.INFO, "End save() Method in Catch Block");
			logger.log(Level.SEVERE, "Error While Saving CategoryId");
			throw new ErpException(CommonUtils.SOMETHING_WENT_WRONG);
		}
	}

}
