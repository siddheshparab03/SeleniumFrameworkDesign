package org.rahulshettyacademy.Tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.PageObjects.CartPage;
import org.rahulshettyacademy.PageObjects.CheckoutPage;
import org.rahulshettyacademy.PageObjects.ConfirmationPage;
import org.rahulshettyacademy.PageObjects.LandingPage;
import org.rahulshettyacademy.PageObjects.ProductCatalogue;
import org.rahulshettyacademy.TestComponents.BaseTest;
import org.rahulshettyacademy.data.DataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		landingPage.loginApplication(input.get("email"), input.get("password"));
		ProductCatalogue productCatalogue = landingPage.goToProductCatalogue();
		productCatalogue.getProductByName(input.get("productName"));
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductAddedInCart(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage =  cartPage.goToCheckoutPage();
		checkoutPage.selectCountryFromDropdown();
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		DataReader reader = new DataReader();
		List<HashMap<String, String>> data = reader.getJsonDataToMap(System.getProperty("user.dir") + "//src//test//resources//test-data.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}