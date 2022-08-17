package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class SearchTest extends CoreTestCase {

    @Test
    public void testFindJava() {

        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input"
        );
        searchInput.click();

        searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find search input"
        );

        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent (
                 "xpath://*[contains(@text,'Island of Indonesia')]",
                "Cannot find result 'Island fo Indonesia' on 'Java' search",
                20


        );
        expectedResult.click();

    }
}
