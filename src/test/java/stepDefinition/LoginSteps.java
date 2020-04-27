package stepDefinition;

import base.BaseClass;
import operations.SeleniumOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObject.LoginPage;
import models.Credentials;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginSteps {
    private LoginPage login;
    private final WebDriver driver = BaseClass.getDriver();
    private final WebDriverWait wait = BaseClass.getWaitDriver();
    private static Logger log = LogManager.getLogger();
    Credentials bradPittCredentials;


    //>>>>>>>>>>>>>>>DataTable Type<<<<<<<<<<<
    @DataTableType
    public Credentials credentials(Map<String, String> entry) {
        return new Credentials(
                entry.get("login"),
                entry.get("password"));
    }

    //>>>>>>>>>>>>  Steps  <<<<<<<<<<<<<<<<<<<<<<<<


    @Given("Store page is opened")
    public void store_page_is_opened(List<String> url) {
        SeleniumOperations.openPage(url.get(0));
    }

    @When("Brad Pitt type his correct credentials during login")
    public void brad_Pitt_type_his_correct_credentials_during_login() throws InterruptedException {
        bradPittCredentials=new Credentials("brad@op.pl", "12345");
        login=new LoginPage(driver);
        login.click_lnk_signIn();
        login.input_email_and_password(bradPittCredentials);
        login.click_submit_button();
    }

    @When("Brad Pitt type his correct credentials during purchase")
    public void brad_Pitt_type_his_correct_credentials_during_purchase() throws InterruptedException {
        bradPittCredentials=new Credentials("brad@op.pl", "12345");
        login=new LoginPage(driver);
        login.click_lnk_signIn();
        login.input_email_and_password_purchase(bradPittCredentials);
        login.click_btn_continue();
    }

    @Then("Brad Pitt is logged properly into his account")
    public void brad_Pitt_is_logged_properly_into_his_account(List<String> title) {
        assertThat(SeleniumOperations.getTitle(), equalTo(title.get(0)));
    }
}
