package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

	 @Test(priority = 10)
	    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
		 	navPage.getLoginLink().click();
	    	loginPage.getMailButton().sendKeys("admin@admin.com");
	    	loginPage.getPasswordButton().sendKeys("12345");
	    	loginPage.getLoginButton().click();
	    	navPage.getAdminButton().click();
	    	Thread.sleep(2000);
	    	navPage.getCitiesButton().click();
	    	Thread.sleep(2000);
	    	Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl + "admin/cities"), "Not on ADMIN page!");
			
	    }
	 
	    @Test(priority = 20)
	    public void checksInputTypesForCreate_EditNewCity() throws InterruptedException{
	    	navPage.getAdminButton().click();
	    	Thread.sleep(2000);
	    	navPage.getCitiesButton().click();
	    	citiesPage.getNewItemButton().click();
	    	citiesPage.getWaitForCreateDialogToBeVisible();
	    	  Assert.assertEquals(citiesPage.getNameButton().getAttribute("type"), 
	          		"text", "Wrong input type!");
	    	
	    }
	    
	    @Test(priority = 30)
	    public void createNewCity() throws InterruptedException {
	    	navPage.getAdminButton().click();
	    	Thread.sleep(2000);
	    	navPage.getCitiesButton().click();
	    	citiesPage.getNewItemButton().click();
	    	citiesPage.getWaitForCreateDialogToBeVisible();
	    	citiesPage.getNameButton().sendKeys("urosstevovic's city");
	    	citiesPage.getSaveButton().click();
	    	
	    	
	    }
	    
	    @Test(priority = 40)
	    public void editCity() {
	    	String oldCityName = "urosstevovic's city";
	        String newCityName = "urosstevovic's city Edited";
	        navPage.getAdminButton().click();
	        navPage.getCitiesLinkFromDropdown().click();
	        citiesPage.getCitiesButton().sendKeys(oldCityName);
	        citiesPage.waitForNumOfRowsToBe(1);
	        citiesPage.getEditButtonFromRow(1).click();
	        citiesPage.getNameButton().click();
	        citiesPage.getNameButton().sendKeys(Keys.CONTROL + "a");
	        citiesPage.getNameButton().sendKeys(newCityName);
	        citiesPage.getNameButton().click();
	        messagePopUpPage.waitForSuccessPopUpToBeVisible();
	        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().contains("Saved successfully"),
	                "[Error] Pop up message is not Saved successfully");
	    	
	    }
	    
	    @Test(priority = 50)
	    public void searchCity(){
	    	String city = "urosstevovic's city Edited";
	        navPage.getAdminButton().click();
	        navPage.getCitiesLinkFromDropdown().click();
	        citiesPage.getCitiesButton().sendKeys(city);
	        citiesPage.waitForNumOfRowsToBe(1);
	        Assert.assertEquals(citiesPage.getCellFromRow(1, 1).getText(), city,"[Error] City name not correct");
	      
	    }
	    
	    @Test(priority = 60)
	    public void deleteCity(){
	    	 String city = "urosstevovic's city Edited";
	         navPage.getAdminButton().click();
	         navPage.getCitiesLinkFromDropdown().click();
	         citiesPage.getCitiesButton().sendKeys(city);
	         citiesPage.waitForNumOfRowsToBe(1);
	         Assert.assertEquals(citiesPage.getCellFromRow(1, 1).getText(),city, "[Error] City name not correct");
	         citiesPage.getDeleteButtonFromRow(1).click();
	         citiesPage.getWaitForCreateDialogToBeVisible();
	         citiesPage.getDeleteButtonInDeleteDialog().click();
	         messagePopUpPage.waitForSuccessPopUpToBeVisible();
	         Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().contains("Deleted successfully"),
	                 "[Error] Pop up message is not Deleted successfully");
	        
	    }
	
	
	
}
