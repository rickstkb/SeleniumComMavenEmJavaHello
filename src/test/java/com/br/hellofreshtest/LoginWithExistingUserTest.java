package com.br.hellofreshtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.ConfigProperties;

public class LoginWithExistingUserTest {

	static WebDriver driver;

	static int sleepTime = Integer.parseInt(ConfigProperties.getValue("sleepTime"));

	static String userEmail;
	static String userPassword;

	@BeforeClass
	public static void configTest() throws Exception {

		driver = null;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		userEmail = "teste@msn.com74714";
		userPassword = "12345678";

	}

	@Test
	public void runTest() throws InterruptedException {

		driver.get(ConfigProperties.getValue("url"));
		Thread.sleep(sleepTime);

		driver.findElement(By.cssSelector(".fela-1hc09cg")).click();
		Thread.sleep(sleepTime);

		// E-mail
		WebElement ElementoEmail = driver.findElement(By.cssSelector("#email-input"));
		ElementoEmail.sendKeys(userEmail);

		// Password
		WebElement ElementoPassword = driver.findElement(By.cssSelector("#password-input"));
		ElementoPassword.sendKeys("12345678");

		driver.findElement(By.cssSelector("#submit-login-button")).click();
		Thread.sleep(sleepTime);
	}

	@AfterClass
	public static void finishTest() throws Exception {
		driver.quit();
	}

}