package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.SystemProps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static base.BaseTest.driver;
import static pages.locators.*;
import static pages.webElements.orderDetail;

public class OrderTest extends BasePage {
    public OrderTest(WebDriver driver){
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private void chooseListedItem(String iname, By listed){
        waitVisibility(listed);
        List<WebElement> itemTypes = driver.findElements(listed);
        for(WebElement itype:itemTypes){
            if(itype.getText().contains(iname)){
                itype.click();
                break;
            }
        }
    }
    private void jsExecuter(WebElement button){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);
    }
    public void setCustomer(String strCustomer){
        writeText(customerSearch, strCustomer);
    }
    public void selectCustomer(String strCustomer) throws InterruptedException {
        Thread.sleep(1000);
        chooseListedItem(strCustomer, customerResultList);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfElementsToBe(customerDatatable, 7));
    }

    public void setSeller(String strSeller) throws InterruptedException {
        writeText(sellerSearch, strSeller);
    }

    public void selectSeller(String strSeller) throws InterruptedException {
        Thread.sleep(1000);
        chooseListedItem(strSeller, sellerResultList);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(sellerChoices));
    }

    public void setProduct(String strProduct){
        writeText(productSearch, strProduct);
    }

    public void selectProduct(String strProduct) throws InterruptedException {
        Thread.sleep(1000);
        chooseListedItem(strProduct, productResultList);
    }
    public void addProductstoCart(){
        click(productAdd);
    }
    public void chooseProductSeller() {
        Select select = new Select(driver.findElement(productSellers));
        select.selectByIndex(1);
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.attributeToBeNotEmpty(webElements.productSellerList, "data-oldsellerid"));
    }
    WebElement orderSummery = driver.findElement(locators.orderSummery);
    public void getOrderSummery() throws InterruptedException {
        Thread.sleep(500);
        jsExecuter(orderSummery);
    }
    List<WebElement> orderDetail = driver.findElements(locators.orderSummeryTable);
    List<String> dataActual = new ArrayList<>();
    List<String> dataExpectedTable = Arrays.asList("", "Sellerman1", "1", "67.00", "SUNDAY: from: 2:38:00 PM to: 5:38:00 PM", "Buyer not coded for this seller", "0", "");
    List<String> dataExpected = Arrays.asList("API GROW SACHET PDR 10 150 G", "76876", "Sellerman2", "1", "67.00", "0%", "67", "67");
    public void validateOrderSummery(){
        Iterator<WebElement> itr = orderDetail.iterator();
        while (itr.hasNext()) {
            String test = itr.next().getText();
            if (test != null) {
                dataActual.add(test);
            }
        }
        Assert.assertEquals(dataExpectedTable, dataActual);
    }
    WebElement orderSend = driver.findElement(locators.orderSave);
    public void sendOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfElementsToBe(orderSummeryTable, 8));
        jsExecuter(orderSend);
    }
    WebElement orderView = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//a"));

    public void validateOrderIssued(){
        driver.get("https://cp-stg.isupply.tech/orders/order-management");
        orderView.click();
        List<WebElement> orderDetail = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[1]/td"));
        System.out.println(orderDetail.size());
        Iterator<WebElement> itr = orderDetail.iterator();
        while(itr.hasNext()) {
            dataActual.add(itr.next().getText());
        }
        Assert.assertEquals(dataExpected, dataActual);
    }
}
