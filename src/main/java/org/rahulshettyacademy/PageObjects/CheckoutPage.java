        package org.rahulshettyacademy.PageObjects;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

        public class CheckoutPage extends AbstractComponent {
            WebDriver driver;

            public CheckoutPage(WebDriver driver){
                super(driver);
                this.driver = driver;
                PageFactory.initElements(driver, this);
            }

            @FindBy(css = "[placeholder='Select Country']")
            private WebElement country;

            @FindBy(css = ".ta-results button:last-child")
            private WebElement selectCountry;

            @FindBy(css = ".action__submit")
            private WebElement submit;

            By results = By.cssSelector(".ta-results");

            public void selectCountryFromDropdown(){
                Actions a = new Actions(driver);
                a.sendKeys(country, "india").build().perform();
                waitUntilElementAppear(results);
                selectCountry.click();
            }

            public ConfirmationPage submitOrder(){
                //waitUntilForElementDisappear(results);
                waitUntilElementBeClickable(By.cssSelector(".action__submit"));
                submit.click();
                return new ConfirmationPage(driver);
            }

        }
