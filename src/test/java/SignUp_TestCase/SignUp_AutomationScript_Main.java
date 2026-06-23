package SignUp_TestCase;

import BaseClass.Baseclass;
import SignUp_POM.*;

import Utilities.OTPUtillties;
import Utilities.UserData;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class SignUp_AutomationScript_Main extends Baseclass {


    @Test(priority = 1)
    public void Homepage() {
        Dashboard_PageModel dashboard = new Dashboard_PageModel(driver);
        dashboard.CheckAssertion("Empowering Agents to Bridge Students with Global Education");
        dashboard.ClickonJoinUsNow();
    }

//Account Setup Page 1.
    @Test(priority = 2, dependsOnMethods = "Homepage")
    public void SetupAccount () throws InterruptedException {
        SetupAccount_PageModel step1 = new SetupAccount_PageModel(driver);
        sleep(1000);

        step1.ClickCheckBox();
        step1.ClickContinueButton();
        step1.CheckUserDetailFormAssertion("Complete Your Agent Profile in Steps");
        step1.FillFirstName(UserData.firstname);
        step1.FilllastName(UserData.lastname);
        step1.EnterEmailandPassword(UserData.Newemail, UserData.password);
        System.out.println(UserData.Newemail);
        step1.ClickCountryDropdown();
        step1.SelectCountry("Nepal");
        step1.SelectOption();
        step1.FillPhoneNum(UserData.PhoneNum);
        System.out.println(UserData.PhoneNum);
        sleep(2000);
        step1.FillConfirmPassword(UserData.confirmpassword);
        step1.ClickNextButton();

    }

//OTP Verification
    @Test(priority = 3, dependsOnMethods = "SetupAccount")
    public void OTP_Verification() throws Exception {

        Dotenv dotenv = Dotenv.load();

        String APIkey = dotenv.get("MAILOSAUR_API_KEY");
        String serverId = dotenv.get("MAILOSAUR_SERVER_ID");
        String serverDomain = dotenv.get("MAILOSAUR_SERVER_DOMAIN");

        MailosaurClient client = new MailosaurClient(APIkey);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(UserData.Newemail);
        System.out.println(UserData.Newemail);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        Message message = client.messages().get(params, criteria);
        System.out.println("Email caught successfully! Subject line: " + message.subject());
        assertNotNull(message);
        String emailBody = message.html().body();
        System.out.println("EMAIL BODY: " + emailBody);
        String emailBodyText = message.text().body();
        System.out.println("EMAIL BODY: " + emailBodyText);
        String otpCode = OTPUtillties.extractOTP(emailBodyText);
        System.out.println("Extracted Verification Code: " + otpCode);
        OTP_PageModel otpPage = new OTP_PageModel(driver);

        otpPage.EnterOTP(otpCode);
        otpPage.ClickVerifyCode();
    //Verify Popup Status
        otpPage.verifySuccessPopup("Your account has been created successfully");

    }

    //Agency Detail Page 2.
        @Test(priority = 4,dependsOnMethods = "OTP_Verification")
        public void AgencyDetail_PageModel () throws InterruptedException {

        AgencyDetail_PageModel step2 = new AgencyDetail_PageModel(driver);

        sleep(1000);
        step2.EnterAgencyName(UserData.agencyname);
        step2.EnterRoleinAgency(UserData.role);
        step2.EnterAgencyEmail(UserData.agencyemail);
        step2.EnterAgencyWebsite(UserData.agencywebsite);
        step2.EnterAgencyAddresse(UserData.agencyaddress);
        step2.SelectAgencyRegion("America");

        sleep(1000);
        step2.SelectDropdownOption();
        step2.ClickonNextPageButton();
        //step2.ClickonBackButton();

}

//ProfessionalExperience Page 3.

    @Test(priority = 4,dependsOnMethods = "AgencyDetail_PageModel")
    public void ProfessionalExperience() throws InterruptedException {

        ProfessionalExperience_PageModel step3 = new ProfessionalExperience_PageModel(driver);
        sleep(1000);

        step3.ClickExperienceDropdown();
        step3.EnterStudentsRecruted("500");
        step3.EnterFocusArea("Undergraduate admissions to Canada.");
        step3.EnterSuccessMatrix("90");
        step3.ClickCareerCounseling();
        step3.ClickAdmissionApplication();
        step3.ClickVisaProcessing();
        step3.ClickTestPreparation();

        AgencyDetail_PageModel step2 = new AgencyDetail_PageModel(driver);
        //step2.ClickonBackButton();
        step2.ClickonNextPageButton();
    }

//Verification and Preferences Page 4.
    @Test(priority = 5, dependsOnMethods ="ProfessionalExperience" )
    public void Verification() throws InterruptedException{
        Verification_PageModel step4 = new Verification_PageModel(driver);
        step4.EnterBusinessRegistrationNum(UserData.DummyRegistrationNum);
        step4.SelectPreferredCountries("Nepal");
        step4.SelectPreferredCountries_Dropdown();
        step4.ClickUniversities();
        //step4.ClickColleges();
        //step4.ClickVocationalSchool();
        //step4.ClickOther();
        step4.EnterCertificationDetails(UserData.DummyCertification);
        step4.uploadingFile1();
        step4.uploadingFile2();
        //step4.AddDocuments();
        step4.ClickSubmitButton();
        sleep(10000);

    // Verify User Dashboard URL to confirm SignUp Success.
        String expectedUrl = "https://authorized-partner.vercel.app/admin/profile";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println(expectedUrl);
        System.out.println(actualUrl);
    }

}
