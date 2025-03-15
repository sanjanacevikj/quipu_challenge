package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcomponents.BaseTest;
import testcomponents.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class Cart extends BaseTest {
    private final String searchQuery = "dress";

    @BeforeMethod
    public void performSearch() {
        searchPage.enterSearchQuery(searchQuery);
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isSearchSuccessful(), "Search was not successful");
    }

    @Test
    public void addToCartTest() {
        cartPage.selectFirstProduct();
        Assert.assertTrue(cartPage.isAddToCartButtonClickable(), "Add to Cart button is not clickable");
        cartPage.clickAddToCart();
        Assert.assertTrue(cartPage.isProductAddedToCart(), "Product was not added to cart successfully");
    }
}
