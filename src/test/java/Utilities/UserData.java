package Utilities;

public class UserData {
//Step1:

    public static String firstname = "Tester";
    public static String lastname= "User";
    public static String email= "tester" + System.currentTimeMillis() +"@bijx2hgu.mailosaur.net";
    public static String Newemail= email;
    public static String PhoneNum =
            new String[]{"984", "985", "986", "980", "981", "982"}[(int)(Math.random() * 6)]
                    + String.format("%07d", (int)(Math.random() * 10000000));
    public static String password= "Tester@11";
    public static String confirmpassword= password;

//Step2:
    public static String agencyname="Vrit Technologies";
    public static String role="Tester";
    public static String agencyemail="info@vrittechnologies.test";
    public static String agencywebsite="www.vrittechnologies.test";
    public static String agencyaddress="Kathmandu";

//Step4
    public static String DummyRegistrationNum="BRN-2024-001234";
    public static String DummyCertification="ICEF Certified";

}
