package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;


    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(id = "login")
    private WebElement loginButton;

    public void loginApplication(String username, String password){
        userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public ProductCatalogue goToProductCatalogue(){
         return new ProductCatalogue(driver);
    }

}
