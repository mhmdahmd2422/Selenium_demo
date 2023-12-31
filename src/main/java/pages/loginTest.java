package pages;
import org.openqa.selenium.WebDriver;
import static pages.locators.*;
public class loginTest extends BasePage {
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
