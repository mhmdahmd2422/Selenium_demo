package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.SystemProperties;
//import utils.uiSelectors.UISelectors;
//import helpers.ui.WebActionsHelper;


import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cp.dev.isupply.tech/login");

        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("identifier"));
        email.sendKeys("siteadmin@Isupply.tech");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Qwe@1234");

        WebElement submit = driver.findElement(By.id("kt_sign_in_submit"));
        submit.click();
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.swal2-confirm.btn.btn-primary")));
        WebElement confirmLogin = driver.findElement(By.xpath("//div[contains(@class,'swal2-popup swal2-modal swal2-icon-success swal2-show')]//div[contains(@class,'swal2-actions')]//button[contains(@class,'swal2-confirm btn btn-primary')]"));
        confirmLogin.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("Dashboard"));
        driver.get("https://cp.dev.isupply.tech/orders/create");
        WebElement customerInput = driver.findElement(By.id("s2id_autogen1"));
        customerInput.sendKeys("pharmacy name 5");
        //WebElement customerResult = driver.findElement(By.id("s2id_autogen1_search"));
        new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(1));
        WebElement customerResult = driver.findElement(By.xpath( "/html[1]/body[1]/div[8]/ul[1]/li[1]/div[1]"));
        //WebElement customerResult = driver.findElement(By.cssSelector("input#s2id_autogen_search.select2-input"));
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(customerResult));
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("select2-results-1")));
        new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(1));
        Thread.sleep(500);

        //customerResult.sendKeys(Keys.ENTER);
        customerResult.click();
        customerInput.sendKeys(Keys.ENTER);
     
        driver.quit();


    }
}