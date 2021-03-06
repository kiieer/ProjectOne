package com.revature.project.one.service;

import java.util.List;

import com.revature.project.one.entities.Reimbursement;

public interface RemSInterface {
	List<Reimbursement> getAllReimbursements();
	
	List<Reimbursement> getReimbursementById(int p);
	
	List<Reimbursement> getReimbursementsByEmployee(int p);
	
	boolean createReimbursement(Reimbursement reimbursement, int CUID);
	
	void resolveReimbursement(Reimbursement reimbursement, int CUID);
}
