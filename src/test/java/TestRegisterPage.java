import globals.Globals;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;
import utilities.BaseInformation;
import java.time.Duration;
@Listeners(listeners.Listeners.class)

public class TestRegisterPage {
    SoftAssert softAssert = new SoftAssert();
    private final WebDriver driver = BaseInformation.getDriver();
    RegisterPage registerPage = new RegisterPage();
    private boolean testAResult = false;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    @BeforeTest
    public void setup() {
        driver.get(Globals.homePageUrl);
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 0)
    public void testLoginButton()  {
        registerPage.clickLoginButton();
        registerPage.clickRegisterButtonMenu();
      //  registerPage.filingPasswordTextBoxes();
      //  registerPage.submitRegistration();
//        registerPage.checkConfirmPasswordError();
//        registerPage.checkPasswordErrors();
//        registerPage.displayedErrors();


        softAssert.assertEquals(driver.getTitle(), "nopCommerce demo store. Register", "Title is not Matching");
//        registerPage.fillForm();
//        softAssert.assertAll();
    }
    @Test(priority = 1)
    public void fillForm(){
        registerPage.fillNameTextBox();
        registerPage.genderRadioButton();
        registerPage.birthdaySelectors();
        registerPage.fillEmailTextBox();
        registerPage.fillCompanyName();
        registerPage.newsLetterSubscription();
        registerPage.fillngPasswordTextBoxes();
        testAResult=true;

    }

    @Test(dependsOnMethods = "fillForm")
    public void checkingErrors(){
        if (!testAResult) {
            registerPage.checkConfirmPasswordError();
            registerPage.checkPasswordErrors();
            registerPage.displayedErrors();
        } else {
            throw new SkipException("Skipping checkingErrors because fillingForm method passed.");
    }}


    @Test(priority = 2)
    public void submitRegister(){
        registerPage.submitRegistration();
    }
    @Test(priority = 3)
    public void verifyRegistration(){
        softAssert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/","Wrong Link");
        softAssert.assertEquals(registerPage.checkRegistration(),true,"This was unsuccessful registration");
    }
    @AfterTest
    public void endTest(){
        softAssert.assertAll();
    }

}
