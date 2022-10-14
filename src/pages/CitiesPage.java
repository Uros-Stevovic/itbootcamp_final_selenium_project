package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.className("mdi-plus"));
	}

	public WebElement getCitiesButton() {
		return driver.findElement(By.xpath("//*[@id='search']"));
	}

	public WebElement getNameButton() {
		return driver.findElement(By.xpath("//*[@id='name']"));
	}
	
	public void getWaitForCreateDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='name']")));
	}

	public void getWaitForDeliteDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class='v-card__text body-1 text-body-1 py-3']")));
	}

	public WebElement getSaveButton() {
		return driver.findElement
		(By.xpath("//*[@class='btnSave v-btn v-btn--text theme--light v-size--default green--text text--lighten3']"));
	}
	
	public WebElement getDeleteButtonInDeleteDialog() {
		return driver.findElement(By.xpath("//button[contains(@class, 'red--text')]"));
	}

	public void waitForNumOfRowsToBe(int rows) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rows + 1));
	}

	public WebElement getCellFromRow(int row, int cell) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + (cell + 1) + "]"));
	}

	public WebElement getEditButtonFromRow(int row) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'edit']"));
	}

	public WebElement getDeleteButtonFromRow(int row) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td/div/button[@id = 'delete']"));
	}

}
