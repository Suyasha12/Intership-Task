package SignUp_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Dashboard_PageModel {
    WebDriver driver;

    public Dashboard_PageModel(WebDriver driver) {
        this.driver = driver;
    }

    private By AssertionText = By.xpath("//h1[@class=\"text-[28px]/[81px] sm:text-[60px] font-satoshi-bold tracking-[-1.2px]\"]");

    private By JoinUsNow= By.xpath("//button[text()='Join Us Now']");

    public void CheckAssertion(String expected) {
        String actual = driver.findElement(AssertionText).getText();
        Assert.assertEquals(actual, expected);
    }


    public void ClickonJoinUsNow() {
        driver.findElement(JoinUsNow).click();
    }
}

