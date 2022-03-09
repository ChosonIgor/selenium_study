package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class BrowserStackTests {

    public static final String USERNAME = "igorkim_PUzwj3";
    public static final String AUTOMATE_KEY = "xmXsegn66KpyzbpDHKSc";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void testingBrowserStack() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "97.0");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 1");
        executeTest(capsHashtable);
    }

    public void executeTest(Hashtable<String, String> capsHashtable) {
        String key;
        DesiredCapabilities caps = new DesiredCapabilities();
        // Iterate over the hashtable and set the capabilities
        Set<String> keys = capsHashtable.keySet();
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            key = itr.next();
            caps.setCapability(key, capsHashtable.get(key));
        }
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            // Searching for 'BrowserStack' on google.com
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("BrowserStack");
            element.submit();
            // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
            WebDriverWait wait = new WebDriverWait(driver, 5);
            try {
                wait.until(ExpectedConditions.titleContains("BrowserStack"));
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
            }
            catch(Exception e) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
            }
            System.out.println(driver.getTitle());
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void browserStackTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "chrome");
        caps.setCapability("browser_version", "97.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "Thread 1");
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(" https://igorkim_PUzwj3:xmXsegn66KpyzbpDHKSc@hub-cloud.browserstack.com/wd/hub"), caps);
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }





}
