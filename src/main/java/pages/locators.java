package pages;

import org.openqa.selenium.By;

public class locators {
    static By emailInput = By.xpath("//input[@id='identifier']");
    static By passwordInput = By.xpath("//input[@name='password']");
    static By submitButton = By.xpath("//button[@id='kt_sign_in_submit']");
    static By confirmSubmit = By.xpath("//button[contains(text(),'Ok, got it!')]");
    static By customerSearch = By.xpath("//input[@id='s2id_autogen1']");
    static By customerResultList = By.xpath( "//ul[@id='select2-results-1']/li");
    static By customerDatatable = By.xpath("//table[@id='customer-data']//td");
    static By sellerSearch = By.xpath("//input[@id='s2id_autogen2']");
    static By sellerResultList = By.xpath( "//body/div[@id='select2-drop']/ul[1]/li");
    static By sellerChoices = By.xpath( "//li[@class='select2-search-choice']");
    static By productSearch = By.xpath("//input[@id='s2id_autogen3']");
    static By productResultList = By.xpath( "//body/div[@id='select2-drop']/ul[1]/li");
    static By productAdd = By.xpath("//button[@id='submit_add_product']");
    static By productSellers = By.xpath("//select[@name='sellers']");
    static By productSellerslist = By.xpath("//select[@id='sellers-list-2']");
    static By orderSummery = By.xpath("//button[contains(text(),'Order Summary')]");
    static By orderSave = By.xpath("//button[contains(text(),'Save')]");
    static By orderSummeryTable = By.xpath("//table[@id='order-summary']//td");
    static By orderViewTable = By.xpath("//table[@id='DataTables_Table_0']//a");
}
