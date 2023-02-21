package tests;

import base.BaseTest;
import pages.loginTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class loginCase {
    WebDriver driver;
    loginTest objLogin;
    @BeforeTest
    public void browserlaunch()
    {
        driver = BaseTest.StartBrowser("Chrome", "https://cp-stg.isupply.tech/login");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        objLogin = new loginTest(driver);
    }

    @Test
    public void testDashboardLogin(){
        objLogin.dashLogin("siteadmin@Isupply.tech", "Qwe@1234");
    }

    @AfterTest
    //Test cleanup
    public void TeardownTest()
    {
        driver.quit();
    }

}
