package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Reusable method to wait for an element to be visible
    protected WebElement waitForElementToAppear(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Reusable method to wait for an element and click it
    protected void waitAndClick(WebElement element) {
        waitForElementToAppear(element).click();
    }

    // Reusable method to wait for an element and send keys
    protected void waitAndType(WebElement element, String text) {
        WebElement webElement = waitForElementToAppear(element);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected List<WebElement> waitForElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}

