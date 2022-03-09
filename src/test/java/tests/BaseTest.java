package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;
    protected String username;
    protected String password;

    public void setUpLocalBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
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
        setUpSystemProperties();
        url = System.getProperty("adminUrl");
        username = System.getProperty("username");
        password = System.getProperty("password");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        driver.quit();
    }
}
