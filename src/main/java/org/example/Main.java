package org.example;

import org.openqa.selenium.By;
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
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cp.dev.isupply.tech/login");

        driver.manage().window().maximize();

        driver.findElement(By.id("identifier"))
                .sendKeys("siteadmin@Isupply.tech");
        driver.findElement(By.name("password"))
                .sendKeys("Qwe@1234");
        driver.findElement(By.id("kt_sign_in_submit"))
                .click();
        WebElement ok = driver.findElement(By.xpath("//div[contains(@class,'swal2-popup swal2-modal swal2-icon-success swal2-show')]//div[contains(@class,'swal2-actions')]//button[contains(@class,'swal2-confirm btn btn-primary')]"));
        ok.click();
//        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.swal2-confirm.btn.btn-primary")));
//        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(2))
//                .until(ExpectedConditions.elementToBeClickable(By.id("swal2-confirm btn btn-primary")));
        driver.findElement(By.id("swal2-confirm btn btn-primary")).click();
//        driver.get("https://cp.dev.isupply.tech");
//        driver.quit();
    }
}