package pageObject;

import base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Class is responsible for initialization drivers within all page classes. Newly created page class have to
 * extend BasePage class.
 */
public class BasePage {
    WebDriver driver = BaseClass.getDriver();
    WebDriverWait wait = BaseClass.getWaitDriver();
    protected Logger log = LogManager.getLogger(getClass());
}
