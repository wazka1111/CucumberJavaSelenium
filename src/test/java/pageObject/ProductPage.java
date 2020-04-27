package pageObject;

import models.Address;
import operations.SeleniumOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.XPATH, using = "//button[contains(@class,'btn btn-primary')]")
    private WebElement btn_AddToCart;

    public void click_btn_AddToCart() {
        SeleniumOperations.click(btn_AddToCart);
    }

    @FindBy(how=How.XPATH, using = "//*[@class='btn btn-primary'][1]")
    private WebElement lnk_ProceedToCheckout;

    public void click_lnk_ProceedToCheckout() {
        SeleniumOperations.click(lnk_ProceedToCheckout);
    }

    //Address form

    @FindBy(how=How.XPATH, using = "//button[@class='continue btn btn-primary float-xs-right']")
    private WebElement btn_continue;

    @FindBy(how = How.NAME, using = "address1")
    private WebElement inp_address;

    @FindBy(how=How.NAME, using = "city")
    private WebElement inp_city;

    @FindBy(how=How.NAME, using = "postcode")
    private WebElement inp_zipCode;

    @FindBy(how=How.NAME, using = "id_state")
    private WebElement sel_state;

    @FindBy(how=How.NAME, using = "id_country")
    private WebElement sel_country;

    @FindBy(how=How.XPATH, using = "//button[@name='confirmDeliveryOption']")
    private WebElement btn_continue_shipping;

    public void click_btn_continue_shipping() {
        SeleniumOperations.click(btn_continue_shipping);
    }

    @FindBy(how=How.XPATH, using = "//*[@id='payment-option-2']")
    private WebElement radio_payment;

    @FindBy(how=How.XPATH, using = "//*[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement chbox_agreement;

    @FindBy(how=How.XPATH, using = "//*[@class='btn btn-primary center-block']")
    private WebElement btn_order;

    @FindBy(how=How.XPATH, using = "//*[@class='material-icons rtl-no-flip done']")
    private WebElement lbl_confirmation;

    public boolean isConfirmationVisible() {
       return lbl_confirmation.isDisplayed();
    }

    @FindBy(how=How.XPATH, using = "//a[@class='delete-address text-muted']")
    private WebElement btn_deleteAddress;

    public boolean isAddressAlreadyAdded() {
        List<WebElement> address = driver.findElements(By.xpath("//*[@class='address-footer']//child::a"));
        if (address.size() != 0) {
            return true;
        }return false;
    }

    public void select_payment_method() {
        SeleniumOperations.selectBox(radio_payment);
        SeleniumOperations.selectBox(chbox_agreement);
        SeleniumOperations.click(btn_order);
    }

    public String getTotalPrice() {
        List<WebElement> confirmationTable = driver.findElements(By.xpath("//*[text()='Amount']/following-sibling::dd"));
        WebElement totalPrice=confirmationTable.get(0);
        log.info("Total Price = " + totalPrice.getText());
        return totalPrice.getText();
    }

    public void fillAddressDetails(Address address) {
        SeleniumOperations.typeText(inp_address, address.getAddress());
        SeleniumOperations.typeText(inp_city, address.getCity());
        SeleniumOperations.typeText(inp_zipCode, address.getZipCode());
        SeleniumOperations.selectValueOption(sel_country, address.getCountry());
        SeleniumOperations.selectValueOption(sel_state, address.getState());
        SeleniumOperations.click(btn_continue);
    }

    public void click_delete_address() {
        SeleniumOperations.click(btn_deleteAddress);
    }
}
