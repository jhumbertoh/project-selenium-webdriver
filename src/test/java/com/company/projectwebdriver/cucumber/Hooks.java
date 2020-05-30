package com.company.projectwebdriver.cucumber;

import com.company.projectwebdriver.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@E2E")
    public static void setUp(){
        BaseTest.setUp();
    }

    @After("@E2E")
    public static void tearDown(){
        BaseTest.close();
    }
}