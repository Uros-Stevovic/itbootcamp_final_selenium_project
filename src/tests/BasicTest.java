package tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicTest {
	
	  	protected WebDriver driver;
	  	protected WebDriverWait wait;
	    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
	    protected LoginPage loginPage;
	    protected NavPage navPage;
	    protected SingUpPage signupPage;
	    protected CitiesPage citiesPage;
	    protected MessagePopUpPage messagePopUpPage;
	
	    @BeforeClass
	    public void beforeClass() {
	        System.setProperty("webdriver.chrome.driver",
	        		"drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        loginPage = new LoginPage(driver);
	        navPage = new NavPage(driver, wait);
	        signupPage = new SingUpPage(driver);
	        citiesPage = new CitiesPage(driver, wait);
	        messagePopUpPage = new MessagePopUpPage(driver, wait);
	    
	    }

	
	    @BeforeMethod
	    public void beforeMethod() {
	        driver.get(baseUrl);
	        driver.manage().window().maximize();
	    }

	    @AfterMethod
	    public void afterMethod(ITestResult result) {
	       
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	
	
	
	
	
	
	
}
