package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Baseclass {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void OpenWebpage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.get("https://authorized-partner.vercel.app/");

    }

    //@AfterClass(alwaysRun = true)
    public void CloseEveryBrowser(){
        if(driver !=null){
            driver.quit();
        }
    }
}
