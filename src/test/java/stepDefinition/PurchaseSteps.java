package stepDefinition;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.MainPage;
import pageObject.ProductPage;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurchaseSteps {
    Address bradAddress;
    private MainPage mainPage;
    private ProductPage productPage;
    private final WebDriver driver = BaseClass.getDriver();
    private final WebDriverWait wait = BaseClass.getWaitDriver();

    //>>>>>>>  Steps  <<<<<<<<<<<<<<<<

    @When("Brad Pitt select men's TShirt")
    public void brad_Pitt_navigate_to_Clothes_section() {
        mainPage=new MainPage(driver);
        mainPage.click_lnk_clothes();
        mainPage.click_lnk_man();
        mainPage.click_lnk_tshirt();
    }

    @When("Brad Pitt proceed to checkout")
    public void brad_Pitt_select_ADD_TO_CART_button() {
        productPage = new ProductPage(driver);
        productPage.click_btn_AddToCart();
        productPage.click_lnk_ProceedToCheckout();
        productPage.click_lnk_ProceedToCheckout();
    }

    @When("Brad Pitt fill Address, City, State, Zip Code, Country")
    public void brad_Pitt_fill_Address_City_State_Zip_Code(List<String> address) {
        if (productPage.isAddressAlreadyAdded()) {
            productPage.click_delete_address();
        }
        bradAddress = new Address(address);
        productPage.fillAddressDetails(bradAddress);
    }

    @When("Brad Pitt select shipping method")
    public void brad_Pitt_select_shipping_method() {
        productPage.click_btn_continue_shipping();
    }

    @When("Brad Pitt select payment method")
    public void brad_Pitt_select_payment_method() {
        productPage.select_payment_method();
    }

    @Then("Brad Pitt is able to see order confirmation")
    public void brad_Pitt_is_able_to_see_order_confirmation() {
        assertThat(productPage.isConfirmationVisible(), equalTo(true));
    }

    @Then("Brad Pitt is able to see correct total price")
    public void brad_Pitt_is_able_to_see_correct_total_price(List<String> totalPrice) {
        assertThat(productPage.getTotalPrice(), equalTo(totalPrice.get(0)));
    }
}
