package da.qa.shool.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private SelenideElement fldSearch;

    @FindBy(name = "btnG")
    private SelenideElement btnSearch;

    @FindBy(id = "hplogo")
    private SelenideElement logo;

    @Step
    public SearchResultPage search(String text) {
        fldSearch.sendKeys(text);
        btnSearch.click();
        return page(SearchResultPage.class);
    }

    @Step
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    @Step
    public boolean isBtnSearchDisplayed() {
        return $(By.xpath("(//input[@type='submit'])[1]")).isDisplayed();
    }

}
