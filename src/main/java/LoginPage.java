import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputFiled;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;


    public void enterValueToUserName(User user){
        userNameInputField.sendKeys(user.getUsername());
    }

    public void enterValueToPassword(User user){
        passwordInputFiled.sendKeys(user.getPassword());
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void errorMessageTextIsCorrect(String expectedText){
        assertEquals(expectedText, errorMessage.getText());
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }


    public void successLogin(User user){
        userNameInputField.sendKeys(user.getUsername());
        passwordInputFiled.sendKeys(user.getPassword());
        loginButton.click();
    }
}
