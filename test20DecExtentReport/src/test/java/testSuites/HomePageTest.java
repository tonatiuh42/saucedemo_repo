package testSuites;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{

	HomePage hp;
	
	@Test
	public void addingItemToCart() {
		hp = new HomePage(driver);
		waitForElementToBeDisplayed(hp.firstItemAddToCartButton);
		Assert.assertTrue(hp.firstItemAddToCartButton.isDisplayed());
		Assert.assertEquals(hp.firstItemAddToCartButton.getText(), "Add to cart");
		hp.firstItemAddToCartButton.click();
		wait(500);
		waitForElementToBeDisplayed(hp.firstItemRemoveFromCartButton);
		Assert.assertTrue(hp.firstItemRemoveFromCartButton.isDisplayed());
		Assert.assertEquals(hp.firstItemRemoveFromCartButton.getText(), "Remove");
		waitForElementToBeDisplayed(hp.shoppingCartItemsLabel);
		Assert.assertTrue(hp.shoppingCartItemsLabel.isDisplayed());
		Assert.assertEquals(hp.shoppingCartItemsLabel.getText(), "1");
	}
	
	@Test
	public void itemsListDisplayed() {
		hp = new HomePage(driver);
		waitForElementToBeDisplayed(hp.inventoryContainer);
		Assert.assertTrue(hp.inventoryContainer.isDisplayed());
	}
	
}
