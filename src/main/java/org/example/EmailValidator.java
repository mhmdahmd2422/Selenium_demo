//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class EmailValidator {
//    public static void Email()
//    {
//        WebDriver driver = new ChromeDriver();
//        // Navigate to the url
//        driver.get("https://www.selenium.dev/selenium/web/inputs.html");
//
//// Get boolean value for is element display
//        boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
//        System.out.println(isEmailVisible);
//        driver.quit();
//
//        driver.findElement(By.id("user_email_login"));....
//        UISelectors selectors = new UISelectors();...
//        SystemProperties systemProperties =.. new SystemProperties();
//        System.out.println("Logging in by email "+email);
//        browserNavigation("/login");
//        //actionsOnElementByXpath(selectors.loginEmail, false, false, email);
//        // actionsOnElementByXpath(selectors.loginPassword, false,false, password);
//        actionsOnElementByXpath(selectors.loginClick, false, true);
//        getWebDriverWait().until(ExpectedConditions.textToBe(selectors.homeUsername,"Dashboard"));
//    }
//
//
//}
//}
