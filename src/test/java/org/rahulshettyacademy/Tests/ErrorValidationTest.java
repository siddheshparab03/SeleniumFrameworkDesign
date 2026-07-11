package org.rahulshettyacademy.Tests;

import org.rahulshettyacademy.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationTest extends BaseTest {

    @Test(groups = "ErrorHandling")
    public void loginErrorValidation(){
        landingPage.loginApplication("anshika@gmail.com", "Iamking@00");
        Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
    }
}