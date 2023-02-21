package tests;

import pages.OrderTest;
import pages.OrderTest.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginTest;

import java.util.concurrent.TimeUnit;

public class orderCase {
    WebDriver driver;
    OrderTest objOrder;

    @BeforeTest
    public void setup(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://cp-stg.isupply.tech/orders/create");
    }

    @Test
    public void testCustomerSelection(){
        objOrder = new OrderTest(driver);
        objOrder.setCustomer("ahmed");
    }
}
