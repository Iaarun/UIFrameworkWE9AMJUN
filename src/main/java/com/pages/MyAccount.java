package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
	
	 private WebDriver driver;
     By username=  By.xpath("//div[@class='welcome-msg']/p/strong");
     
     public MyAccount(WebDriver driver) {
        this.driver = driver;
 
	}
     
     public String getUsername() {
    	return  driver.findElement(username).getText();
     }
}
