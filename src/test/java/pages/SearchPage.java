package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(className = "product_list")
    private WebElement searchResultsContainer;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterSearchQuery(String query) {
        waitForElementToAppear(searchInput);
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    public void clickSearchButton() {
        waitForElementToAppear(searchButton);
        searchButton.click();
    }

    public boolean isSearchSuccessful() {
        waitForElementToAppear(searchResultsContainer);
        try {
            List<WebElement> results = driver.findElements(By.cssSelector(".product_list .product-container"));
            return !results.isEmpty();
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught! Retrying...");
            List<WebElement> results = driver.findElements(By.cssSelector(".product_list .product-container")); // Refetch
            return !results.isEmpty();
        }
    }


}
