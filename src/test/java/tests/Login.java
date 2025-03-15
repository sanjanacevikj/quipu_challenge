package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcomponents.BaseTest;
import testcomponents.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class Login extends BaseTest {

    @Test
    public void loginTest() {

        loginPage.clickSignIn();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }
}
