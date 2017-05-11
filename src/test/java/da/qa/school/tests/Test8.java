package da.qa.school.tests;

import static com.codeborne.selenide.Selenide.open;
import da.qa.school.tests.config.BaseTest;
import da.qa.shool.pages.SearchPage;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

@Features({"Feature 1"})
public class Test8 extends BaseTest {

    private SearchPage searchPage;

    @Test
    public void some_test_method() {
        searchPage = open("https://google.com.ua", SearchPage.class);
        assertTrue(searchPage.getCurrentUrl().contains("google.com"));
    }
}
