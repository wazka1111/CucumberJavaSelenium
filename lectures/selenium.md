## Selenium project

1. Page Object Pattern - POP

We are going to use POP concept. In order to do that let’s create separate package and first page class inside: Login

→ Constructor

Each page class have to contains constructor:  

```java
public Login(WebDriver driver) {
    PageFactory.initElements(driver, this);
}
```

→ WebElement localization

In order to find elements we are going to use @FindBy() annotation:

```java
@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sign in")
private WebElement lnk_signIn;
```

→ Operations on elements

Within the code just after elements definitions we are going to put all actions that we want to perform on that eg: click, sendKeys.


        NOTE!
        Each class have to contains driver initialization. Let’s consider many page classes. 
        To avoid code redundant we can create BasePage class. 
        Here we define drivers once and driver is sharing between all page classes when BasePage class is extended.

2. WebDriver

It is not easy to manage driver in big framework. One of proposal to handle that challenge is BaseClass. Here we can define singleton. Static method setDriver() in called once in @Before hook. 
Other static method getDriver() can be called wherever you need driver instance. In this solution we have 100% certain that framework uses still the same driver instance.   
BaseClass is good place where we can define browser manager. Also we are adding switch in order to select headless mode (the mode where test is executed without visible browser window)

3. SeleniumOperations

In order to have additional layer we can create SeleniumOperations class and place there all action methods provided by selenium libs. 
This wrapper contains following static methods: openPage(), click(), typeText(), makeScreenshot(). 
There is one crucial purpose to do that: we can define all additional operations eg: set explicit wait, clear text field and input desired text and log details at the end.  


4. Configuration

For practical reasons it is good to have “one place configuration”. 
Here we can define all config details except test data related to each single scenario. Test data will be provided in feature file or other external data source. 

5. Models

Those are domain classes related to business objects. This model object is provided as single parameter whenever business model is necessary to complete test eg: credentials(login and password)
Let’s use it in step definition class:

```java
@When("Brad Pitt type his correct credentials")
public void brad_Pitt_type_his_correct_credentials() {
    bradPittCredentials=new Credentials("brad@op.pl", "12345");
    login=new Login(driver);
    login.click_lnk_signIn();
    login.input_email_and_password(bradPittCredentials);
    login.click_submit_button();
}
```

        TIP: 
        In the example below login and password ("brad@op.pl", "12345") have been provided directly. 
        Of course you can use external source of test data (file, database)
