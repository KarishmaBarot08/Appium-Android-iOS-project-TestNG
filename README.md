**MPROOV Project**

This POC based on JAVA Appium demonstrates common script for Android and iOS mobile app.

**Concepts Included**
- Page Object Model
- Maven Framework
- Common web page interaction methods
- Commonly used test utility classes
- Listner for reporting

**Tools**
- Maven
- TestNG
- Selenium Webdriver

**Requirements**
- Maven v3.0 or above
- Selenium v4.8 or above
- TestNG v7.7 or above
- Appium v3.8 or above
- Refer pom.xml file for detailed library requirements
- Appium Server GUI desktop application


**How to execute this script?**
1. Launch 'Appium Server GUI' app > Start Appium server session
2. In intelliJ,Go to testng.xml file and define platform on which you want to run the test
3. Open baseClass.java > Add your device's details into Desired capabilities section
4. Run testng.xml file (Right click > Select 'Run')

**Reporting**
 - Once you execute script, you will find 'test-output' folder created
 - Go to 'test-output' folder > Right click on 'index.html' file > Open In > Browser > Chrome
 - The HTML report will show total no. of test cases run, no. of test cases passed, no. of test cases failed, no. of test cases skipped, execution time etc details

