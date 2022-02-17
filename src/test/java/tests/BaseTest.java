package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setUpLocalBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    public void setUpDockerBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        String url = "http://localhost:4444/wd/hub";
        try {
            driver = new RemoteWebDriver(URI.create(url).toURL(), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setUpSystemProperties() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("local.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void init() {
        setUpLocalBrowser();
//        setUpDockerBrowser();
        setUpSystemProperties();

    }

//    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        driver.quit();
    }
}
