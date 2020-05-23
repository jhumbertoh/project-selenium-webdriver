package com.company.projectwebdriver.webapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectItemTest {

    @Test
    public void usingSelect(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/project-selenium-webdriver/webapp/selectitemtest.html");

        WebElement selectElement = driver.findElement(By.id("select1"));

        Select select = new Select(selectElement);
        select.selectByVisibleText("Maybe");

        driver.quit();

    }

}
