package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
public class BaseTest {
    public static WebDriver driver;
    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }
    public static WebDriver StartBrowser(String browsername , String url)
    {
        // If the browser is Firefox
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            driver = new FirefoxDriver();
        }

        // If the browser is Chrome
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();
        }
        // If the browser is IE
        else if(browsername.equalsIgnoreCase("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

//    @BeforeClass
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        //To maximize browser
//        driver.manage().window().maximize();
//        //Implicit wait
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }
//    @AfterClass
//    public void teardown () {
//        driver.quit();
//    }
}
