package com.company.projectwebdriver.redmine;

import com.company.projectwebdriver.base.BaseTest;
import com.company.projectwebdriver.models.RedmineProject;
import com.company.projectwebdriver.pages.RedmineHomePage;
import com.company.projectwebdriver.pages.RedmineLoginPage;
import com.company.projectwebdriver.pages.RedmineProjectsPage;
import org.junit.jupiter.api.Test;

public class RedmineProjectTest extends BaseTest {


    @Test
    public void testCreateProjectRedmine() {

        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        RedmineProjectsPage redmineProjectsPage = redmineHomePage.clickOnLink("Projects");

        RedmineProject redmineProject = new RedmineProject();
        redmineProject.setName("RedmineProjectName");
        redmineProject.setDescription("Esta es una descripción de prueba");
        redmineProject.setHomePage("RedmineProjectName");
        redmineProject.setPublic(true);


        redmineProjectsPage.createProject(redmineProject);



        System.out.println("");
    }
}
