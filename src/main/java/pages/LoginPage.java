package pages;

import elements.LoginPageElements;
import globals.Globals;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    LoginPageElements loginPageElements= new LoginPageElements();

    public boolean isDisplayed(){
        return loginPageElements.emailLogin.isDisplayed();
    }

    public void fillTextBoxArea(){
        loginPageElements.emailLogin.sendKeys(Globals.email);
        loginPageElements.passowrdLogin.sendKeys(Globals.password);
    }
    public void checkBoxClick(){
        loginPageElements.checkBox.click();
    }
    public void registerClick(){
        loginPageElements.registerButton.click();
    }
    public void submitLogin(){
        loginPageElements.submitButton.click();
    }
    public boolean verifyErrorLoginMessage(){
        String pagerError =loginPageElements.errorMessage.getText().split("\n")[0];
        String error="Login was unsuccessful. Please correct the errors and try again.";
            return error.equals(pagerError);
    }
    public boolean verifyLogin(){
        if(loginPageElements.logoutMenu.isDisplayed()&&loginPageElements.accountMenu.isDisplayed()){
            return true;
        }
        else
            return false;
    }


}
