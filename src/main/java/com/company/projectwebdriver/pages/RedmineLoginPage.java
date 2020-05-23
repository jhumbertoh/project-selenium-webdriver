package com.company.projectwebdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineLoginPage extends Page{

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//*[@id='login-submit']");

    public RedmineLoginPage(WebDriver driver){
        super(driver);
    }

    public RedmineHomePage login(String username, String password){
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
        return new RedmineHomePage(driver);
    }

}
