package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “Admin” username
        sendTextToElement(By.xpath("//input[@id='txtUsername']"),"Admin");
        // Enter “admin123 password
        sendTextToElement(By.xpath("//input[@id='txtPassword']"),"admin123");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("btnLogin"));

        String expectedMessage = "Welcome";
        String actualResult = getTextFromElement(By.xpath("//a[@id='welcome']"));
        String substr = actualResult.substring(0,7);
        //Verifying the ‘Welcome’ text is display
       Assert.assertEquals(expectedMessage, substr);
    }
    @After
    public void tearDown() {
       closeBrowser();
   }
}
