package SignUp_TestCase;

import BaseClass.Baseclass;
import SignUp_POM.Dashboard_PageModel;
import SignUp_POM.SetupAccount_PageModel;
import Utilities.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Invalid_Input_Verification extends Baseclass {
        @DataProvider(name = "InputData")
        public Object[][] getLoginData() {
            return new Object[][]{
                    {"validuser@gmal.com", "P@ssword123", "valid"},
                    {"invaliduser@gmail","P@ssswor1","invalid"},

                    {"", "","empty"}
            };
        }

    SetupAccount_PageModel inputdata;
        @BeforeMethod
        public void setUp() {
            driver.get("https://authorized-partner.vercel.app/");
            inputdata = new SetupAccount_PageModel(driver);
            Dashboard_PageModel dashboard = new Dashboard_PageModel(driver);
            dashboard.ClickonJoinUsNow();
        }

        @Test(dataProvider = "InputData")
        public void AccountSetup(String email, String password,String expectedResult) throws InterruptedException {
            inputdata.ClickCheckBox();
            inputdata.ClickContinueButton();
            sleep(5000);

            inputdata.FillFirstName(UserData.firstname);
            inputdata.FilllastName(UserData.lastname);
            inputdata.ClickCountryDropdown();
            inputdata.SelectCountry("Nepal");
            inputdata.SelectOption();
            inputdata.FillPhoneNum(UserData.PhoneNum);
            sleep(5000);
            inputdata.EnterEmailandPassword(email,password);
            inputdata.FillConfirmPassword("P@ssword123");
            inputdata.ClickNextButton();

            sleep(5000);
            if(expectedResult.equalsIgnoreCase("valid")){
                System.out.println("Email is Valid");
            }
            else if(expectedResult.equalsIgnoreCase("invalid")){
                inputdata.checkInvalidEmailMsg("Invalid email address");
                inputdata.checkPasswordUnmatch("Passwords do not match");
            }
            else if (expectedResult.equalsIgnoreCase("empty")){
                inputdata.checkEmptyPassword("Password must be at least 8 characters");

            }
    }
}
