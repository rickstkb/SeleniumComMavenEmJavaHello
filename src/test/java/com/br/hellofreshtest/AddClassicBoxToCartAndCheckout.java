package com.br.hellofreshtest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.ConfigProperties;

public class AddClassicBoxToCartAndCheckout {

	static WebDriver driver;

	static int sleepTime = Integer.parseInt(ConfigProperties.getValue("sleepTime"));

	static String userEmail;
	static String userPassword;

	@BeforeClass
	public static void configTest() throws Exception {

		driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Provas e Frames Automacao\\HelloFresh\\chromedriver.exe");
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

		driver.findElement(By.cssSelector(".fela-117bnn9")).click();
		Thread.sleep(sleepTime + sleepTime);

		driver.findElement(By.cssSelector(".fela-1quxzlt")).click();
		Thread.sleep(sleepTime);

		if (ConfigProperties.getValue("url").equals("https://www.hellofresh.com")) {
			driver.findElement(By.xpath(".//*[@id='hf-plans']/div[1]/div/div[2]/div/div/div[2]/div[3]/div/button"))
					.click();
		} else {
			driver.findElement(By.xpath(".//*[@id='hf-plans']/div[1]/div/div[2]/div/div/div[3]/button")).click();
		}

		Thread.sleep(sleepTime);

		String actualStringPlan = driver.findElement(By.cssSelector(".col-xs-12.cart-summary-bold")).getText()
				.toString();
		assertTrue(actualStringPlan.contains("Classic Plan"));

		String actualStringPrice = driver.findElement(By.cssSelector(".col-xs-4.text-right")).getText();
		assertTrue(actualStringPrice.contains("$59.94"));
	}

	@AfterClass
	public static void finishTest() throws Exception {
		driver.quit();
	}

}
