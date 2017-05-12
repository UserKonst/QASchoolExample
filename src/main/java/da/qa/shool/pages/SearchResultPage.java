package da.qa.shool.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "(//div[@class='g'])[1]")
    private SelenideElement divResult;

    public String getFirstResultHeader() {
        return divResult.$(By.xpath(".//h3")).text();
    }

}
