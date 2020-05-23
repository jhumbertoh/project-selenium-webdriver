package com.company.projectwebdriver.webapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioButtonsTest {

    @Test
    public void choosingRadioButton() {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/project-selenium-webdriver/webapp/radiobuttonstest.html");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        radioButtons.get(1).click();

        driver.quit();
    }

    @Test
    public void gettingRadioButtonValue() {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/project-selenium-webdriver/webapp/radiobuttonstest.html");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        radioButtons.get(1).click();

        String colorActual = "";

        for(WebElement radioButton : radioButtons){
            if(radioButton.isSelected()){
                colorActual = radioButton.getAttribute("value");
            }
        }

        assertEquals("green",colorActual, "No se encuentra la opción" );

        driver.quit();
    }

}