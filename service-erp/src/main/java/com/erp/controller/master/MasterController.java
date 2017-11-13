package com.erp.controller.master;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.model.common.ErpResponse;
import com.erp.model.common.UserData;
import com.erp.model.master.MasterModel;
import com.erp.model.master.MasterRequest;
import com.erp.service.master.MasterService;

import utils.CommonUtils;

@RestController
@RequestMapping("/master")
public class MasterController {

	private static Logger logger = Logger.getLogger(MasterController.class.getName());

	@Autowired
	private MasterService masterService;

	@RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> get(@RequestBody MasterRequest request, HttpServletRequest httpServletRequest)
			throws Exception {

		logger.log(Level.INFO, "Start get() Method");
		try {
			if (CommonUtils.isObjectNullOrEmpty(request.getId())
					|| CommonUtils.isObjectNullOrEmpty(request.getClassId())) {
				logger.log(Level.WARNING, "parameters are null or empty.");
				logger.log(Level.INFO, "End get() Method");
				return new ResponseEntity<ErpResponse>(
						new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
			}
//			UserData data = (UserData) httpServletRequest.getAttribute(CommonUtils.USER_DATA);
			request.setUserData(new UserData(2l));
			logger.log(Level.INFO, "End get() Method");
			return new ResponseEntity<ErpResponse>(masterService.get(request), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error while Getting Single Record for Class Id and Id===>" + request.getClassId()
					+ "=======>" + request.getId());
			logger.log(Level.INFO, "End get() Method In Catch Block");
			return new ResponseEntity<ErpResponse>(
					new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> list(@RequestBody MasterRequest request) {
		logger.log(Level.INFO, "Start list() Method");
		try {
			if (CommonUtils.isObjectNullOrEmpty(request.getClassId())
					|| CommonUtils.isObjectNullOrEmpty(request.getPageNo())
					|| CommonUtils.isObjectNullOrEmpty(request.getPageSize())) {
				logger.log(Level.WARNING, "parameters are null or empty.");
				logger.log(Level.INFO, "End list() Method");
				return new ResponseEntity<ErpResponse>(
						new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
			}
			request.setUserData(new UserData(2l));
			logger.log(Level.INFO, "End list() Method");
			return new ResponseEntity<ErpResponse>(masterService.list(request), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"Error while Getting list fot ClassId===>" + request.getClassId() + "=======>" + request.getId());
			logger.log(Level.INFO, "End lis() Method In Catch Block");
			return new ResponseEntity<ErpResponse>(
					new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/inactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> inactive(@RequestBody MasterRequest request) {
		logger.log(Level.INFO, "Start inactive() Method");
		try {
			if (CommonUtils.isObjectNullOrEmpty(request.getId())
					|| CommonUtils.isObjectNullOrEmpty(request.getClassId())) {
				logger.log(Level.WARNING, "parameters are null or empty.");
				logger.log(Level.INFO, "End inactive() Method");
				return new ResponseEntity<ErpResponse>(
						new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
			}
			logger.log(Level.INFO, "End list() Method");
			request.setUserData(new UserData(2l));
			return new ResponseEntity<ErpResponse>(masterService.inactive(request), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE,
					"Error Inactivating ClassId===>" + request.getClassId() + "ID=======>" + request.getId());
			logger.log(Level.INFO, "End lis() Method In Catch Block");
			return new ResponseEntity<ErpResponse>(
					new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> save(@RequestBody MasterModel request) {

		logger.log(Level.INFO, "Start save() Method");

		try {
			if (CommonUtils.isObjectNullOrEmpty(request.getMaster())
					|| CommonUtils.isObjectNullOrEmpty(request.getClassId())) {
				logger.log(Level.WARNING, "ClassId or Master Object Must not be null");
				logger.log(Level.INFO, "End save() Method");
				return new ResponseEntity<ErpResponse>(
						new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
			}
			ErpResponse erpResponse = null;
			request.setUserData(new UserData(2l));
			Boolean res = masterService.save(request);
			if (res) {
				erpResponse = new ErpResponse(CommonUtils.SUCCESS_MSG, HttpStatus.OK.value());
			} else {
				erpResponse = new ErpResponse(CommonUtils.INVALID_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			logger.log(Level.INFO, "End save() Method");
			return new ResponseEntity<ErpResponse>(erpResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error Saving ClassId===>" + request.getClassId());
			return new ResponseEntity<ErpResponse>(
					new ErpResponse(CommonUtils.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.OK);
		}
	}

}
