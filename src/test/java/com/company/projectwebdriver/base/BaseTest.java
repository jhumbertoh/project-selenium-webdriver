package com.company.projectwebdriver.base;

import com.company.projectwebdriver.pages.RedmineLoginPage;
import com.company.projectwebdriver.utils.Urls;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected static WebDriver driver;
    protected static RedmineLoginPage redmineLoginPage;

    @BeforeClass
    public static void setUp(){

        String browserName = System.getenv("browserName");
        browserName = (browserName != null) ? browserName.toLowerCase() : "";

        switch (browserName){
            case "firefox":
                setFirefoxDriverProperty(browserName);
                break;
            case "safari":
                setSafariDriverProperty(browserName);
                break;
            default:
                setChromeDriverProperty(browserName);
        }

        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
    }

    @AfterClass
    public static void close(){
        driver.quit();
    }

    private static void setChromeDriverProperty(String browserName){
        if(System.getProperty("os.name").contains("windows")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        }

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName(browserName);

        try {
            driver = new RemoteWebDriver(new URL(Urls.SELENIUM_GRID),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //driver = new ChromeDriver();
    }

    private static void setFirefoxDriverProperty(String browserName){
        if(System.getProperty("os.name").contains("windows")){
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver.exe");
        }
        else {
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver");
        }

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName(browserName);

        try {
            driver = new RemoteWebDriver(new URL(Urls.SELENIUM_GRID),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //driver = new FirefoxDriver();
    }

    private static void setSafariDriverProperty(String browserName){

        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        capabilities.setBrowserName(browserName);

        try {
            driver = new RemoteWebDriver(new URL(Urls.SELENIUM_GRID),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new SafariDriver();

    }

    public static WebDriver getDriver(){
        return driver;
    }
}