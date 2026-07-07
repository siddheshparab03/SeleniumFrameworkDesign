package org.rahulshettyacademy.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.PageObjects.CartPage;
import org.rahulshettyacademy.PageObjects.CheckoutPage;
import org.rahulshettyacademy.PageObjects.ProductCatalogue;
import org.rahulshettyacademy.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		ProductCatalogue productCatalogue = landingPage.goToProductCatalogue();
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductAddedInCart(productName);
		Assert.assertTrue(match);
		 CheckoutPage checkoutPage =  cartPage.goToCheckoutPage();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
}