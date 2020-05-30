package com.company.projectwebdriver.cucumber.stepdefs;

import com.company.projectwebdriver.models.RedmineProject;
import com.company.projectwebdriver.pages.RedmineHomePage;
import com.company.projectwebdriver.pages.RedmineProjectsPage;
import com.company.projectwebdriver.utils.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class WebRedmineProjectsStepDefs {


    BaseStepDefs baseStepDefs;
    RedmineProjectsPage redmineProjectsPage;

    public WebRedmineProjectsStepDefs(BaseStepDefs baseStepDefs) {
        this.baseStepDefs = baseStepDefs;
    }


    @And("I create a project")
    public void iCreateAProject(Map<String, String> projectData) {

        RedmineHomePage redmineHomePage = (RedmineHomePage) baseStepDefs.currentPage;
        redmineProjectsPage = redmineHomePage.clickOnLink("Projects");

        String number = Util.generateRandomNumber();

        RedmineProject redmineProject = new RedmineProject();
        redmineProject.setName(projectData.get("name") + number);
        redmineProject.setDescription(projectData.get("description") + number);
        redmineProject.setHomePage(projectData.get("homepage") + number);
        redmineProject.setPublic(Boolean.parseBoolean(projectData.get("public")));

        redmineProjectsPage.createProject(redmineProject);
    }

    @Then("The project was successfully created")
    public void theProjectWasSuccessfullyCreated() {

        Assert.assertEquals("Successful creation.", redmineProjectsPage.getUIMessage());

    }
}