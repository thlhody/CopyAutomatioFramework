package sharedData.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Map;

public class FirefoxService implements BrowserService {

    private WebDriver webDriver;

    @Override
    public void openBrowser(Map<String, String> testData) {
        // aceasta metoda are ca scop sa deschida un chrome cu configurarile noastre

        FirefoxOptions firefoxOptions = (FirefoxOptions) getBrowserOptions(testData);
        webDriver = new FirefoxDriver(firefoxOptions);
        webDriver.get(testData.get("url"));
        webDriver.manage().window().maximize();
        // wait implicit
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public Object getBrowserOptions(Map<String, String> testData) {
        // configuram optiunile pentru browserul nostru
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(testData.get("gpu"));
        firefoxOptions.addArguments(testData.get("infobars"));
        firefoxOptions.addArguments(testData.get("extensions"));
        firefoxOptions.addArguments(testData.get("sendbox"));
        if (!testData.get("headless").isEmpty()) {
            firefoxOptions.addArguments((testData.get("headless")));
        }


        return firefoxOptions;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}