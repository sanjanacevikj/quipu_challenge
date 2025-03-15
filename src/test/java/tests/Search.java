package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcomponents.BaseTest;
import testcomponents.ExtentTestListener;

@Listeners(ExtentTestListener.class)
public class Search extends BaseTest {
    private final String searchQuery = "dress";

    @Test
    public void searchTest() {
        searchPage.enterSearchQuery(searchQuery);
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isSearchSuccessful(), "Search was not successful");
    }
}

