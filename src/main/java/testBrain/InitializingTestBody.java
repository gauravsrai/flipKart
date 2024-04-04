package testBrain;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBody.CartPage;
import testBody.CategoryPage;
import testBody.HomePage;
import testBody.LoginPage;

public class InitializingTestBody {
    public LoginPage loginPage;
    public HomePage homePage;
    public CategoryPage categoryPage;
    public CartPage cartPage;

    public InitializingTestBody(AppiumDriver driver, WebDriverWait wait){
        loginPage=new LoginPage(driver,wait);
        homePage=new HomePage(driver,wait);
        categoryPage=new CategoryPage(driver,wait);
        cartPage=new CartPage(driver,wait);
    }
}
