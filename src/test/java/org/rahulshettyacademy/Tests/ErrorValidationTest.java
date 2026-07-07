package org.rahulshettyacademy.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.PageObjects.LandingPage;
import org.rahulshettyacademy.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ErrorValidationTest extends BaseTest {

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


}
