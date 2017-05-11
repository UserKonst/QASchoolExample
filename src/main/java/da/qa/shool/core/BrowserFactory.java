package da.qa.shool.core;

import com.codeborne.selenide.WebDriverRunner;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.yandex.qatools.allure.annotations.Step;

public class BrowserFactory {

    final static Logger LOG = Logger.getLogger(BrowserFactory.class);
    private static final String GRID_URL = Config.get("gridUrl");

    @Step
    public static WebDriver openBrowser(String browserName) throws MalformedURLException {
        DesiredCapabilities caps = null;

        switch (browserName.toLowerCase()) {
            case "chrome":
                caps = DesiredCapabilities.chrome();
                break;
            case "ie":
                caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                break;

        }

//        WebDriver driver = new RemoteWebDriver(new URL(GRID_URL), caps);
        WebDriver driver = new ChromeDriver(caps);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);

        System.out.println("*** " + browserName.toUpperCase() + " STARTED ***");
        LOG.info("*** BROWSER '" + browserName.toUpperCase() + "' STARTED *** " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        return driver;
    }

    @Step
    public static void closeBrowser() {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                WebDriverRunner.getWebDriver().manage().deleteAllCookies();
                WebDriverRunner.clearBrowserCache();
                WebDriverRunner.closeWebDriver();
                LOG.info("Browser closed");
            }
        } catch (Exception e) {
            LOG.error(e);
        }
    }

}
