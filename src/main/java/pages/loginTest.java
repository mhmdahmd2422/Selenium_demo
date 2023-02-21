package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.webElements.*;
public class loginTest extends BasePage {
    WebDriver driver;
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
