package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
    WebDriver driver;


    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(id = "login")
    private WebElement loginButton;


    @FindBy(css = "[class*='flyInOut']")
    private WebElement errorMessage;

    public void loginApplication(String username, String password){
        userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage(){
        waitUntilElementAppear(errorMessage);
        return errorMessage.getText();
    }

    public ProductCatalogue goToProductCatalogue(){
         return new ProductCatalogue(driver);
    }

}