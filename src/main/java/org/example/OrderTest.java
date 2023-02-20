package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderTest extends BasePage {
    By customerSearch = By.xpath("//input[@id='s2id_autogen1']");
    By customerResult = By.xpath("//ul[@id='select2-results-1']");
    By customerResultList = By.xpath( "//ul[@id='select2-results-1']/li");

    public OrderTest(WebDriver driver){
        super(driver);
    }

    public void setCustomer(String strCustomer){
        writeText(customerSearch, strCustomer);
    }

    public void selectCustomer(){

    }

    public void setSeller(String strSeller){

    }
}
