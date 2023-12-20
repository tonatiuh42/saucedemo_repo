package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory,this);
	}

	//-------------------------ELEMENTS----------------------------
	@FindBy(css="[data-test='username']") public WebElement usernameInput;
	@FindBy(css="[data-test='password']") public WebElement passwordInput;
	@FindBy(css="[data-test='login-button']") public WebElement loginButton;

	private String username="standard_user";
	private String password="secret_sauce";
	
	//-------------------------METHODS-------------------------------
	public void login() {
		waitForElementToBeDisplayed(usernameInput);
		Assert.assertTrue(usernameInput.isDisplayed());
		Assert.assertEquals(usernameInput.getAttribute("placeholder"), "Username");
		usernameInput.sendKeys(username);
		waitForElementToBeDisplayed(passwordInput);
		Assert.assertTrue(passwordInput.isDisplayed());
		Assert.assertEquals(passwordInput.getAttribute("placeholder"), "Password");
		passwordInput.sendKeys(password);
		waitForElementToBeDisplayed(loginButton);
		Assert.assertTrue(loginButton.isDisplayed());
		Assert.assertEquals(loginButton.getAttribute("value"), "Login");
		loginButton.click();
	}
}
