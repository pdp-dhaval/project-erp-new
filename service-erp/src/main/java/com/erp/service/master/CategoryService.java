package com.erp.service.master;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.erp.model.common.UserData;
import com.erp.model.master.CategoryRequest;;

public interface CategoryService {

	public int inActivate(Long id, UserData data) throws Exception;

	public List<CategoryRequest> getAll(UserData data) throws Exception;

	public CategoryRequest getById(Long erpId, Boolean isActive, UserData data) throws Exception;

	public void save(CategoryRequest categoryRequest, UserData data) throws Exception;

	public List<CategoryRequest> listByRange(Pageable pageable, UserData data) throws Exception;
}
