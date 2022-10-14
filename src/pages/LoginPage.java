package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMailButton() {
		return driver.findElement(By.xpath("//*[@id='email']"));
	}

	public WebElement getPasswordButton() {
		return driver.findElement(By.xpath("//*[@id='password']"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@type='submit']"));
	}

}
