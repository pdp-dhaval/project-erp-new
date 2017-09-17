package com.erp.controller.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.ErpRequest;
import model.ErpResponse;

@RestController
@RequestMapping("/master")
public class MasterController {

	private static Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	@RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> get(@RequestBody ErpRequest request) {
		
		return null;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> list(@RequestBody ErpRequest request) {
		
		return null;
	}
	
	@RequestMapping(value = "/inactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErpResponse> inactive(@RequestBody ErpRequest request) {
		
		return null;
	}
	
}
