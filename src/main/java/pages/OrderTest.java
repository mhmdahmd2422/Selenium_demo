package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static pages.webElements.*;

public class OrderTest extends BasePage {
    public OrderTest(WebDriver driver){
        super(driver);
    }
    public void setCustomer(String strCustomer){
        writeText(customerSearch, strCustomer);
    }
    public void chooseListedItem(String cname, By listed){
        waitVisibility(listed);
        List<WebElement> itemTypes = driver.findElements(listed);
//        System.out.println(customerTypes.size());
        for(WebElement itype:itemTypes){
            //System.out.println("Values " + itype.getAttribute("innerHTML"));
            if(itype.getText().contains(cname)){
                itype.click();
                break;
            }
        }
    }
    public void selectCustomer(){
        waitVisibility(customerResultList);
        chooseListedItem("ahmed", customerResultList);
        //waitInvisibility(customerResultList);
    }
    public void setSeller(String strSeller){
        writeText(sellerSearch, strSeller);
    }
}
