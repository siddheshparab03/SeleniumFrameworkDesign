package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    public List<WebElement> getAllCartProducts(){
        return cartProducts;
    }

    public Boolean verifyProductAddedInCart(String productName){
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckoutPage(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
