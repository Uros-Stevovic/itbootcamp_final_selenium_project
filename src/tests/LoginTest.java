package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest {

	@Test (priority = 10)
    public void visitsTheLoginPage() throws InterruptedException {
       navPage.getLanguageButton().click();
        navPage.getEnButton().click();
//		
        navPage.getLoginLink().click();
        Thread.sleep(2000);
      Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl+ "login"), "Not on LOGIN page!");
    }
	
	
    @Test (priority = 20)
    public void checkInputTypes(){
        navPage.getLoginLink().click();
        Assert.assertEquals(loginPage.getMailButton().getAttribute("type"), 
        		"email", "Wrong email type!");
        
        Assert.assertEquals(loginPage.getPasswordButton().getAttribute("type"), 
        		"password", "Wrong password type!");
        
    }
//    
//    
    @Test (priority = 30)
    public void displaysErrorsWhenUserDoesNotExist(){
    	navPage.getLoginLink().click();
    	loginPage.getMailButton().sendKeys("non-existing-user@gmal.com");
    	loginPage.getPasswordButton().sendKeys("password123");
    	loginPage.getLoginButton().click();
    	messagePopUpPage.waitForPopUpToBeVisible();
    	messagePopUpPage.getMessageFromPopUp();
    	Assert.assertTrue(messagePopUpPage.getMessageFromPopUp().contains("User does not exists"), 
    			"ERROR: Wrong popUp message!");
    	 Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl+ "login"), "Not on LOGIN page!");
    	
    }
    @Test (priority = 40)
    public void displaysErrorsWhenPasswordIsWrong(){
    	navPage.getLoginLink().click();
    	loginPage.getMailButton().sendKeys("admin@admin.com");
    	loginPage.getPasswordButton().sendKeys("password123");
    	loginPage.getLoginButton().click();
    	messagePopUpPage.waitForPopUpToBeVisible();
    	messagePopUpPage.getMessageFromPopUp();
    	Assert.assertTrue(messagePopUpPage.getMessageFromPopUp().contains("Wrong password"), 
    			"ERROR: Wrong popUp message!");
    	 Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl+ "login"), "Not on LOGIN page!");
    }
    @Test (priority = 50)
    public void login() throws InterruptedException {
    	navPage.getLoginLink().click();
    	loginPage.getMailButton().sendKeys("admin@admin.com");
    	loginPage.getPasswordButton().sendKeys("12345");
    	loginPage.getLoginButton().click();
    	Thread.sleep(2000);
    	Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl+ "home"), "ERROR: Unexpected URL!");
    }
    @Test (priority = 60)
    public void logout(){
      
    	 Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "Error: Logout button is not displayed!");
    	navPage.getLogoutButton().click();
    }
	
	
	
	
}
