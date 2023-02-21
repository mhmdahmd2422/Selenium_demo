package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.OrderTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginTest;
import java.util.concurrent.TimeUnit;
import static base.BaseTest.driver;

public class orderCase {
    OrderTest objOrder;

//    @BeforeTest
//    public void browserlaunch()
//    {
//        driver = BaseTest.StartBrowser("Chrome", "https://cp-stg.isupply.tech/login");
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//    }

    @BeforeClass
    public void setup()
    {
        driver.get("https://cp-stg.isupply.tech/orders/create");
    }

    @Test
    public void testCustomerSelection() throws InterruptedException {
        objOrder = new OrderTest(BaseTest.driver);
        objOrder.setCustomer("ahmed");
        objOrder.selectCustomer();
        Thread.sleep(5000);
//        objOrder.setSeller("Sellerman1");
//        Thread.sleep(1000);
    }
}
