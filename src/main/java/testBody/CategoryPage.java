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

public class CategoryPage {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(CategoryPage.class);

    public CategoryPage(AppiumDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Categories']")
    private WebElement titlePageCategory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add to cart']")
    private WebElement btnAddToCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Go to cart']")
    private WebElement btnGoToCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
    private WebElement btnContinue;

    private WebElement category(String category){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='"+category+"']"));
    }

    private WebElement subCategory(String subCategory){
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+subCategory+"']"));
    }

    private WebElement productName(String product){
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']"));
    }
    private WebElement size(String size){
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+size+"']"));
    }

    private boolean isUserOnCategoryPage(){
        wait.until(ExpectedConditions.visibilityOf(titlePageCategory));
        return titlePageCategory.isDisplayed();
    }

    public void validateCategoryPage(){
        logger.info("Validating Category page");
        if(isUserOnCategoryPage()==true){
            logger.info("User navigated to Category page");
        }else{
            Assert.fail("Failed to navigate to Category page");
        }
    }
    public CategoryPage selectCategoryOption(String category){
        logger.info("Selecting Category ");
        CommonUtility.click(category(category));
        return new CategoryPage(driver,wait);
    }

    public CategoryPage selectSubCategory(String subCategory){
        logger.info("Selecting sub category ");
        CommonUtility.click(subCategory(subCategory));
        return new CategoryPage(driver,wait);
    }

    public CategoryPage selectFirstProduct(String product){
        logger.info("Selecting product ");
        CommonUtility.scrollToAnElementByText(product);
        CommonUtility.click(productName(product));
        return new CategoryPage(driver,wait);
    }

   // Size Chart

    public CategoryPage clickOnAddToCart(){
        logger.info("Click on add to cart ");
        btnAddToCart.click();
        return new CategoryPage(driver,wait);
    }

    public CategoryPage selectSize(String size){
        logger.info("Select size "+size);
        CommonUtility.click(size(size));
        return new CategoryPage(driver,wait);
    }

    public CategoryPage clickOnContinue(){
        logger.info("Click on continue ");
        btnContinue.click();
        return new CategoryPage(driver,wait);
    }

    public CartPage clickOnGoToCart(){
        logger.info("Click on Go To Cart ");
        CommonUtility.click(btnGoToCart);
        return new CartPage(driver,wait);
    }
}
