package sharedData.browser;

import org.openqa.selenium.WebDriver;
import propertyUtility.PropertyUtility;

import java.util.Map;

public class BrowserFactory {
    // apilicam desgin patternul "Factory Method" ca sa definim un obiect care sa primeasca o instanta diferita de browser

    public WebDriver getBrowserInstance() {
        PropertyUtility propertyUtility = new PropertyUtility("atfData");
        Map<String, String> browserData = propertyUtility.getAllData();
        String cIcD = System.getProperty("cIcD");
        String browser = System.getProperty("browser");
        if (Boolean.parseBoolean(cIcD)) {
            browserData.put("headless", "--headless=new");
        } else {
            browser = browserData.get("browser");
        }

        System.out.println("!!!!!!!!");
        System.out.println(browser);

        // dupa ce am aflat pe ce env trebuie sa rulez deschid browserul dorit
        switch (browser) {
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser(browserData);
                return chromeService.getWebDriver();
            case "firefox":
                FirefoxService firefoxService = new FirefoxService();
                firefoxService.openBrowser(browserData);
                return firefoxService.getWebDriver();
//            case "safari":
//                SafariService safariService = new SafariService();
//                safariService.openBrowser(browserData);
//                return  safariService.getWebDriver();
        }
        return null;
    }
}