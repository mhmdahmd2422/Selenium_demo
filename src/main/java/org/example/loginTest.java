package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginTest extends BasePage {
    WebDriver driver;
    By emailInput = By.xpath("//input[@id='identifier']");
    By passwordInput = By.xpath("//input[@name='password']");
    By submitButton = By.xpath("//button[@id='kt_sign_in_submit']");
    By confirmSubmit = By.xpath("//button[contains(text(),'Ok, got it!')]");
    public loginTest(WebDriver driver){
        super(driver);
    }
    public void setLoginEmail(String strEmail){
        writeText(emailInput, strEmail);
    }
    public void setLoginPassword(String strPassword){
        writeText(passwordInput, strPassword);
    }
    public void clickLogin(){
        click(submitButton);
    }
    public void clickLoginConfirm(){
        click(confirmSubmit);
    }
    public void dashLogin(String strEmail, String strPassword){
        this.setLoginEmail(strEmail);
        this.setLoginPassword(strPassword);
        this.clickLogin();
        this.clickLoginConfirm();
    }
}
