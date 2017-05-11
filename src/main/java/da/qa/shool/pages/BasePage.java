package da.qa.shool.pages;

import static com.codeborne.selenide.Selenide.$;
import da.qa.shool.core.utils.WebDriverUtil;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class BasePage {
 public BasePage() {
        WebDriverUtil.waitForDocumentReady();
    }

    @Step
    public String getCurrentUrl() {
        return WebDriverUtil.getCurrentUrl();
    }

    @Step
    public boolean isElementDisplayed(By locator) {
        return $(locator).isDisplayed();
    }
}
