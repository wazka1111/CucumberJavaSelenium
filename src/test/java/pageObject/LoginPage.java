package pageObject;

import models.Address;
import models.Credentials;
import operations.SeleniumOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sign in")
    private WebElement lnk_signIn;

    public void click_lnk_signIn() {
        SeleniumOperations.click(lnk_signIn);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    private WebElement inp_email;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    private WebElement inp_password;

    @FindBy(how=How.XPATH, using = "//*[@class='form-footer text-sm-center clearfix']//child::button")
    private WebElement btn_continue;

    public void click_btn_continue() {
        SeleniumOperations.click(btn_continue);
    }

    public void input_email_and_password(Credentials credentials) {
        SeleniumOperations.typeText(inp_email, credentials.getLogin());
        SeleniumOperations.typeText(inp_password, credentials.getPassword());
    }

    /**
     * Login and password input fields are duplicated during purchase.
     * @param credentials
     */
    public void input_email_and_password_purchase(Credentials credentials) {
        List<WebElement> inp_emailPurchase = driver.findElements(By.xpath("//input[@name='email']"));
        List<WebElement> inp_passwdPurchase = driver.findElements(By.xpath("//input[@name='password']"));
        SeleniumOperations.typeText(inp_emailPurchase.get(1), credentials.getLogin());
        SeleniumOperations.typeText(inp_passwdPurchase.get(1), credentials.getPassword());
    }

    @FindBy(how = How.XPATH, using = "//button[@id='submit-login']")
    private WebElement btn_submit;

    public void click_submit_button() {
        SeleniumOperations.click(btn_submit);
    }


}
