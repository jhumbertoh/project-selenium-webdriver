package com.company.projectwebdriver.base;

import com.company.projectwebdriver.pages.RedmineLoginPage;
import com.company.projectwebdriver.utils.Urls;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static RedmineLoginPage redmineLoginPage;

    @BeforeAll
    public static void setUp(){

        setChromeDriverProperty();

        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Urls.REDMINE_LOGIN);

        redmineLoginPage = new RedmineLoginPage(driver);
    }

    @AfterAll
    public static void close(){
        driver.quit();
    }

    private static void setChromeDriverProperty(){
        if(System.getProperty("os.name").contains("windows")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        }
        driver = new ChromeDriver();
    }
}
