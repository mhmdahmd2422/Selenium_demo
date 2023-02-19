package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.SystemProperties;
//import utils.uiSelectors.UISelectors;
//import helpers.ui.WebActionsHelper;


import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cp-stg.isupply.tech/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("identifier"));
        email.sendKeys("siteadmin@Isupply.tech");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Qwe@1234");


        WebElement submit = driver.findElement(By.id("kt_sign_in_submit"));
        submit.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.swal2-confirm.btn.btn-primary")));
        WebElement confirmLogin = driver.findElement(By.xpath("//div[contains(@class,'swal2-popup swal2-modal swal2-icon-success swal2-show')]//div[contains(@class,'swal2-actions')]//button[contains(@class,'swal2-confirm btn btn-primary')]"));
        confirmLogin.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("Dashboard"));
        driver.get("https://cp-stg.isupply.tech/orders/create");

        String cname = "ahmed";
        WebElement customerInput = driver.findElement(By.id("s2id_autogen1"));
        customerInput.sendKeys(cname);
        //WebElement customerResult = driver.findElement(By.xpath( "/html[1]/body[1]/div[8]/ul[1]/li[1]/div[1]"));
        //customerResult.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> customerTypes = driver.findElements(By.xpath( "//ul[@id='select2-results-1']/li"));
        System.out.println(customerTypes.size());
        for(WebElement ctype:customerTypes){
            //System.out.println("Values " + ptype.getAttribute("innerHTML"));
            if(ctype.getText().contains(cname)){
                ctype.click();
                break;
            }
        }
        Thread.sleep(2000);

        WebElement SellerInput = driver.findElement(By.id("s2id_autogen2"));
        String sname = "Sellerman1";
        SellerInput.sendKeys(sname);
        //WebElement customerResult = driver.findElement(By.xpath( "/html[1]/body[1]/div[8]/ul[1]/li[1]/div[1]"));
        //customerResult.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> sellerTypes = driver.findElements(By.xpath( "//body/div[@id='select2-drop']/ul[1]/li"));
        System.out.println(sellerTypes.size());
        for(WebElement stype:sellerTypes){
            System.out.println("Values " + stype.getAttribute("innerHTML"));
            if(stype.getText().contains(sname)){
                stype.click();
                break;
            }
        }
        Thread.sleep(2000);


        WebElement productInput = driver.findElement(By.id("s2id_autogen3"));
        String pname = "API GROW SACHET PDR 10 150 G";
        productInput.sendKeys(pname);
        //WebElement customerResult = driver.findElement(By.xpath( "/html[1]/body[1]/div[8]/ul[1]/li[1]/div[1]"));
        //customerResult.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> productTypes = driver.findElements(By.xpath( "//ul[@id='select2-results-3']/li"));
        System.out.println(productTypes.size());
        for(WebElement ptype:productTypes){
            System.out.println("Values " + ptype.getAttribute("innerHTML"));
            if(ptype.getText().contains(pname)){
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
        WebElement orderSummery = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/button[1]"));
        WebElement orderSend = driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/button[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", orderSummery);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", orderSend);
    }
}