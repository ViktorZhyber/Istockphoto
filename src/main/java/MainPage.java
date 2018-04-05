import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
        @FindBy(how = How.CSS, using = "span.action-label:nth-child(2)")
        public SelenideElement boardsMenuButton;

        @FindBy(how = How.CLASS_NAME, using = "create-board-link")
        public SelenideElement createBoard;

        @FindBy(how = How.CLASS_NAME, using = "enter-board-name")
        public SelenideElement newBoardName;

        @FindBy(how = How.CLASS_NAME, using = "view-board-link")
        public SelenideElement viewAllBoards;

        @FindBy(how = How.CLASS_NAME, using = "new-board")
        public SelenideElement textBoards;

        public void hoverBoardsMenuButton (){
            boardsMenuButton.hover();
        }

        public void createBoardButton(){
            createBoard.click();
        }
        public void clickViewAllBoardsButton(){
            viewAllBoards.click();
        }

        public void enterBoardName(String boardName){
            newBoardName.val(boardName).pressEnter();
        }

        public String textBoards(){
            return textBoards.getText();
        }
        @Step
        public void createNewBoard(String boardName) throws InterruptedException {
            this.hoverBoardsMenuButton();
            Thread.sleep(1000);
            this.createBoardButton();
            this.enterBoardName(boardName);

        }


    }

