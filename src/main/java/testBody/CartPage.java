package testBody;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testBrain.CommonUtility;

public class CartPage {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(CartPage.class);

    public CartPage(AppiumDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    private WebElement productSize(String size){
        return driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Size: "+size+"')]"));
    }

    private WebElement productName(String product){
        return driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+product+"')]"));
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Cart']")
    private WebElement titleMyCart;

    public void validateSelectedItem(String product, String size) {
        logger.info("Validating selected product in the cart");
        wait.until(ExpectedConditions.visibilityOf(titleMyCart));
        try {
            if (productSize(size).isDisplayed() && productName(product).isDisplayed()) {
                logger.info("Product is added successfully to cart");
            } else {
                Assert.fail("Failed to add product to cart");
            }
        }catch (Exception e){
            Assert.fail("Failed to add product to cart");
        }
    }
}
