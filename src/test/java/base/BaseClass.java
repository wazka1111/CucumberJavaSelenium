package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * BaseClass is the main place where driver configuration happens.
 * WebDriver is set once (singleton) and exposed to other classes.
 */
public class BaseClass {
    private static BaseClass baseClass;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private  Logger log = LogManager.getLogger(getClass());

    private BaseClass(String mode, String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Configuration.CHROME_DRIVER_PATH);
            ChromeOptions chromeOptions = new ChromeOptions();
            //Standard mode. Browser's GUI is visible
            if (mode.equalsIgnoreCase("NO")) {
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver();
                log.info("Chrome - page loading...");
                //Headless mode without visible browser window.
            } else if (mode.equalsIgnoreCase("YES")) {
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                log.info("Chrome - headless mode started...");
            }
            driver.manage().timeouts().implicitlyWait(Configuration.TIME_OUT_IMPLICITE, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    public static void setDriver(String mode, String browser) {
        if (baseClass == null) {
            baseClass = new BaseClass(mode, browser);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWaitDriver() {
        return wait;
    }

    public static void cleanUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        baseClass = null;
    }
}
