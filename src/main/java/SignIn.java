import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class SignIn {

    @FindBy(how = How.CSS, using = "[data-nav*='nav=nav_SignIn'")
    private SelenideElement signInButton;

    @FindBy(how = How.ID, using = "new_session_username")
    private SelenideElement emailField;

    @FindBy(how = How.NAME, using = "new_session[password]")
    private SelenideElement passwordField;

    @Step
    private void clickSignInButton(){
        signInButton.click();
    }
    @Step
    private void enterEmail(String email){
        emailField.val(email);
    }
    @Step
    private void enterPassword(String password){
        passwordField.val(password).pressEnter();
    }

    public void signIn (String email, String password){
        clickSignInButton();
        enterEmail(email);
        enterPassword(password);
    }


}
