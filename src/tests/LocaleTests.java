package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

	@Test(priority = 10)
    public void setLocaleToES() throws InterruptedException {
		navPage.getLanguageButton().click();
		Thread.sleep(4000);
		navPage.getESButton().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Página de aterrizaje"),
                "Error: Header does not contain Página de aterrizaje");
    }
    @Test(priority = 20)
    public void setLocaleToEN() throws InterruptedException {
    	navPage.getLanguageButton().click();
    	Thread.sleep(1000);
    	navPage.getEnButton().click();
    	Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Landing"),
                "Error: Header does not contain Landing");
    }
    @Test(priority = 30)
    public void setLocaleToCN() {
    	navPage.getLanguageButton().click();
    	navPage.getCNButton().click();
    	Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("首页"),
                "Error: Header does not contain 首页");
    }
    @Test(priority = 40)
    public void setLocaleToFR() {
    	navPage.getLanguageButton().click();
    	navPage.getFRButton().click();
    	Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Page d'atterrissage"),
                "Error: Header does not contain Page d'atterrissage");
    }
	
	
	
}
