package com.company.projectwebdriver.webapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesTest {

    @Test
    public void selectingCheckbox(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/project-selenium-webdriver/webapp/checkboxestest.html");

        WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));

        checkbox.click();
        checkbox.click();

        driver.quit();
    }


}
