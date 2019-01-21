package com.test.centrica.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunSelenium {
	static WebDriverWait wait;

	public static void makePayment(String paymentUrl) throws InterruptedException {
		paymentUrl = paymentUrl.replace("&amp;", "&");
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(paymentUrl);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 400);

//		 driver.switchTo().frame(driver.findElement(By.id("spreedly-number-frame-1398")));

		driver.findElement(By.id("cardNumber")).sendKeys("4444333322221111");
		driver.findElement(By.id("cardholderName")).sendKeys("Rahul Kumar");
		driver.findElement(By.id("expiryMonth")).sendKeys("11");
		driver.findElement(By.id("expiryYear")).sendKeys("2019");
		driver.findElement(By.id("expiryYear")).sendKeys("2019");
		driver.findElement(By.id("securityCode")).sendKeys("111");
		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
