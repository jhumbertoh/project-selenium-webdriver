package com.company.projectwebdriver.cucumber.stepdefs;

import com.company.projectwebdriver.pages.RedmineHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebRedmineLoginStepDefs {

    BaseStepDefs baseStepDefs;
    RedmineHomePage redmineHomePage;

    public WebRedmineLoginStepDefs(BaseStepDefs baseStepDefs){
        this.baseStepDefs = baseStepDefs;
    }

    @Given("I go to the Redmine login page on URL")
    public void iGoToTheRedmineLoginPageOnURL() {
        System.out.println("I go to the Redmine login page on URL");
    }


    @When("I login with my credentials user {string} and {string}")
    public void iLoginWithMyCredentialsUserAnd(String user, String password) {

        redmineHomePage = baseStepDefs.currentPage.login(user, password);
        baseStepDefs.currentPage = redmineHomePage;
    }

    @Then("I should see the homepage with the username {string}")
    public void iShouldSeeTheHomepageWithTheUsername(String username) {

        String userExpected = "Logged in as user";
        String userActual = redmineHomePage.getUserLogged();

        Assert.assertEquals(userExpected, userActual);

    }
}