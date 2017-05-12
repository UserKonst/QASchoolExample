package da.qa.school.tests.good;

import static com.codeborne.selenide.Selenide.open;
import da.qa.school.tests.config.BaseTest;
import da.qa.shool.pages.SearchPage;
import da.qa.shool.pages.SearchResultPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

@Features({"Some other feature 1"})
public class Test1 extends BaseTest {

    private SearchPage searchPage;
    private SearchResultPage resultPage;
    private final String TEXT = "Automated testing";

    @Test
    public void first_search_result_should_contains_automated_testing() {
        searchPage = open("https://google.com.ua", SearchPage.class);
        resultPage = searchPage.search(TEXT);
        String resultText = resultPage.getFirstResultHeader();
    }
}
