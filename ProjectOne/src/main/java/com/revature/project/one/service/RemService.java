package com.revature.project.one.service;

import java.util.List;

import com.revature.project.one.dao.RemDAO;
import com.revature.project.one.dao.RemDAOPostgres;
import com.revature.project.one.entities.Reimbursement;

public class RemService implements RemSInterface {
	static RemDAO dao = new RemDAOPostgres();
	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return dao.getAllReimbursements();
	}
	@Override
	public boolean createReimbursement(Reimbursement reimbursement, int CUID) {
		// TODO Auto-generated method stub
		return dao.createReimbursement(reimbursement, CUID);
	}
	@Override
	public List<Reimbursement> getReimbursementById(int p) {
		// TODO Auto-generated method stub
		return dao.getReimbursementById(p);
	}
	@Override
	public void resolveReimbursement(Reimbursement reimbursement, int CUID) {
		dao.resolveReimbursement(reimbursement, CUID);
		
	}
	@Override
	public List<Reimbursement> getReimbursementsByEmployee(int p) {
		// TODO Auto-generated method stub
		return dao.getReimbursementsByEmployee(p);
	}
}
