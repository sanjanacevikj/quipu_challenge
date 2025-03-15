package pages;

import org.openqa.selenium.By;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    // Locators using @FindBy
    @FindBy(css = ".product_list .product-container")  // First product in search results
    private WebElement firstProduct;

    @FindBy(css = "button[name='Submit']")  // Add to cart button
    private WebElement addToCartButton;

    @FindBy(css = ".layer_cart_product")  // Confirmation popup
    private WebElement cartConfirmation;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFirstProduct() {
        waitForElementToAppear(firstProduct);
        firstProduct.click();
    }

    public boolean isAddToCartButtonClickable() {
        waitForElementToAppear(addToCartButton);
        return wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)) != null;
    }

    public void clickAddToCart() {
        waitForElementToAppear(addToCartButton);
        addToCartButton.click();
    }

    public boolean isProductAddedToCart() {
        waitForElementToAppear(cartConfirmation);
        return cartConfirmation.isDisplayed();
    }
}