package SignUp_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Verification_PageModel {
    WebDriver driver;
    public Verification_PageModel(WebDriver driver){
        this.driver= driver;
    }
    private By BusinessRegistrationNum= By.xpath("//input[@placeholder=\"Enter your registration number\"]");
//Dropdown
    private By PreferredCountries= By.xpath("//span[@class=\"font-satoshi-regular text-translucent\"]");
    private By PreferredCountries_Search= By.xpath("//input[@placeholder=\"Search...\"]");
    private By PreferredCountries_Dropdown= By.xpath("(//div[@class=\"flex cursor-pointer items-center justify-between p-2 space-y-1 hover:bg-accent\"])[1]");

    private By Universities =By.xpath("(//button[@role=\"checkbox\"])[1]");
    private By Colleges = By.xpath("(//button[@role=\"checkbox\"])[2]");
    private By VocationalSchool= By.xpath("(//button[@role=\"checkbox\"])[3]");
    private By Other= By.xpath("(//button[@role=\"checkbox\"])[4]");
    private By CertificationDetails = By.xpath("//input[@placeholder=\"E.g., ICEF Certified Education Agent\"]");
    private By UploadFile1= By.xpath("(//input[@type=\"file\"])[1]");
    private By UploadFile2= By.xpath("(//input[@type=\"file\"])[2]");
    private By AddDocuments=By.xpath("//div[@class=\"flex flex-col text-[16px] items-center justify-center space-x-2 text-translucent w-full h-full\"]");
    private By SubminButton= By.xpath("//button[@type=\"submit\"]");

    public void EnterBusinessRegistrationNum(String RegistrationNum){
        driver.findElement(BusinessRegistrationNum).sendKeys(RegistrationNum);
    }

// Dropdown

    public void SelectPreferredCountries(String country) {

        driver.findElement(PreferredCountries).click();
        driver.findElement(PreferredCountries_Search).sendKeys(country);
    }
    public void SelectPreferredCountries_Dropdown(){

        driver.findElement(PreferredCountries_Dropdown).click();

    }

    public void ClickUniversities(){
        driver.findElement(Universities).click();
    }
    public void ClickColleges(){
        driver.findElement(Colleges).click();
    }
    public void ClickVocationalSchool(){
        driver.findElement(VocationalSchool).click();
    }
    public void ClickOther(){
        driver.findElement(Other).click();
    }
    public void EnterCertificationDetails(String certificatedetails){
        driver.findElement(CertificationDetails).sendKeys(certificatedetails);
    }
    // Upload file
    public void uploadingFile1() {
        File uploadFile = new File("src/test/Files/Dummy.pdf");
        driver.findElement(UploadFile1).sendKeys(uploadFile.getAbsolutePath());
    }
    public void uploadingFile2() {
        File uploadFile = new File("src/test/Files/Dummy.pdf");
        driver.findElement(UploadFile2).sendKeys(uploadFile.getAbsolutePath());
    }
    public void AddDocuments() {
        File uploadFile = new File("src/test/Files/Dummy.pdf");
        driver.findElement(AddDocuments).sendKeys(uploadFile.getAbsolutePath());
    }
    public void ClickSubmitButton(){
        driver.findElement(SubminButton).click();
    }



}
