package SignUp_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SetupAccount_PageModel {
    WebDriver driver;
    public SetupAccount_PageModel(WebDriver driver){
        this.driver=driver;

    }
    private By CheckBox= By.xpath("//button[@id='remember']");
    private By Continuebutton = By.xpath("//button[contains(text(),'Continue')]");

    private By UserDetailFormAssertion= By.xpath("//h2[@class= \"text-[28px] h-[38px] text-center font-satoshi-bold leading-[1.2] hidden lg:block\"]");
    private By FirstName= By.xpath("//input[@placeholder=\"Enter Your First Name\"]");
    private By LastName= By.xpath("//input[@placeholder=\"Enter Your Last Name\"]");
    private By Email= By.xpath("//input[@placeholder=\"Enter Your Email Address\"]");
    private By CountryDropdown = By.xpath("//button[@role=\"combobox\"]");
    private By DropdownSearch= By.xpath("//input[@placeholder=\"Search...\"]");
    private By ClickOption=By.xpath("//div[@tabindex='-1' and @role='option']");
    private By PhoneNum=By.xpath("//input[@placeholder=\"00-00000000\"]");
    private By Password= By.xpath("//input[@name=\"password\"]");
    private By ConfirmPassword= By.xpath("//input[@name=\"confirmPassword\"]");
    private By NextButton=By.xpath("//button[@type=\"submit\"]");



    public void ClickCheckBox(){
        driver.findElement(CheckBox).click();
    }
    public void ClickContinueButton(){
        driver.findElement(Continuebutton).click();
    }
    public void CheckUserDetailFormAssertion(String ExpectedText){
        String ActualText= driver.findElement(UserDetailFormAssertion).getText();
        Assert.assertEquals(ActualText,ExpectedText);
    }
    public void FillFirstName(String firstname){
        driver.findElement(FirstName).sendKeys(firstname);
    }
    public void FilllastName(String lastname){
        driver.findElement(LastName).sendKeys(lastname);
    }
    public void FillEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void ClickCountryDropdown(){
        driver.findElement(CountryDropdown).click();
    }

    public void SelectCountry(String country) {
        driver.findElement(DropdownSearch).sendKeys(country);
    }
    public void SelectOption(){
        driver.findElement(ClickOption).click();
    }
    public void FillPhoneNum(String number){
        driver.findElement(PhoneNum).sendKeys(number);
    }
    public void FillPassword(String password){
        driver.findElement(Password).sendKeys(password);
    }
    public void FillConfirmPassword(String confirmpassword){
        driver.findElement(ConfirmPassword).sendKeys(confirmpassword);
    }
    public void ClickNextButton(){
        driver.findElement(NextButton).click();
    }


}
