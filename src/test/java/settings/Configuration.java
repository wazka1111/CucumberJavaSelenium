package settings;

public class Configuration {
    public static final String BROWSER="CHROME";
    //public static final String CHROME_DRIVER_PATH="C:\\Users\\DH\\Desktop\\cucumberSeleniumDemo\\libs\\chromedriver.exe";//windows
    public static final String CHROME_DRIVER_PATH="/var/lib/jenkins/workspace/SeleniumCucumberPipelinee_master/dlibs/chromedriver.exe";//linux
    
    //Options: YES - headless mode, NO - normal mode with visible browser window.
    public static final String HEADLESS_BROWSER_MODE="NO";
    public static final int TIME_OUT_EXPLICITE=10;
    public static final int TIME_OUT_IMPLICITE=1;
}
