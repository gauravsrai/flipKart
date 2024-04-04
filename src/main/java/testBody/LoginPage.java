package testBody;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBrain.CommonUtility;

public class LoginPage {

    private AppiumDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(AppiumDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement btnSkip;

    public void clickOnSkip(){
        logger.info("Clicking on Skip Button ");
        CommonUtility.click(btnSkip);
    }




}
