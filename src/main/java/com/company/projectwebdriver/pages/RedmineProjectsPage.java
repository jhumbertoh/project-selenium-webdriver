package com.company.projectwebdriver.pages;

import com.company.projectwebdriver.models.RedmineProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedmineProjectsPage extends RedmineLoginPage{

    private By btnNewProject = By.xpath("//a[text()='New project']");
    private By txtProjectName = By.id("project_name");
    private By txtProjectDescription = By.id("project_description");
    private By txtProjectHomePage = By.id("project_homepage");
    private By chkProjectPublic = By.id("project_is_public");
    private By btnCreate = By.name("commit");
    private By lblMessage = By.id("flash_notice");


    public RedmineProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void createProject(RedmineProject project){

        driver.findElement(btnNewProject).click();
        driver.findElement(txtProjectName).sendKeys(project.getName());
        driver.findElement(txtProjectDescription).sendKeys(project.getDescription());
        driver.findElement(txtProjectHomePage).sendKeys(project.getHomePage());

        WebElement checkBoxProject = driver.findElement(chkProjectPublic);
        if(project.getPublic()){
            if(!checkBoxProject.isSelected())
                checkBoxProject.click();
        }else{
            if(checkBoxProject.isSelected())
                checkBoxProject.click();
        }

        driver.findElement(btnCreate).click();
    }

    public String getUIMessage(){
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblMessage)));
        return driver.findElement(lblMessage).getText();
    }
}
