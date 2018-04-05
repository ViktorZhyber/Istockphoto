import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.switchTo;

public class Boards {
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div/section[4]/div/ul/li[2]/div[4]")
    public SelenideElement deleteBoardButton;

    @FindBy(how = How.CSS, using = "a.text")
    public SelenideElement fieldBoardName;
    @Step
    public void clickDeleteBoardButton(){
        deleteBoardButton.click();
        switchTo().alert().accept();
    }

    @Step
    public String boardname (){
        return fieldBoardName.getText();
    }

}
