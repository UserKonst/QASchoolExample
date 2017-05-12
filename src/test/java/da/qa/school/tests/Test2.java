package da.qa.school.tests;

import static com.codeborne.selenide.Selenide.open;
import da.qa.school.tests.config.BaseTest;
import da.qa.shool.pages.SearchPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

@Features({"Feature 2"})
public class Test2 extends BaseTest {

    private SearchPage searchPage;

    @Test
    public void google_logo_should_be_displayed() {
        searchPage = open("https://google.com.ua", SearchPage.class);
        assertTrue(searchPage.isLogoDisplayed());
    }
}
