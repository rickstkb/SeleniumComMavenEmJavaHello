package com.br.hellofreshtest;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import configurations.ConfigProperties;

public class RegisterNewUserTest {

	static WebDriver driver;

	static int sleepTime = Integer.parseInt(ConfigProperties.getValue("sleepTime"));

	static int min;
	static int max;
	static int randomNum;
	static String userEmail;

	@BeforeClass
	public static void configTest() throws Exception {

		driver = null;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		min = 0;
		max = 100000;
		randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		userEmail = "teste@msn.com" + randomNum;

	}

	@Test
	public void runTest() throws InterruptedException {

		driver.get(ConfigProperties.getValue("url"));
		Thread.sleep(sleepTime);

		driver.findElement(By.cssSelector(".fela-1hc09cg")).click();
		Thread.sleep(sleepTime);

		driver.findElement(By.cssSelector("#register-user-link")).click();
		Thread.sleep(sleepTime);

		// Gender
		WebElement elementoGender = driver.findElement(By.cssSelector("#gender-input"));
		Select seletorGender = new Select(elementoGender);
		seletorGender.selectByValue("male");

		// First Name
		WebElement ElementoFirstName = driver.findElement(By.cssSelector("#first-name-input"));
		ElementoFirstName.sendKeys("PrimeiroNome");

		// Last Name
		WebElement ElementoLastName = driver.findElement(By.cssSelector("#last-name-input"));
		ElementoLastName.sendKeys("UltimoNome");

		// E-mail
		WebElement ElementoEmail = driver.findElement(By.cssSelector("#email-input"));
		ElementoEmail.sendKeys(userEmail);

		// Password
		WebElement ElementoPassword = driver.findElement(By.cssSelector("#password-input"));
		ElementoPassword.sendKeys("12345678");

		// Month
		WebElement ElementoMonth = driver.findElement(By.cssSelector("#month-input"));
		ElementoMonth.sendKeys("03");

		// Day
		WebElement ElementoDay = driver.findElement(By.cssSelector("#day-input"));
		ElementoDay.sendKeys("14");

		// Year
		WebElement ElementoYear = driver.findElement(By.cssSelector("#year-input"));
		ElementoYear.sendKeys("1979");

		// Newsletter
		WebElement bmwCheckBox = driver.findElement(By.cssSelector("#register-input"));
		bmwCheckBox.click();

		driver.findElement(By.cssSelector("#register-button")).click();
		Thread.sleep(sleepTime);

	}

	@AfterClass
	public static void finishTest() throws Exception {
		driver.quit();
	}

}