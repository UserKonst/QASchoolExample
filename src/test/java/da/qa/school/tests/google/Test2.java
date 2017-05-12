package da.qa.school.tests.google;

import static com.codeborne.selenide.Selenide.open;
import da.qa.school.tests.config.BaseTest;
import da.qa.shool.pages.SearchPage;
import da.qa.shool.pages.SearchResultPage;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

@Features({"Some other feature 2"})
public class Test2 extends BaseTest {

    private SearchPage searchPage;
    private SearchResultPage resultPage;
    private final String TEXT = "automated-testing.info";

    @Test
    public void first_search_result_should_contains_automated_testing() {
        searchPage = open("https://google.com.ua", SearchPage.class);
        resultPage = searchPage.search(TEXT);
        String resultText = resultPage.getFirstResultHeader();
        assertEquals(resultText, TEXT);
    }
}
