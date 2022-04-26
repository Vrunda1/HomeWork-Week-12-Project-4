package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        sendTextToElement(By.xpath("//input[@id='txtUsername']"), "Admin");

        // Enter “admin123 password
        sendTextToElement(By.xpath("//input[@id='txtPassword']"), "admin122");

        //click on the ‘Forgot your password’ link
        clickOnElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));

        //Verify the text ‘Forgot Your Password?’
        String expectedResult = "Forgot Your Password?";
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));

        Assert.assertEquals(expectedResult, actual);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
