package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webElements {
    static By emailInput = By.xpath("//input[@id='identifier']");
    static By passwordInput = By.xpath("//input[@name='password']");
    static By submitButton = By.xpath("//button[@id='kt_sign_in_submit']");
    static By confirmSubmit = By.xpath("//button[contains(text(),'Ok, got it!')]");
    static By customerSearch = By.xpath("//input[@id='s2id_autogen1']");
    static By customerResult = By.xpath("//ul[@id='select2-results-1']");
    static By customerResultList = By.xpath( "//ul[@id='select2-results-1']/li");
}
