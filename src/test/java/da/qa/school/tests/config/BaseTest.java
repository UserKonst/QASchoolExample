package da.qa.school.tests.config;

import da.qa.shool.core.Browser;
import da.qa.shool.core.BrowserFactory;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends TestProps {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void openBrowser(@Optional(Browser.CHROME) String browserName) throws Exception {
        BrowserFactory.openBrowser(browserName);
        TimeUnit.SECONDS.sleep(2);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        BrowserFactory.closeBrowser();
    }
}
