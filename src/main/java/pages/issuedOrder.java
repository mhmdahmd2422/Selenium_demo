package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static base.BaseTest.driver;

public class issuedOrder extends BasePage{
    public issuedOrder(WebDriver driver) {
        super(driver);
    }
    List<String> dataExpected = Arrays.asList("API GROW SACHET PDR 10 150 G", "76876", "Sellerman2", "1", "67.00", "0%", "67", "67");
    List<String> dataActual = new ArrayList<>();
    List<WebElement> orderViewDetail = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[1]/td"));
    public void validateOrderIssued() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("Orders Management"));
        webElements.orderView.click();
        Iterator<WebElement> itr = orderViewDetail.iterator();
        while(itr.hasNext()) {
            dataActual.add(itr.next().getText());
        }
        Assert.assertEquals(dataExpected, dataActual);
    }
}
