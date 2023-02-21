package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.webElements.*;

public class OrderTest extends BasePage {
    WebDriver driver;
    public OrderTest(WebDriver driver){
        super(driver);
    }
    public void setCustomer(String strCustomer){
        writeText(customerSearch, strCustomer);
    }
//    public void selectCustomer(){
//    }
//    public void setSeller(String strSeller){
//    }
}
