package testcomponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.SearchPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    private final String baseUrl = "http://www.automationpractice.pl/index.php";
    protected LoginPage loginPage;
    protected SearchPage searchPage;
    protected CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(baseUrl);

        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
