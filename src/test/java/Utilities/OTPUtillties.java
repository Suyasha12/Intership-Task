package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTPUtillties {

    public static String extractOTP(String emailBody) {

        String regex = "\\b(\\d{6})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailBody);

        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new RuntimeException("OTP not found in email body!");
    }
}