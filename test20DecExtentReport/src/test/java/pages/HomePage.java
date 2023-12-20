package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
		PageFactory.initElements(factory,this);
	}
	
	//------------------------ELEMENTS----------------------
	@FindBy(css=".inventory_container") public WebElement inventoryContainer;
	@FindBy(css="#add-to-cart-sauce-labs-backpack") public WebElement firstItemAddToCartButton;
	@FindBy(css="#remove-sauce-labs-backpack") public WebElement firstItemRemoveFromCartButton;
	@FindBy(css=".shopping_cart_badge") public WebElement shoppingCartItemsLabel;
	
	//-------------------------METHODS----------------------
	
}
