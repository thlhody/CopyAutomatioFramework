package sharedData;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sharedData.browser.BrowserFactory;

public class SharedData {

    private WebDriver webDriver;

    @BeforeMethod
    public void PrepareDriver() {
        webDriver = new BrowserFactory().getBrowserInstance();
    }

    @AfterMethod
    public void ClearDriver() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}