package com.company.projectwebdriver.cucumber.stepdefs;

import com.company.projectwebdriver.base.BaseTest;
import com.company.projectwebdriver.pages.RedmineLoginPage;

public class BaseStepDefs {

    protected RedmineLoginPage currentPage;

    public BaseStepDefs(){
        currentPage = new RedmineLoginPage(BaseTest.getDriver());
    }
}