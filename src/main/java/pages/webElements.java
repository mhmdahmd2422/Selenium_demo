package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static base.BaseTest.driver;

public class webElements {
    static WebElement orderSummery = driver.findElement(locators.orderSummery);
    static WebElement orderSend = driver.findElement(locators.orderSave);
    static WebElement productSellerList = driver.findElement(locators.productSellerslist);
    static List<WebElement> orderDetail = driver.findElements(locators.orderSummeryTable);
    public static WebElement orderView = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//a[1]"));

}
