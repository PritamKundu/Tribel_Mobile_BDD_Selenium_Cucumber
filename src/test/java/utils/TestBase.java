package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.NonUser.nonUser_Page;


public class TestBase {

    public WebDriver driver;
    nonUser_Page newUserPage;

    public WebDriver WebDriverManager() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("Url");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
                driver = new ChromeDriver(options);

            }
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--disable-notifications");
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
                driver = new FirefoxDriver(options);

            }
            assert driver != null;
            driver.manage().window().setPosition(new Point(2600,0));
            //driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(200,800));
            //driver.get(url);
            //Thread.sleep(4000);
            //driver.findElement(By.xpath("//a[normalize-space()=\"Accept\"]")).click();
        }
        return driver;
    }
}

