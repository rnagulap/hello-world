package com.aq.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 *  accelQ, Inc. ("COMPANY") PROPRIETARY AND CONFIDENTIAL (c) 2014
 * 
 *  NOTICE: All information contained herein is, and remains the property of
 *  COMPANY. The intellectual and technical concepts contained herein are
 *  proprietary to COMPANY and may be covered by U.S. and Foreign Patents,
 *  Patents in process, and or protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material is
 *  strictly forbidden unless prior written permission is obtained from COMPANY.
 *  Access to the source code contained herein is hereby forbidden to anyone
 *  except current COMPANY employees, managers or contractors who have executed
 *  Confidentiality and Non-disclosure agreements explicitly covering such
 *  access.
 * 
 */

/**
 * @author ravikanth
 * @date Jun 22, 2016
 */
public class SeleniumTest {
    public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.google.com");
	
	WebElement element = driver.findElement(By.name("q"));
	element.sendKeys("Cheese!");
	element.submit();
	
	System.out.println("Title: " + driver.getTitle());
	
	new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

	    @Override
	    public Boolean apply(WebDriver f) {
		return f.getTitle().toLowerCase().startsWith("cheese");
	    }
	});
	System.out.println("Title: " + driver.getTitle());
	
	driver.close();
    }
}
