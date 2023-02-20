package tests;

import org.example.loginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.example.SystemProps;

import java.util.concurrent.TimeUnit;

public class loginCase {
    WebDriver driver;
    loginTest objLogin;
    @BeforeTest
    public void setup(){
       //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
       driver = new ChromeDriver();
       //To maximize browser
       driver.manage().window().maximize();
       //Implicit wait
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get("https://cp-stg.isupply.tech/login");
    }

    @Test
    public void testDashboardLogin(){
        objLogin = new loginTest(driver);
        objLogin.dashLogin("siteadmin@Isupply.tech", "Qwe@1234");
    }

    @AfterTest
    //Test cleanup
    public void TeardownTest()
    {
        driver.quit();
    }

}
