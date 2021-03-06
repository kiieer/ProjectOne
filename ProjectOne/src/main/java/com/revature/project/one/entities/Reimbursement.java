package com.revature.project.one.entities;

public class Reimbursement {
	private int id;
	private int empId;
	private int manId;
	private String type;
	private int amount;
	private String desc;
	private String submit;
	private String resolve;
	private boolean resolved;
	private boolean accepted;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(String type, int amount, String desc) {
		super();
		this.type = type;
		this.amount = amount;
		this.desc = desc;
	}

	public Reimbursement(int id, int empId, int manId, String type, int amount, String desc, String submit,
			String resolve, boolean resolved, boolean accepted) {
		super();
		this.id = id;
		this.empId = empId;
		this.manId = manId;
		this.type = type;
		this.amount = amount;
		this.desc = desc;
		this.submit = submit;
		this.resolve = resolve;
		this.resolved = resolved;
		this.accepted = accepted;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getManId() {
		return manId;
	}
	public void setManId(int manId) {
		this.manId = manId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getResolve() {
		return resolve;
	}
	public void setResolve(String resolve) {
		this.resolve = resolve;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", empId=" + empId + ", manId=" + manId + ", type=" + type + ", amount="
				+ amount + ", desc=" + desc + ", submit=" + submit + ", resolve=" + resolve + ", resolved=" + resolved
				+ ", accepted=" + accepted + "]";
	}
}
