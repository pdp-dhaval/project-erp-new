package com.erp.controller.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.repository.master.AccountMasterRepository;
import com.erp.service.master.AccountMasterService;
import com.erp.service.master.MasterService;

import model.ErpRequest;
import model.ErpResponse;
import model.MasterModel;
import utils.CommonUtils;

@RestController
@RequestMapping("/master")
public class MasterController {

	private static Logger log = LoggerFactory.getLogger(MasterController.class);
	
	@Autowired
	private MasterService masterService;
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> get(@RequestBody ErpRequest request) {
		
		Long id=request.getId();
		Integer classId=request.getClassId();
		
		if(CommonUtils.isObjectNullOrEmpty(id) || CommonUtils.isObjectNullOrEmpty(classId))
		{
			log.error("parameters are null or empty.");
			ErpResponse erpResponse= new ErpResponse("parameters are null or empty.", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ErpResponse>(erpResponse,HttpStatus.OK);
		}
		
		ErpResponse res=masterService.get(id, classId);
		return new ResponseEntity<ErpResponse>(res,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> list(@RequestBody ErpRequest request) {
		
		Integer classId=request.getClassId();
		Integer pageSize=request.getPageSize();
		Integer pageNo=request.getPageNo();
		
		if(CommonUtils.isObjectNullOrEmpty(classId) || CommonUtils.isObjectNullOrEmpty(pageNo) || CommonUtils.isObjectNullOrEmpty(pageNo))
		{
			log.error("parameters are null or empty.");
			ErpResponse erpResponse= new ErpResponse("parameters are null or empty.", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ErpResponse>(erpResponse,HttpStatus.OK);
		}
		
		ErpResponse res=masterService.list(classId,pageSize,pageNo);
		return new ResponseEntity<ErpResponse>(res,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/inactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> inactive(@RequestBody ErpRequest request) {
		
		Long id=request.getId();
		Integer classId=request.getClassId();
		
		if(CommonUtils.isObjectNullOrEmpty(id) || CommonUtils.isObjectNullOrEmpty(classId))
		{
			log.error("parameters are null or empty.");
			ErpResponse erpResponse= new ErpResponse("parameters are null or empty.", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ErpResponse>(erpResponse,HttpStatus.OK);
		}
		
		ErpResponse res=masterService.inactive(id, classId);
		return new ResponseEntity<ErpResponse>(res,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> save(@RequestBody MasterModel request) {
		
		try
		{
		if(CommonUtils.isObjectNullOrEmpty(request)||CommonUtils.isObjectNullOrEmpty(request.getClassId()))
		{
			log.error("request is null or empty.");
			ErpResponse erpResponse= new ErpResponse("request is null or empty..", HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ErpResponse>(erpResponse,HttpStatus.OK);
		}
		
		ErpResponse erpResponse;
		Boolean res=masterService.save(request);
		if(res)
		{
			erpResponse= new ErpResponse("successfully saved", HttpStatus.OK.value());
		}
		else
		{
			erpResponse=new ErpResponse("error while saving master", HttpStatus.BAD_REQUEST.value());
			
		}
		
		
		return new ResponseEntity<ErpResponse>(erpResponse,HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<ErpResponse>(
				     new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()),
				     HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
