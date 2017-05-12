package da.qa.school.tests;

import static com.codeborne.selenide.Selenide.open;
import da.qa.school.tests.config.BaseTest;
import da.qa.shool.pages.BasePage;
import da.qa.shool.pages.SearchPage;
import da.qa.shool.pages.SearchResultPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

@Features({"Feature 4"})
public class Test4 extends BaseTest {

    private SearchPage searchPage;
    private SearchResultPage resultPage;
    private BasePage basePage;

    @Test
    public void page_url_should_contains_google_com() {
        searchPage = open("https://google.com.ua", SearchPage.class);
        resultPage = searchPage.search("automated-testing");
        basePage = resultPage.openPageByNumber(1);
        assertEquals(basePage.getCurrentUrl(), "http://automated-testing.inf");
    }
}
