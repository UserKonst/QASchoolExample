package da.qa.school.tests;

import static com.codeborne.selenide.Selenide.open;
import da.qa.school.tests.config.BaseTest;
import da.qa.shool.pages.BasePage;
import da.qa.shool.pages.SearchPage;
import da.qa.shool.pages.SearchResultPage;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

@Features({"Feature 4"})
public class Test4 extends BaseTest {

    private SearchPage searchPage;
    private SearchResultPage resultPage;
    private BasePage basePage;

    @BeforeClass
    public void pause() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }
    
    @Test
    public void page_url_should_contains_google_com() {
        searchPage = open("https://google.com.ua", SearchPage.class);
        resultPage = searchPage.search("automated-testing");
        basePage = resultPage.openPageByNumber(1);
        assertEquals(basePage.getCurrentUrl(), "http://automated-testing.inf");
    }
}
