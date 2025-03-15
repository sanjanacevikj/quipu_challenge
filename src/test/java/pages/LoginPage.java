package pages;

import org.openqa.selenium.By;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcomponents.Config;

public class LoginPage extends BasePage {

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(className = "account")
    private WebElement accountName;

    private final String email = Config.EMAIL;
    private final String password = Config.PASSWORD;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        waitForElementToAppear(signInButton);
        signInButton.click();
    }

    public void enterEmail() {
        waitForElementToAppear(emailInput);
        emailInput.sendKeys(email);
    }

    public void enterPassword() {
        waitForElementToAppear(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        waitForElementToAppear(loginButton);
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        waitForElementToAppear(accountName);
        return accountName.isDisplayed();
    }
}
