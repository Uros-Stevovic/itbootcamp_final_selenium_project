package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getHomeButton() {
        return driver.findElement(By.className("mdi-home"));
    }
	
	public WebElement getAboutButton() {
        return driver.findElement(By.className("mdi-help"));
    }
    public WebElement getCitiesLinkFromDropdown() {
        return driver.findElement(By.className("btnAdminCities"));
    }
	
	public WebElement getMyProfileButton() {
        return driver.findElement(By.className("mdi-face"));
    }
	public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }
	public WebElement getCitiesButton() {
        return driver.findElement(By.xpath("//*[@class='v-icon notranslate mdi mdi-city theme--light']"));
    }
	public WebElement getUsersButton() {
        return driver.findElement(By.xpath("//*[@id='list-item-97']"));
    }
	public WebElement getLoginLink() {
        return driver.findElement(By.xpath("//*[@class='v-icon notranslate mdi mdi-lock theme--light']"));
    }
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@type='submit']"));
	}
	public WebElement getSingupLink() {
        return driver.findElement(By.xpath("//*[@class='v-icon notranslate mdi mdi-plus-circle-outline theme--light']"));
    }

	public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//*[@class='v-icon notranslate v-icon--left mdi mdi-exit-to-app theme--light']"));
    }
	public WebElement getLanguageButton() {
        return driver.findElement(By.xpath("//*[@class='v-icon notranslate mdi mdi-earth theme--light']"));
    }
	
	public WebElement getEnButton() {
        return driver.findElement(By.xpath("//*[@class='v-list-item v-list-item--link theme--light btnEN']"));
    }
	public WebElement getESButton() {
        return driver.findElement(By.xpath("//*[@class='v-list-item v-list-item--link theme--light btnES']"));
    }
	public WebElement getFRButton() {
        return driver.findElement(By.xpath("//*[@class='v-list-item v-list-item--link theme--light btnFR']"));
    }
	public WebElement getCNButton() {
        return driver.findElement(By.xpath("//*[@class='v-list-item v-list-item--link theme--light btnCN']"));
    }
	
	
}
