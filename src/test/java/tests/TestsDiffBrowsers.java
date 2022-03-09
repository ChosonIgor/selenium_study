package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class TestsDiffBrowsers {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void checkLogin() {
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("tr input[name='username']")).sendKeys("Choson");
        driver.findElement(By.cssSelector("tr input[name='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("tr input[type='checkbox']")).click();
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        button.click();
        wait.until(ExpectedConditions.invisibilityOf(button));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notice errors']")));
    }

    @Test
    public void testIE() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        checkLogin();
        driver.quit();
    }

    @Test
    public void testChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        checkLogin();
        driver.quit();
    }

    @Test
    public void testFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        checkLogin();
        driver.quit();
    }

    @Test
    public void testFirefoxNightly() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
        driver = new FirefoxDriver(options);
        checkLogin();
        driver.quit();
    }

    @Test
    public void testDocker() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "96.0");
        capabilities.setCapability("enableVNC", true);
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
            driver.get("https://www.yandex.ru");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Найти']")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
