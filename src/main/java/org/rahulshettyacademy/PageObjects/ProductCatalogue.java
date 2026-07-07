package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
