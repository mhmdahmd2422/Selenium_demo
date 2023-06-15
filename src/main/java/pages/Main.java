package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;

import static base.BaseTest.driver;

public class Main extends locators
{
    public static void main(String[] args) throws InterruptedException {
        String baseURL = "https://cp-stg.isupply.tech";
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL + "/login");
        driver.manage().window().maximize();
        WebElement email = driver.findElement(emailInput);
        email.sendKeys("siteadmin@Isupply.tech");
        WebElement password = driver.findElement(passwordInput);
        password.sendKeys("Qwe@1234");
        WebElement submit = driver.findElement(submitButton);
        submit.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(confirmSubmit));
        WebElement confirmLogin = driver.findElement(confirmSubmit);
        confirmLogin.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("Dashboard"));
        driver.get(baseURL + "/orders/create");

        String cname = "ahmed";
        WebElement customerInput = driver.findElement(customerSearch);
        customerInput.sendKeys(cname);
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(customerResultList));
        Thread.sleep(1000);
        List<WebElement> customerTypes = driver.findElements(customerResultList);
        //System.out.println(customerTypes.size());
        for (WebElement ctype : customerTypes) {
            //System.out.println("Values " + ctype.getAttribute("innerHTML"));
            if (ctype.getText().contains(cname)) {
                ctype.click();
                break;
            }
        }
        Thread.sleep(2000);
        List<String> dataExpected = Arrays.asList("API GROW SACHET PDR 10 150 G", "76876", "Sellerman1", "1", "67.00", "0%", "67", "67");
        List<String> dataExpectedTable = Arrays.asList("", "Sellerman1", "1", "67.00", "SUNDAY: from: 2:38:00 PM to: 5:38:00 PM", "Buyer not coded for this seller", "0", "");
        WebElement SellerInput = driver.findElement(By.xpath("//input[@id='s2id_autogen2']"));
        String sname = "Sellerman1";
        SellerInput.sendKeys(dataExpected.get(2));
        Thread.sleep(2000);
        List<WebElement> sellerTypes = driver.findElements(By.xpath("//body/div[@id='select2-drop']/ul[1]/li"));
        System.out.println(sellerTypes.size());
        for (WebElement stype : sellerTypes) {
            //System.out.println("Values " + stype.getAttribute("innerHTML"));
            if (stype.getText().contains(sname)) {
                stype.click();
                break;
            }
        }
        Thread.sleep(2000);

        WebElement productInput = driver.findElement(By.xpath("//input[@id='s2id_autogen3']"));
        String pname = "API GROW SACHET PDR 10 150 G";
        productInput.sendKeys(pname);
        Thread.sleep(3000);
        List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@id='select2-results-3']/li"));
        System.out.println(productTypes.size());
        for (WebElement ptype : productTypes) {
            //System.out.println("Values " + ptype.getAttribute("innerHTML"));
            if (ptype.getText().contains(pname)) {
                ptype.click();
                break;
            }
        }

        WebElement productAdd = driver.findElement(By.xpath("//button[@id='submit_add_product']"));
        productAdd.click();

        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.xpath("//select[@name='sellers']")));
        select.selectByIndex(1);

        Thread.sleep(2000);
        WebElement orderSummery = driver.findElement(By.xpath("//button[contains(text(),'Order Summary')]"));
        WebElement orderSend = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", orderSummery);
        Thread.sleep(2000);
        List<String> dataActual = new ArrayList<>();
        List<WebElement> orderDetail = driver.findElements(locators.orderSummeryTable);
        Iterator<WebElement> itr = orderDetail.iterator();
        while (itr.hasNext()) {
                String test = itr.next().getText();
                if (test != null) {
                    dataActual.add(test);
                }
            }
        Assert.assertEquals(dataExpectedTable, dataActual);
        js.executeScript("arguments[0].click();", orderSend);

        driver.get(baseURL + "/orders/order-management");
        Thread.sleep(500);
        WebElement orderView = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]//a[1]"));
        Thread.sleep(500);
        //System.out.println(orderView.getAttribute("innerHTML"));
        orderView.click();
        Thread.sleep(500);
        List<WebElement> orderDetail2 = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[1]/td"));
        System.out.println(orderDetail.size());
        Iterator<WebElement> itr2 = orderDetail.iterator();
        while(itr.hasNext()) {
            dataActual.add(itr.next().getText());
        }
        Assert.assertEquals(dataExpected, dataActual);
    }
    }