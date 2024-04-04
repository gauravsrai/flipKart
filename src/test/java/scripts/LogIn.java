package scripts;

import org.testng.annotations.Test;
import testBody.CartPage;
import testBrain.BaseTest;

public class LogIn extends BaseTest {

    @Test
     public void loginToApplication() throws InterruptedException {
        logger.info("Logged in to the application");

        initialize.loginPage.clickOnSkip();
        initialize.homePage.clickOnFooterCategory().validateCategoryPage();
        CartPage cartPage = initialize.categoryPage.selectCategoryOption(BaseTest.testData.getProperty("category"))
                .selectSubCategory(BaseTest.testData.getProperty("subCategory"))
                .selectFirstProduct(BaseTest.testData.getProperty("productName"))
                .clickOnAddToCart()
                .selectSize(BaseTest.testData.getProperty("size"))
                .clickOnContinue()
                .clickOnGoToCart();
        cartPage.validateSelectedItem(BaseTest.testData.getProperty("productName"),BaseTest.testData.getProperty("size"));

     }
}
