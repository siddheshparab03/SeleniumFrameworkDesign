    package org.rahulshettyacademy.AbstractComponents;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.rahulshettyacademy.PageObjects.CartPage;

    import java.time.Duration;

    public class AbstractComponent {
        WebDriver driver;

        public AbstractComponent(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(css = "button[routerlink='/dashboard/cart']")
        private WebElement cartButton;

        public void waitUntilElementAppear(By findBy){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        }

        public void waitUntilElementDisappear(WebElement ele){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(ele));
        }

        public void waitUntilForElementDisappear(By findBy){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
        }

        public void waitUntilElementBeClickable(By findBy){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(findBy));
        }

        public CartPage goToCartPage(){
            waitUntilElementBeClickable(By.cssSelector("button[routerlink='/dashboard/cart']"));
           cartButton.click();
           return new CartPage(driver);
        }

        public void waitUntilElementAppear(WebElement ele){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(ele));
        }



    }
