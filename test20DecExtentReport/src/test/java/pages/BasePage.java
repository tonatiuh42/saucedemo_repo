package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public LoginPage lp;
	
	@BeforeMethod
	public void setUp() {
		openBrowserAndNavigateToUrl();
		lp = new LoginPage(driver);
		lp.login();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void openBrowserAndNavigateToUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}
	
	public void waitForElementToBeDisplayed(WebElement element) {
		wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(5));
		wait.ignoring(WebDriverException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void wait(int miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		}catch(Exception e) {}
	}
	
}
