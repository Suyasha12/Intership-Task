package SignUp_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgencyDetail_PageModel {
    WebDriver driver;
    WebDriverWait wait;
    public AgencyDetail_PageModel(WebDriver driver){
        this.driver= driver;
    }
    private By AgencyName= By.xpath("//input[@placeholder='Enter Agency Name']");
    private By RoleinAgency= By.xpath("//input[@placeholder='Enter Your Role in Agency']");
    private By AgencyEmail=By.xpath("//input[@placeholder='Enter Your Agency Email Address']");
    private By AgencyWebsite=By.xpath("//input[@placeholder='Enter Your Agency Website']");
    private By AgencyAddress=By.xpath("//input[@placeholder='Enter Your Agency Address']");
//Dropdown
    private By ChooseAgencyRegion=By.xpath("//button[@role='combobox']");
    private By SearchRegion = By.xpath("//input[@placeholder='Search...' ]");
    private By ChooseDropdownOptions=By.xpath("(//div[@class='flex cursor-pointer items-center justify-between p-2 space-y-1 hover:bg-accent'])[1]");

    private By NextPageButton=By.xpath("//button[normalize-space()='Next']");
    private By BackButton=By.xpath("(//button[normalize-space()='Back'])[1]");


    public void EnterAgencyName(String agencyname){
        driver.findElement(AgencyName).sendKeys(agencyname);
    }
    public void EnterRoleinAgency(String role){
        driver.findElement(RoleinAgency).sendKeys(role);
    }
    public void EnterAgencyEmail(String agencyemail){
        driver.findElement(AgencyEmail).sendKeys(agencyemail);
    }
    public void EnterAgencyWebsite(String agencywebsite){
        driver.findElement(AgencyWebsite).sendKeys(agencywebsite);
    }
    public void EnterAgencyAddresse(String agencyaddress){
        driver.findElement(AgencyAddress).sendKeys(agencyaddress);
    }

// Dropdown
    public void SelectAgencyRegion(String region) {

        driver.findElement(ChooseAgencyRegion).click();
        driver.findElement(SearchRegion).sendKeys(region);
    }

    public void SelectDropdownOption(){

        driver.findElement(ChooseDropdownOptions).click();

    }

    public void ClickonNextPageButton (){
        driver.findElement(NextPageButton).click();
    }
    public void ClickonBackButton (){
        driver.findElement(BackButton).click();
    }

}
