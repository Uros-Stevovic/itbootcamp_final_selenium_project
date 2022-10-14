package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SingUpPage;

public class SingupTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheSignupPage() {
		navPage.getSingupLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl + "signup"), "Not on SINGUP page!");

	}

	@Test(priority = 20)
	public void checkInputTypes() {
		navPage.getSingupLink().click();
		Assert.assertEquals(signupPage.getMailButton().getAttribute("type"), "email", "Wrong email type!");
		Assert.assertEquals(signupPage.getPasswordButton().getAttribute("type"), "password", "Wrong email type!");
		Assert.assertEquals(signupPage.getConfirmPassButton().getAttribute("type"), "password", "Wrong email type!");
	}

	@Test(priority = 30)
	public void displaysErrorsWhenUserAlreadyExists() {
		navPage.getSingupLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl + "signup"), "Not on SINGUP page!");
		signupPage.getNameButton().sendKeys("Another User");
		signupPage.getMailButton().sendKeys("admin@admin.com");
		signupPage.getPasswordButton().sendKeys("12345");
		signupPage.getConfirmPassButton().sendKeys("12345");
		signupPage.getSingMeUpButton().click();
		messagePopUpPage.waitForPopUpToBeVisible();
		messagePopUpPage.getMessageFromPopUp();
		Assert.assertTrue(messagePopUpPage.getMessageFromPopUp().contains("E-mail already exists"),
				"ERROR: Wrong popUp message!");
		Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl + "signup"), "Not on SINGUP page!");
		signupPage.getNameButton().sendKeys("Another User");
	}

	@Test(priority = 40)
	public void signUp() throws InterruptedException {
		navPage.getSingupLink().click();
		signupPage.getNameButton().sendKeys("Uros Stevovic");
		signupPage.getMailButton().sendKeys("uros.swtervovic@itbootcamp.com");
		signupPage.getPasswordButton().sendKeys("12345");
		signupPage.getConfirmPassButton().sendKeys("12345");
		signupPage.getSingMeUpButton().click();
		messagePopUpPage.waitForVerifyAccountPopUpToBeVisible();
		messagePopUpPage.getMessageFromVerifyAccountPopUp();
		Assert.assertTrue(
				messagePopUpPage.getMessageFromVerifyAccountPopUp().contains("IMPORTANT: Verify your account"),
				"ERROR: Wrong popUp message!");
		messagePopUpPage.getCloseButtonFromPopUp().click();
		Thread.sleep(2000);
		navPage.getLogoutButton().click();
	}
}
