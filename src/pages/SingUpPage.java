package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage {

	private WebDriver driver;

	public SingUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getNameButton() {
		return driver.findElement(By.xpath("//*[@id='name']"));		
	}
	public WebElement getMailButton() {
		return driver.findElement(By.xpath("//*[@id='email']"));		
	}
	public WebElement getPasswordButton() {
		return driver.findElement(By.xpath("//*[@id='password']"));		
	}
	public WebElement getConfirmPassButton() {
		return driver.findElement(By.xpath("//*[@id='confirmPassword']"));		
	}
	public WebElement getSingMeUpButton() {
		return driver.findElement(By.xpath("//*[@type='submit']"));
	}
	
	
	
	
	
	
}
