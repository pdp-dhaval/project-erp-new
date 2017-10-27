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

import com.erp.service.master.MasterService;

import model.common.ErpResponse;
import model.master.MasterModel;
import model.master.MasterRequest;
import utils.CommonUtils;

@RestController
@RequestMapping("/master")
public class MasterController {

	private static Logger log = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private MasterService masterService;

	@RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> get(@RequestBody MasterRequest request) {

		Long id = request.getId();
		Integer classId = request.getClassId();

		if (CommonUtils.isObjectNullOrEmpty(id) || CommonUtils.isObjectNullOrEmpty(classId)) {
			log.error("parameters are null or empty.");
			return new ResponseEntity<ErpResponse>(new ErpResponse("parameters are null or empty.", HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
		}
		return new ResponseEntity<ErpResponse>(masterService.get(id, classId), HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> list(@RequestBody MasterRequest request) {

		if (CommonUtils.isObjectNullOrEmpty(request.getClassId()) || CommonUtils.isObjectNullOrEmpty(request.getPageNo())
				|| CommonUtils.isObjectNullOrEmpty(request.getPageSize())) {
			log.error("parameters are null or empty.");
			return new ResponseEntity<ErpResponse>(new ErpResponse("parameters are null or empty.", HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
		}
		return new ResponseEntity<ErpResponse>(masterService.list(request.getClassId(), request.getPageSize(), request.getPageNo()), HttpStatus.OK);

	}

	@RequestMapping(value = "/inactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> inactive(@RequestBody MasterRequest request) {

		if (CommonUtils.isObjectNullOrEmpty(request.getId()) || CommonUtils.isObjectNullOrEmpty(request.getClassId())) {
			log.error("parameters are null or empty.");
			return new ResponseEntity<ErpResponse>(new ErpResponse("parameters are null or empty.", HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
		}
		return new ResponseEntity<ErpResponse>(masterService.inactive(request.getId(),request.getClassId()), HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> save(@RequestBody MasterModel request) {

		try {
			if (CommonUtils.isObjectNullOrEmpty(request.getMaster()) || CommonUtils.isObjectNullOrEmpty(request.getClassId())) {
				log.error("ClassId or Master Object Must not be null");
				return new ResponseEntity<ErpResponse>(new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
			}
			ErpResponse erpResponse = null;
			Boolean res = masterService.save(request,1l);
			if (res) {
				erpResponse = new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			} else {
				erpResponse = new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			return new ResponseEntity<ErpResponse>(erpResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErpResponse>(
					new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
