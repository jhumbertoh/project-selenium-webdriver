package com.company.projectwebdriver.redmine;

import com.company.projectwebdriver.base.BaseTest;
import com.company.projectwebdriver.pages.RedmineHomePage;
import com.company.projectwebdriver.pages.RedmineLoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedmineTest extends BaseTest {


    @Test
    public void loginRedmine(){

        String user = "jhurtado", password = "passw0rd";
        String userExpected = "Logged in as jhurtado";

        RedmineHomePage redmineHomePage =  redmineLoginPage.login(user, password);

        String userActual = redmineHomePage.getUserLogged();

        assertEquals(userExpected, userActual);
    }


    @Test
    public void loginOld(){

        //System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER_PATH"));
        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8081");

        assertEquals("Redmine", driver.getTitle(), "El titulo de la pagina no es el correcto");

        WebElement linkLogin = driver.findElement(By.linkText("Iniciar sesión"));
        linkLogin.click();

        /* XPATH Relativo*/
        //*[@id="username"]

        /* XPATH FULL*/
        ///html/body/div/div[2]/div[1]/div[3]/div[2]/div[2]/form/input[4]

        WebElement txtUsername = driver.findElement(By.id("username"));
        txtUsername.sendKeys("jhurtado");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("passw0rd");

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id='login-submit']"));
        btnLogin.click();

        WebElement lblLogin = driver.findElement(By.xpath("//*[@id='loggedas']"));
        String actualUser = lblLogin.getText();
        String expectedUser = "Logged in as jhurtado";

        assertEquals(expectedUser, actualUser, "El usuario no ingresó correctamente");

        //Usar solo probar nuestra automatización, no es una buena práctica dejar los Thread en nuestro código
        /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        driver.quit();
    }
}