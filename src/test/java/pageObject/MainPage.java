package pageObject;

import operations.SeleniumOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Clothes
    @FindBy(how=How.XPATH, using = "//a[@class='dropdown-item'][1]")
    private WebElement lnk_clothes;

    public void click_lnk_clothes() {
        SeleniumOperations.click(lnk_clothes);
    }

    //Man
    @FindBy(how = How.XPATH, using = "//*[starts-with(text(), 'MEN')]")
    private WebElement lnk_men;

    public void click_lnk_man() {
        SeleniumOperations.click(lnk_men);
    }

    //Tshirt
    @FindBy(how=How.XPATH, using = "//a[@class='thumbnail product-thumbnail']")
    private WebElement lnk_Tshirt;

    public void click_lnk_tshirt() {
        SeleniumOperations.click(lnk_Tshirt);
    }

}
