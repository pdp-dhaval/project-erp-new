package com.erp.service.master.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.service.master.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());

}
