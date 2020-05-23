package com.company.projectwebdriver.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");

        driver = new ChromeDriver();

    }

    @AfterAll
    public static void close(){
        driver.quit();
    }

}
