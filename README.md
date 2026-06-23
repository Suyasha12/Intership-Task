# README - Signup Automation Script

## Website URL
https://authorized-partner.vercel.app/

## Project Overview
This project automates the complete signup flow of the following website: https://authorized-partner.vercel.app/

## Required Dependencies
The project uses the following Maven dependencies:
- Selenium WebDriver - Used for browser automation and web element interactions.
- TestNG - Used for test execution, assertions, annotations, and DataProvider functionality.
- Mailosaur Java - Used for email testing and verification of sign up confirmation emails.
- dotenv-java - is used to read variables from a .env file (eg: API keys, secrets, environment configs)
- ExtentReports - Used for generating detailed HTML test execution reports with pass/fail status, logs, and screenshots.
- Apache Commons IO - Used for file handling operations such as copying screenshots, reading/writing files, and managing directories during test execution.

## Tech Stack
- Language: Java
- Automation Tool: Selenium WebDriver
- Test Framework: TestNG
- Build Tool: Maven
- Browser: Google Chrome
- Design Pattern: Page Object Model (POM)

## Prerequisites
i. Required Software
Before executing the automation script, ensure the following are installed:
- Java JDK 11 or higher
- Maven 3.8 or higher
- Google Chrome Browser
- ChromeDriver (compatible with installed Chrome version)
- IntelliJ IDEA or Eclipse IDE and required Dependencies.

ii. Mailosaur Account for OTP Verification
How Mailosaur works:
- Mailosaur provides a temporary testing email server (for example: abc123@mailosaur.net).
- During signup, the application sends the OTP code to that email address.
- The automation script connects to Mailosaur using its API and retrieves the latest email received.
- The OTP code is extracted from the email body using regex/string processing.
- The extracted OTP is automatically entered into the verification form.

iii. Dummy File for Upload

iv. Input data
How to Run the Automation Script
Step 1 - Open the Project in IntelliJ
Step 2 - Install dependencies mentioned above in Required Dependencies
Step 3 - Run `RunTest.xml` this file to execute the Automation.
Step 4 - Run `RunInvalid_Test.xml` this file to execute the Invalid Input Verification Automation.

## Test Data
The automation script uses predefined demo data stored inside the Utilities class for reusable test execution.
i. Static Test Data
Basic user information such as:
- First Name
- Last Name
- Password
- Other required form inputs are stored as static variables inside the utility file so they can be reused across multiple test runs.

ii. Dynamic Email Generation
- To avoid duplicate email registration errors during repeated executions, a unique email address is generated automatically using Java’s System.currentTimeMillis().
Example:

```java
public static String email = "tester" + System.currentTimeMillis() + "@gmail.com";
```
How it works:
1. System.currentTimeMillis() returns the current time in milliseconds.
2. Since the value changes every millisecond, each test run generates a unique email.

iii. Random Phone Number Generation
- Phone numbers are generated dynamically using valid Nepali mobile prefixes.
Code:
```java
public static String PhoneNum = new String[]{"984", "985", "986", "980", "981", "982"}[(int)(Math.random() * 6)] + String.format("%07d", (int)(Math.random() * 10000000));
```
How it works:
1. A random Nepali mobile prefix is selected.
2. Math.random() selects one prefix randomly.
3. String.format("%07d", ...) generates a random 7-digit number and ensures leading zeros are preserved if needed.
4. The prefix and 7-digit number are concatenated to create a full 10-digit Nepali mobile number.
- This approach ensures every execution uses unique and realistic phone numbers, preventing duplicate registration issues.

Test Result

After a test run, ExtendReports generates an HTML report. A report will auto generate in reports folder after test execution and a screenshot image will generate in Screenshots folder when test execution fails. Open the file in any browser to view a detailed breakdown of failed tests with screenshots.
