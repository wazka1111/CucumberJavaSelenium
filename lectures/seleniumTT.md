## Selenium - tricks and traps

1. Locators
One of the biggest challenge in Selenium WebDriver is localization all elements on a web page. 
In order to have clean picture it is recommended to have web elements stored in separate page objects respective to sub-page of your application eg: all web elements located on login sub-page will be stored in LoginPage class. 

You can use very convenient annotations @FindBy() or @FindAll. It gives you ability to locate element by the most popular attributes or xpath:


@FindBy(how = How.XPATH, using = "//input[@name='email']")
private WebElement inp_email;

My personal recommendation is xpath as way to find elements on web page. You can combine attributes by using keywords: “and”, “or”. Additionally xpath mechanism provides you several handy functions like: text(), starts-with(), contains()

For more details please refer to: 
•	https://www.swtestacademy.com/xpath-selenium/


Trap 1: Duplicated web elements

Sometimes it’s happen that two or more webElements on a page has exactly the same attributes. Unique identification is a challenge in this case.
I’ve found that case on the test page: 

Email and Password input fields are duplicated. Depending on the part of Personal Information tab we can find one active and second inactive the same element:

 Look at the screenshot below. You can see only one email input field. 















But this is a trap:
When I run one of extend to identify xpath on Mozilla I can see that there are two elements that meet xpath condition. Look at next screenshots. This is HTML representation of email input field. Let’s create xpath and see how many elements we will find:






 
  
Pay attention at my green color highlights – this is xpath (//input[@name=’email’]). 
Result of the search are 2 elements with the same attributes but different indexes. 

What is the impact on your test? Even if xpath is correct, WebElement will by not recognized properly, exception is thrown and test is failed. 

What we can to with that challenge?
1. We can capture both elements into the List using findElements() method.

List<WebElement> inp_emailPurchase = driver.findElements(By.xpath("//input[@name='email']"));

2. When we want to use webElement we can use second element in the List:

inp_emailPurchase.get(1)





Trap 2: Typing address during purchase process:

Look at screenshot below. Here you can see address form. When some address has been provided it is saved like this:


But the same form looks differently when user has not provided any address or current address was deleted:





During run time we need to recognize if address is already provided or not. 
This is my proposal to solve this issue:

public boolean isAddressAlreadyAdded()
{
    List<WebElement> address = driver.findElements(By.xpath("//*[@class='address-											footer']//child::a"));
    if (address.size() != 0)
	 {
       	return true;
    	 }	
	return false;
}

Trap 3: Retrieve total price
Summary of your order is presented within web table. 
Look at HTML representation of the table:



In order to confirm that total price is calculated properly ($26.12)  we should identify proper cell and get the value. 
First of all pay attention on xpath. It is quite complex:
//*[text()='Amount']/following-sibling::dd

Next we need save all element that meet this condition in List. Here is my proposal to solve this problem:

public String getTotalPrice()
 {
    List<WebElement> confirmationTable = 							driver.findElements(By.xpath("//*[text()='Amount']/following-sibling::dd"));
    WebElement totalPrice=confirmationTable.get(0);
    log.info("Total Price = " + totalPrice.getText());
    return totalPrice.getText();
}
