package com.employee.empdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InnerTransactionBeanSevice {

	@Transactional(propagation=Propagation.REQUIRED)
	public void innerTestRequired(){
		throw new RuntimeException("innerTestRequired():::Rollback this transaction!!! ");
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void innerTestRequiresNew(){
		throw new RuntimeException("innerTestRequired():::Rollback this transaction!!! ");
	}
}
