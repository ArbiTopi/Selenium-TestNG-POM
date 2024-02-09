package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class LoginPageElements {
     public LoginPageElements(){
         PageFactory.initElements(BaseInformation.getDriver(), this);
     }

     @FindBy(className = "ico-logout")
     public WebElement logoutMenu;

     @FindBy(className = "ico-account")
     public WebElement accountMenu;

     @FindBy(css = "input[type=email]")
     public WebElement emailLogin;

     @FindBy(css="input#Password.password")
    public WebElement passowrdLogin;

     @FindBy(css = "input[type=checkbox]")
    public WebElement checkBox;

     @FindBy(css = "button[class='button-1 login-button']")
    public WebElement submitButton;

     @FindBy(css="div.message-error.validation-summary-errors")
     public WebElement errorMessage;
     @FindBy(css="a.ico-register")
     public  WebElement registerButton;

}
