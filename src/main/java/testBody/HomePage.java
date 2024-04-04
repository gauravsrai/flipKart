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

public class HomePage {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(AppiumDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Categories']")
    private WebElement titlePageCategory;

    private WebElement footerOptions(String footer){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='"+footer+"']"));
    }

    public CategoryPage clickOnFooterCategory(){
        logger.info("Selecting Footer option ");
        CommonUtility.click(footerOptions("Categories"));
        return new CategoryPage(driver,wait);
    }

}
