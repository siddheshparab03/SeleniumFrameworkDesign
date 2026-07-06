package org.rahulshettyacademy.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ErrorValidationTest {
    WebDriver driver;
    @BeforeTest
    public void initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");


        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/client");
    }


    @Test
    public void loginErrorValidation(){

        driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Iamking@00");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='flyInOut']")));
        String errorMsg = driver.findElement(By.cssSelector("[class*='flyInOut']")).getText();
        Assert.assertEquals(errorMsg,"Incorrect email or password.");

    }
    

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.close();
        }
    }


}
