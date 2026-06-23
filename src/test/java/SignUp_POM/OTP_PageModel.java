package SignUp_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OTP_PageModel {

    WebDriver driver;
    WebDriverWait wait;
    public OTP_PageModel(WebDriver driver){
        this.driver= driver;
    }
    private By OTPPageAssertion = By.xpath("//h2[@class=\"text-lg lg:text-2xl font-bold tracking-[-0.56px] leading-[135%] pb-2\"](\"Email Verification code\")");
    private By OTPInput = By.xpath("//input[@autocomplete=\"one-time-code\"]");
    private By VerifyCodeButton= By.xpath("//button[@type=\"submit\"]");
    private By ResendCode=By.xpath("//span[@class=\"text-primary cursor-pointer\"]");
    private By SuccessMessage_PopUp= By.xpath("//li[@role=\"status\"]");

    public void CheckOTPPageAssertion(String expected){
        String actual = driver.findElement(OTPPageAssertion).getText();
        Assert.assertEquals(actual,expected);
    }
    public void EnterOTP(String OTPcode){
        driver.findElement(OTPInput).sendKeys(OTPcode);
    }
    public void ClickVerifyCode (){
        driver.findElement(VerifyCodeButton).click();
    }
    public void ClickResendCode(){
        driver.findElement(ResendCode).click();
    }
    public void verifySuccessPopup(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SuccessMessage_PopUp)
        );

        String actualText = toast.getText().trim();

        Assert.assertTrue(actualText.contains(expectedMessage));
    }

}
