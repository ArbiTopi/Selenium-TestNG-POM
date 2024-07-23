import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.BaseInformation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
@Listeners(listeners.Listeners.class)

public class LoginPageTest {
    private final WebDriver driver = BaseInformation.getDriver();
    boolean testBresults=false;
    LoginPage loginPage=new LoginPage();
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test(priority = 4)
    public void confirmUrl(){
        driver.get(Globals.loginPageUrl);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       Assert.assertEquals(driver.getCurrentUrl().toLowerCase(),Globals.loginPageUrl.toLowerCase());
    }
    @Test(priority =5)
    public void loginPagesForm()  {
        wait.until(d->loginPage.isDisplayed());
        loginPage.fillTextBoxArea();
        loginPage.checkBoxClick();
        loginPage.submitLogin();
    }
    @Test(priority = 6,groups = {"verifyLogin"})
    public void verifyLogin(){
       Assert.assertTrue(loginPage.verifyLogin(),"Logimi shkoji keq");
            testBresults=true;
    }

        @Test(priority = 7)
        public void verifyError () {
        if(!testBresults){
        Assert.assertTrue(loginPage.verifyErrorLoginMessage(), "Gabim nuk erdhi mesazhi i errorit per login");
        } else {
            throw new SkipException("Skipping veryfing error because we Loged in .");
        }

}

}
