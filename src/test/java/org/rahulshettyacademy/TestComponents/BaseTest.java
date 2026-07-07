package org.rahulshettyacademy.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.rahulshettyacademy.PageObjects.LandingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public  LandingPage landingPage;

    @BeforeMethod
    public void InitializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless=new");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        //driver.manage().window().setSize(new Dimension(1440,900));//full screen
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage = new LandingPage(driver);

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
