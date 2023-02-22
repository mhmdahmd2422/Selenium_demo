package tests;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import pages.OrderTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static base.BaseTest.driver;

public class orderCase {
    List<String> dataExpected = Arrays.asList("API GROW SACHET PDR 10 150 G", "76876", "Sellerman2", "1", "67.00", "0%", "67", "67");
    OrderTest objOrder;
    @BeforeClass
    public void setup()
    {
        driver.get("https://cp-stg.isupply.tech/orders/create");
    }

    @Test
    public void testCustomerSelection() throws InterruptedException {
        objOrder = new OrderTest(BaseTest.driver);
        objOrder.setCustomer("ahmed");
        objOrder.selectCustomer("ahmed");
        objOrder.setSeller(dataExpected.get(2));
        objOrder.selectSeller(dataExpected.get(2));
        objOrder.setProduct(dataExpected.get(0));
        objOrder.selectProduct(dataExpected.get(0));
        objOrder.addProductstoCart();
        objOrder.chooseProductSeller();
        objOrder.getOrderSummery();
        //objOrder.validateOrderSummery();
        objOrder.sendOrder();
        objOrder.validateOrderIssued();
        Thread.sleep(5000);
    }
}
