package da.qa.school.tests.listeners;

import com.codeborne.selenide.WebDriverRunner;
import da.qa.shool.core.utils.Attach;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MethodInvocationListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iim, ITestResult itr) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iim, ITestResult testResult) {
        if (!testResult.isSuccess() && WebDriverRunner.hasWebDriverStarted()) {
            Attach.screenshot();
            Attach.pageHtml();
            Attach.pageUrl();
        }
    }

}
