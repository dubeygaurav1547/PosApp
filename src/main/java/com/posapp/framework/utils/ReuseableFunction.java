package com.posapp.framework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.security.SecureRandom;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReuseableFunction {

    private static WebDriver driver;
    public WebElement waitElement;
    public int wait=20000;


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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    public synchronized Boolean clickObject(WebElement objWebElement, String strObjectName) throws Exception {
        try {
            waitForElement(WaitCondition.tobePresent, objWebElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", objWebElement);
            Thread.sleep(wait);
            try {
                objWebElement.click();
                System.out.println(strObjectName + " " + "Clicked");
                return true;
            } catch (ElementClickInterceptedException e) {
                // JavaScript click fallback for intercepted click
                System.err.println(strObjectName + " " + "Click intercepted, attempting JavaScript click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", objWebElement);
                System.out.println(strObjectName + " " + "Clicked using JavaScript");
                return true;
            } catch (ElementNotInteractableException e) {
                // JavaScript click fallback for non-interactable element
                System.err.println(strObjectName + " " + "Element not interactable, attempting JavaScript click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", objWebElement);
                System.out.println(strObjectName + " " + "Clicked using JavaScript");
                return true;
            }
        } catch (Exception objException) {
            System.err.println(strObjectName + " " + "Not Clicked");
            objException.printStackTrace();
            return false;
        }
    }

    public synchronized Boolean mouseOverObject(WebElement objWebElement, String strObjectName) throws Exception {
        try {
            // Wait for the element to be visible
            waitForElement(WaitCondition.toBeVisible, objWebElement);
            Thread.sleep(wait);
            // Scroll the element into view
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", objWebElement);
            if (!objWebElement.isDisplayed()) {
                throw new Exception(strObjectName + " is not visible to perform mouse over.");
            }
            // Perform mouse-over action
            Actions actions = new Actions(driver);
            actions.moveToElement(objWebElement).perform();

            System.out.println(strObjectName + " " + "Mouse over action performed");
            return true;
        } catch (Exception objException) {
            System.err.println(strObjectName + " " + "Mouse over action not performed");
            objException.printStackTrace();
            return false;
        }
    }


    public synchronized Boolean typeValue(WebElement objWebElement, String strObjectName, String strInputValue) throws Exception {
        try {
            waitForElement(WaitCondition.tobePresent, objWebElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", objWebElement);
//            objWebElement.click();
            objWebElement.clear();
            objWebElement.sendKeys(strInputValue);

            // Add a short delay
            Thread.sleep(500);

            // Trigger focus, input, and change events
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", objWebElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('input'));", objWebElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", objWebElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", objWebElement);

            System.out.println(strInputValue + " " + "Typed in " + " " + strObjectName);
            return true;
        } catch (ElementNotInteractableException e) {
            // Fallback to JavaScript if the element is not interactable
            System.err.println("Element not interactable, attempting to set value using JavaScript");
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", objWebElement);
                ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", objWebElement, strInputValue);

                // Trigger events
                ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('input'));", objWebElement);
                ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", objWebElement);

                System.out.println(strInputValue + " " + "Set in " + " " + strObjectName + " using JavaScript");
                return true;
            } catch (Exception jsException) {
                System.err.println(strInputValue + " " + "Not set using JavaScript");
                jsException.printStackTrace();
                return false;
            }
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
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case toBeInvisible:
                wait.until(ExpectedConditions.invisibilityOf(element));
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
//            Thread.sleep(wait);
            String text = objWebElement.getText();
            System.out.println(text + " " + "Extracted from " + " " + strObjectName);
            return text;
        } catch (Exception objException) {
            System.err.println("Couldn't Extract Text ");

        }
        return null;
    }

    public synchronized boolean isPresent(WebElement objWebElement, String strObjectName) throws Exception {
        try {
            waitForElement(WaitCondition.toBeVisible,objWebElement);
            boolean text = objWebElement.isDisplayed();
            System.out.println(strObjectName + " " + "is present");
            return text;
        } catch (Exception objException) {
            System.err.println("unable check availablity of "+strObjectName);

        }
        return false;
    }

    public synchronized boolean isSelected(WebElement objWebElement, String strObjectName) throws Exception {
        try {
            waitForElement(WaitCondition.toBeVisible,objWebElement);
            boolean text = objWebElement.isSelected();
            System.out.println(strObjectName + " " + "is selected");
            return text;
        } catch (Exception objException) {
            System.err.println("unable check "+strObjectName+" is selected");

        }
        return false;
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



