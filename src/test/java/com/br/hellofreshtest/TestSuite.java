package com.br.hellofreshtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	            RegisterNewUserTest.class,
	            LoginWithExistingUserTest.class,
	            AddClassicBoxToCartAndCheckout.class
})

public class TestSuite {
	
	@BeforeClass
	public static void initTest(){
	}

	@AfterClass
	public static void endTest(){
	}

}
