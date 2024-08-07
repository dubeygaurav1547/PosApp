package com.shield3.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.security.SecureRandom;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.time.Duration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReuseableFunction {

    private static WebDriver driver;
    public WebElement waitElement;
    public WebDriverWait wait;


    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver launchBrowser(String browserType, String url) {

        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                driver.get(url);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                driver.get(url);
                break;

            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }

    public synchronized Boolean clickObject(WebElement objWebElement, String strObjectName) throws Exception {
        try {
            waitForElement(WaitCondition.toBeClickable,objWebElement);
            objWebElement.click();
            System.out.println(strObjectName + " " + "Clicked");
            return true;
        } catch (Exception objException) {
            System.err.println(strObjectName + " " + "Not Clicked");
            objException.printStackTrace();
            return false;
        }
    }

    public synchronized Boolean typeValue(WebElement objWebElement, String strObjectName, String strInputValue) throws Exception {
        try {
            waitForElement(WaitCondition.toBeVisible,objWebElement);
            objWebElement.clear();
            objWebElement.sendKeys(strInputValue);
            System.out.println(strInputValue + " " + "Typed in " + " " + strObjectName);
            return true;
        } catch (Exception objException) {
            System.err.println(strInputValue + " " + "Not typed ");
            objException.printStackTrace();
            return false;
        }
    }


    public enum WaitCondition {
        toBeVisible, toBeClickable, toBeInvisible, tobePresent
    }


    public synchronized void waitForElement(WaitCondition condition, WebElement element) throws Exception {

        By locater = getElementLocator(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        switch (condition) {
            case tobePresent:
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                break;
            case toBeVisible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                break;
            case toBeInvisible:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locater));
                break;
            case toBeClickable:
                wait.until(ExpectedConditions.elementToBeClickable(locater));
                break;
            default:
                break;
        }

    }


    public static By getElementLocator(WebElement element) {
        return By.xpath(element.toString().split("xpath: ")[1].substring(0,element.toString().split("xpath: ")[1].length()-1));
    }

    public static String readEmailOTP() {
        String host = "imap.gmail.com";
//        String username = "testingwits02@gmail.com";
        String username = "shield3demo@gmail.com";
//        String password = "hpoz eqxj wsnm xwaa";
        String password = "dvbl cici nrhr xksa";

        // Set properties and their values
        Properties properties = new Properties();
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.imap.ssl.trust", host);
        properties.put("mail.imap.ssl.enable", "true");

        // Get the session object
        Session emailSession = Session.getInstance(properties);

        try {
            // Create the IMAP store object and connect with the server
            Store store = emailSession.getStore("imap");
            store.connect(host, username, password);

            // Create the folder object and open it in your mailbox
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // Fetch messages from the folder
            Message[] messages = emailFolder.getMessages();

            for (int i=messages.length-1; i>messages.length-10; i--) {
                //System.out.println("Verification Code: "+messages[i].getSubject());//5558
                if (messages[i].getSubject().contains("Your code for Shield3")) {

                    String code = "";
                    Pattern pattern = Pattern.compile("Your code for Shield3 is here: ([A-Z0-9-]+)");
                    Matcher matcher = pattern.matcher(messages[i].getSubject());
                    if (matcher.find()) {
                        code = matcher.group(1);
                    }
                    return code.replace("-","");
                }
            }

            // Close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public synchronized String getText(WebElement objWebElement, String strObjectName) throws Exception {
        try {
            waitForElement(WaitCondition.toBeVisible,objWebElement);
            String text = objWebElement.getText();
            System.out.println(text + " " + "Extracted from " + " " + strObjectName);
            return text;
        } catch (Exception objException) {
            System.err.println("Couldn't Extract Text ");

        }
        return null;
    }

    public synchronized String getattribute(WebElement objWebElement, String strObjectName, String attributeName) throws Exception {
        try {
            waitForElement(WaitCondition.toBeVisible,objWebElement);
            String text = objWebElement.getAttribute(attributeName);
            System.out.println(text + " " + "Extracted from " + " " + strObjectName);
            return text;
        } catch (Exception objException) {
            System.err.println("Couldn't Extract Text ");

        }
        return null;
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}



