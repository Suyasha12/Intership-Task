package SignUp_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;


public class ProfessionalExperience_PageModel {
    WebDriver driver;
    public ProfessionalExperience_PageModel(WebDriver driver){
        this.driver=driver;
    }
    private By ExperienceDropdown= By.xpath("//option[normalize-space()='4 years']");
    private By StudentsRecruted=By.xpath("//input[@placeholder=\"Enter an approximate number.\"]");
    private By FocusArea= By.xpath("//input[@placeholder='E.g., Undergraduate admissions to Canada.']");
    private By SuccessMatrix=By.xpath("//input[@placeholder=\"E.g., 90% \"]");
    private By CareerCounseling= By.xpath("(//button[@role=\"checkbox\"])[1]");
    private By AdmissionApplication= By.xpath("(//button[@role=\"checkbox\"])[2]");
    private By VisaProcessing= By.xpath("(//button[@role=\"checkbox\"])[3]");
    private By TestPreparation= By.xpath("(//button[@role=\"checkbox\"])[4]");

    public void ClickExperienceDropdown()throws InterruptedException{
        sleep(2000);
        driver.findElement(ExperienceDropdown).click();
    }

    public void EnterStudentsRecruted(String StudentsNumber) {
        driver.findElement(StudentsRecruted).sendKeys(StudentsNumber);
    }
    public void EnterFocusArea(String area) {
        driver.findElement(FocusArea).sendKeys(area);
    }
    public void EnterSuccessMatrix(String SuccessPercent) {
        driver.findElement(SuccessMatrix).sendKeys(SuccessPercent);
    }
    public void ClickCareerCounseling() {
        driver.findElement(CareerCounseling).click();
    }
    public void ClickAdmissionApplication() {
        driver.findElement(AdmissionApplication).click();
    }
    public void ClickVisaProcessing() {
        driver.findElement(VisaProcessing).click();
    }
    public void ClickTestPreparation() {
        driver.findElement(TestPreparation).click();
    }


}
