import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class TestLogin {
    private static String email ="kosmos7354@gmail.com";
    private static String password ="asdll123";
    private static String boardName ="MyBoardName";
    private static String textBoardsEmpty ="Boards are the best place to save images and video clips.";



    @BeforeTest
    public void beforeTest(){
        Configuration.browser = "chrome" ;
        open("https://www.istockphoto.com/");
    }
    @Test
    public void loginToPage () throws InterruptedException {
        SignIn signIn = page(SignIn.class);
        MainPage mainPage = page(MainPage.class);
        Boards boards = page(Boards.class);
        signIn.signIn(email,password);
        mainPage.createNewBoard(boardName);
        mainPage.hoverBoardsMenuButton();
        mainPage.clickViewAllBoardsButton();
        Assert.assertEquals(boards.boardname(), boardName);
        boards.clickDeleteBoardButton();
        mainPage.hoverBoardsMenuButton();
        Thread.sleep(1000);
        Assert.assertEquals(mainPage.textBoards(), textBoardsEmpty);
    }
}
