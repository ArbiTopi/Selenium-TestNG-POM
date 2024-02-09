package pages;

import elements.RegisterPageElements;
import globals.Globals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.BaseInformation;

import java.time.Duration;

public class RegisterPage {
    SoftAssert softAssert = new SoftAssert();

    public RegisterPage() {PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    RegisterPageElements registerPageElements = new RegisterPageElements();

    public void clickLoginButton(){
        registerPageElements.loginButton.click();
    }
    public void clickRegisterButtonMenu(){
        registerPageElements.registerButtonMenu.click();
    }

    public void genderRadioButton(){
        if(Globals.gender.toLowerCase().contains("f"))
            registerPageElements.femaleRadioButton.click();
        else
            registerPageElements.maleRadioButton.click();
    }
    public void fillNameTextBox(){
        registerPageElements.firstNameTextBox.sendKeys(Globals.fullName.split(" ")[0]);
        registerPageElements.lastNameTextBox.sendKeys(Globals.fullName.split(" ")[1]);
    }
    public void fillEmailTextBox(){
        registerPageElements.emailTextBox.sendKeys(Globals.email);
    }
    public void fillCompanyName(){
        registerPageElements.companyName.sendKeys("Lufthansa");
    }
    public void fillngPasswordTextBoxes(){
        registerPageElements.passwordTextBox.sendKeys(Globals.password);
        registerPageElements.confirmPasswordTextBox.sendKeys(Globals.password);
    }
    public void newsLetterSubscription(){
        registerPageElements.newsCheckBox.click();
    }

    public void birthdaySelectors(){
        registerPageElements.daySelector.sendKeys("5");
        registerPageElements.MonthSelector.sendKeys("6");
        registerPageElements.yearSelector.sendKeys("2002");
    }

    public void submitRegistration(){
        registerPageElements.registerButton.click();
    }
    public void displayedErrors(){
        for(WebElement sc : registerPageElements.erroret){
            if(sc.isDisplayed())
                System.out.println(sc.getText());
        }
    }
    public void checkConfirmPasswordError(){
        String errorM=registerPageElements.confirmPasswordError.getText();
        if (registerPageElements.confirmPasswordError.isDisplayed()) {
            softAssert.assertNotEquals(errorM,"Password is required."
                    ,"Konfirmimi i passwordit eshte bosh");
            softAssert.assertNotEquals(errorM,"The password and confirmation password do not match.","Konfirmi i passwordit sesht i njejte");

        }

    }
    public void checkPasswordErrors(){
       String errorM= registerPageElements.passwordError.getText();

        if(registerPageElements.passwordError.isDisplayed()){
            softAssert.assertNotEquals(errorM,"Password is required.","Empty password textBox");
            softAssert.assertNotEquals(errorM,"Password must meet the following rules:\n" +
                    "must have at least 6 characters","Passwordi ka m pak se 6 shkronja");
            }
        //softAssert.assertAll(); n fund t testit

    }

    public boolean checkRegistration(){
        String resultText = registerPageElements.result.getText();
        String sucessText="Your registration completed";
            if(resultText.equals(sucessText))
                return true;
            else
                return false;
    }
}
