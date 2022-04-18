package com.revature.project.one.daotests;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(JUnitPlatform.class)
@SelectClasses({com.revature.project.one.daotests.EmpDAOTest.class,com.revature.project.one.daotests.ReimDAOTest.class})
public class TestSuite {
}
