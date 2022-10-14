package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	

	public void waitForPopUpToBeVisible(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }
	 public String getMessageFromPopUp(){
	        return driver.findElement(By.tagName("li")).getText();
	    }
	
	 public WebElement getCloseButtonFromPopUp(){
	        return driver.findElement(By.xpath("//*[text()='Close']"));
	    }
	
	 public void waitForSuccessPopUpToBeVisible(){
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	    }
	    public String getMessageFromSuccessPopUp(){
	        return driver.findElement(By.className("success")).getText();
	    }
	 
	    public void waitForVerifyAccountPopUpToBeVisible (){
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	    }
	    public String getMessageFromVerifyAccountPopUp(){
	        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]")).getText();
	    }
	    public WebElement getCloseButtonFromVerifyAccountPopUp(){
	        return driver.findElement(By.className("btnClose"));
	    }
	 
	 
	 
	 
	 
	 
	 
}
