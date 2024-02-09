package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.time.Duration;
import java.util.List;

public class RegisterPageElements {
    public RegisterPageElements() {
            PageFactory.initElements(BaseInformation.getDriver(), this);
    }


    @FindBy(css = "a[class='ico-login']")
    public WebElement loginButton;

    @FindBy(css = ".button-1.register-button")
    public WebElement registerButtonMenu;

    @FindBy(css="input#gender-male")
    public WebElement maleRadioButton;

    @FindBy(css="input#gender-female")
    public WebElement femaleRadioButton;

    @FindBy(css="input#FirstName")
    public WebElement firstNameTextBox;

    @FindBy(css = "input#LastName")
    public WebElement lastNameTextBox;

    @FindBy(name = "DateOfBirthDay")
    public WebElement daySelector;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement MonthSelector;
    @FindBy(name = "DateOfBirthYear")
    public WebElement yearSelector;

    @FindBy(css = "input#Email")
    public WebElement emailTextBox;

    @FindBy(css = "input#Company")
    public WebElement companyName;

    @FindBy(css="input#Newsletter")
    public WebElement newsCheckBox;

    @FindBy(css="input#Password")
    public WebElement passwordTextBox;

    @FindBy(css="input#ConfirmPassword")
    public WebElement confirmPasswordTextBox;

    @FindBy(name = "register-button")
    public WebElement registerButton;
    @FindBy(id = "FirstName-error")
    public WebElement firstNameError;
    @FindBy(id = "LastName-error")
    public WebElement lastNameError;
    @FindBy(id ="Email-error")
    public WebElement emailError;
    @FindBy(id = "Password-error")
    public WebElement passwordError;
    @FindBy(id = "ConfirmPassword-error")
    public WebElement  confirmPasswordError;
    @FindBy(css = "span[id*='error']")
    public List<WebElement> erroret;

    @FindBy(className = "result")
    public WebElement result;

    @FindBy(css = ".button-1.register-continue-button")
    public WebElement resultButton;



}
