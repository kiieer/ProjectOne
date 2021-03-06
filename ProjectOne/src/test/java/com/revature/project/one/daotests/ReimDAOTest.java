package com.revature.project.one.daotests;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.project.one.dao.RemDAO;
import com.revature.project.one.dao.RemDAOPostgres;
import com.revature.project.one.entities.Reimbursement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReimDAOTest {
	private static RemDAO rdao = new RemDAOPostgres();
	private static Reimbursement globalReim;
	
	@AfterAll
	 static void reset() {
		rdao.deleteReimbursement("test");
	}
	
	@Test
	@Order(1)
	void createReimbursementTest() {
		Reimbursement r1 = new Reimbursement(1337, 1, 2, "test", 404, "unittest", "2022-04-17", "2022-04-17", true, false);
		rdao.createReimbursement(r1, 1);
		ReimDAOTest.globalReim = r1;
		Assertions.assertEquals("test", globalReim.getType());
	}
	
	@Test
	@Order(2)
	void manageReimbursementTest() {
		Reimbursement r1 = new Reimbursement(1337, 1, 2, "test", 404, "unittest", "2022-04-17", "2022-04-17", true, false);
		RemDAO dao = mock(RemDAOPostgres.class);
	    doCallRealMethod().when(dao).resolveReimbursement(isA(Reimbursement.class), isA(Integer.class));
	    dao.resolveReimbursement(r1, 2);
	    verify(dao, times(1)).resolveReimbursement(r1, 2);
	}
}
