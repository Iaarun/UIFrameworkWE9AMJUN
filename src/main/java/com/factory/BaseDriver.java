package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver intializeDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
				tdriver.set(new FirefoxDriver());
		}else {
			System.out.println(browser +"borwser not supported");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

//	public static void main(String[] args) {
//		BaseDriver bd = new BaseDriver();
//		bd.intializeDriver();
//	}

}
