package tests;

import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static base.BaseTest.driver;

public class issuedOrderCase {
    issuedOrder issuedOrder;
    @BeforeClass
    public void setup()
    {
        driver.get("https://cp-stg.isupply.tech/orders/order-management");
    }
   @Test
    public void testIssuedOrder() throws InterruptedException {
       issuedOrder = new issuedOrder(BaseTest.driver);
       issuedOrder.validateOrderIssued();
   }
}
