package operations;

import base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Configuration;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SeleniumOperations {
    private static final int TIME_OUT = 10;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Logger log = LogManager.getLogger();
    public static void openPage(String page) {
        driver = BaseClass.getDriver();
        wait = BaseClass.getWaitDriver();
        driver.navigate().to(page);
    }

    public static void click(WebElement element) {
        wait = new WebDriverWait(driver, Configuration.TIME_OUT_EXPLICITE);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (NoSuchElementException e) {
            e.getMessage();
            BaseClass.cleanUp();
        }
    }

    public static void selectBox(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            e.getMessage();
            BaseClass.cleanUp();
        }
    }

    public static void typeText(WebElement element, String text) {
        wait= new WebDriverWait(driver, Configuration.TIME_OUT_EXPLICITE);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        log.info("Text: " + text+ " has been typed");
    }


    public static String getTitle() {
        return driver.getTitle();
    }
    public static void makeScreenshot(){
        String fileWithPath = "C:\\tmp\\" +"screen"+ getDataStamp() + ".png";
        File screenFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenFile, new File(fileWithPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDataStamp() {
        Date myDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return sdf.format(myDate);
    }

    public static void selectValueOption(WebElement dropdown, String value) {
        wait= new WebDriverWait(driver, Configuration.TIME_OUT_EXPLICITE);
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select dropDown = new Select(dropdown);
        dropDown.selectByVisibleText(value);
    }

    public static boolean isTextVisibleInElement(WebElement element, String text) {
        wait= new WebDriverWait(driver, Configuration.TIME_OUT_EXPLICITE);
        boolean result = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        return result;
    }
}
