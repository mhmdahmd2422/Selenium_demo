package tests;

import base.BaseTest;
import org.testng.annotations.*;
import pages.loginTest;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static base.BaseTest.driver;

public class loginCase {

    loginTest objLogin;
    @BeforeSuite
    public void setup()
    {
        driver = BaseTest.StartBrowser("Chrome", "https://cp-stg.isupply.tech/login");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        objLogin = new loginTest(driver);
    }

    @Test
    public void testDashboardLogin(){
        objLogin.dashLogin("siteadmin@Isupply.tech", "******");
    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest()
    {
        driver.close();
    }

}
