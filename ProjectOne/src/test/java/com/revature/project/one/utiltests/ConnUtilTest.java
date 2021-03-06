package com.revature.project.one.utiltests;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.project.one.utils.ConnUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConnUtilTest {
	//This is a test to ensure that my Connection Utility is a Singleton.
	private static Connection connObj1 = ConnUtil.getInstance();
	private static Connection connObj2 = ConnUtil.getInstance();
	
	@Test
	@Order(1)
	void ConnectionUtilTest() {
		Assertions.assertEquals(connObj1, connObj2);
	}
}
