package org.rahulshettyacademy.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.rahulshettyacademy.PageObjects.LandingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
        prop.load(fis);
        String url = prop.getProperty("url");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Check for a 'headless' system property
        boolean headless = "true".equalsIgnoreCase(System.getProperty("headless"));

        if (headless) {
            options.addArguments("--headless=new");
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        // Set a specific size for headless mode, otherwise maximize
        if (headless) {
            driver.manage().window().setSize(new Dimension(1440, 900));
        } else {
            driver.manage().window().maximize();
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}