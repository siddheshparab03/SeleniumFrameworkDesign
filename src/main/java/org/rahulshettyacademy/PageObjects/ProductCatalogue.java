package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By addToCart = By.cssSelector(".card-body button:last-of-type");
//    By toastMsg = By.cssSelector("#toast-container");
    @FindBy(css = "#toast-container")
    private WebElement toastMsg;
    @FindBy(css = ".ng-animating")
    private WebElement spinner;



    public List<WebElement> getAllProducts(){
        return products;
    }

    public WebElement getProductByName(String productName){
        WebElement prod = getAllProducts().stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName){
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitUntilElementAppear(toastMsg);
        waitUntilElementDisappear(spinner);
        // Also wait for the toast message to disappear
        waitUntilElementDisappear(toastMsg);
    }
}