package com.revature.project.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.project.one.entities.Reimbursement;
import com.revature.project.one.utils.ConnUtil;

public class RemDAOPostgres implements RemDAO {
	
	static Connection conn = ConnUtil.getInstance();
	
	
	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		String selectReim = "select * from reimbursements";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement r;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(selectReim);
			ResultSet rs = ptsmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int eid = rs.getInt("emp_id");
				int mid = rs.getInt("man_id");
				String type = rs.getString("type");
				int amount = rs.getInt("amount");
				String desc = rs.getString("description");
				String submittime = rs.getString("submit");
				String resolvetime = rs.getString("resolve_time");
				boolean resolved = rs.getBoolean("resolved");
				boolean accepted = rs.getBoolean("accepted");
				r = new Reimbursement(id, eid, mid, type, amount, desc, submittime, resolvetime, resolved, accepted);
				rList.add(r);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return rList;
	}

	@Override
	public boolean createReimbursement(Reimbursement reimbursement, int CUID) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptsmt = conn.prepareStatement("INSERT into reimbursements values(DEFAULT,?, null, ?,?,?,DEFAULT)");
			ptsmt.setInt(1, CUID);
			ptsmt.setString(2, reimbursement.getType());
			ptsmt.setInt(3, reimbursement.getAmount());
			ptsmt.setString(4, reimbursement.getDesc());
			ptsmt.execute();
			return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public List<Reimbursement> getReimbursementById(int p) {
		// TODO Auto-generated method stub
		String selectReim = "select * from reimbursements where id=?";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement r;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(selectReim);
			ptsmt.setInt(1, p);
			ResultSet rs = ptsmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int eid = rs.getInt("emp_id");
				int mid = rs.getInt("man_id");
				String type = rs.getString("type");
				int amount = rs.getInt("amount");
				String desc = rs.getString("description");
				String submittime = rs.getString("submit");
				String resolvetime = rs.getString("resolve_time");
				boolean resolved = rs.getBoolean("resolved");
				boolean accepted = rs.getBoolean("accepted");
				r = new Reimbursement(id, eid, mid, type, amount, desc, submittime, resolvetime, resolved, accepted);
				rList.add(r);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return rList;
	}

	@Override
	public void resolveReimbursement(Reimbursement reimbursement, int CUID) {
		// TODO Auto-generated method stub
		try {
			 Date date = new Date();
		     SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
		     String today = formatter.format(date);
			PreparedStatement ptsmt = conn.prepareStatement("update reimbursements set man_id=?, resolve_time = ?::date, resolved = ?, accepted = ?  where id = ?");
			ptsmt.setInt(1, CUID);
			ptsmt.setString(2, today);
			ptsmt.setBoolean(3, true);
			ptsmt.setBoolean(4, reimbursement.isAccepted());
			ptsmt.setInt(5, reimbursement.getId());
			ptsmt.execute();
			ptsmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployee(int p) {
		// TODO Auto-generated method stub
		String selectReim = "select * from reimbursements where emp_id=?";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement r;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(selectReim);
			ptsmt.setInt(1, p);
			ResultSet rs = ptsmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int eid = rs.getInt("emp_id");
				int mid = rs.getInt("man_id");
				String type = rs.getString("type");
				int amount = rs.getInt("amount");
				String desc = rs.getString("description");
				String submittime = rs.getString("submit");
				String resolvetime = rs.getString("resolve_time");
				boolean resolved = rs.getBoolean("resolved");
				boolean accepted = rs.getBoolean("accepted");
				r = new Reimbursement(id, eid, mid, type, amount, desc, submittime, resolvetime, resolved, accepted);
				rList.add(r);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return rList;
	}
}
