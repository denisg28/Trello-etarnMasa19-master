package com.telran.tests.fw;

import com.telran.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.telran.tests.test.TestBase.app;

public class BoardHelper extends HelperBase {
  HeaderPage header = new HeaderPage(driver);

  public BoardHelper(WebDriver driver) {
    super(driver);
  }

  public void confirmBoardCreation() throws InterruptedException {
    click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    pause(15000);
  }

  public void fillBoardCreationForm(Board board) {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), board.getBoardName());
    click(By.cssSelector("button.W6rMLOx8U0MrPx"));

    //select without team
    click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));

  }

  public void selectCreateBoardFromDropDown() {
    click(By.xpath("//*[@data-test-id='header-create-board-button']"));
  }

  public int getBoardsCount() throws InterruptedException {
    pause(5000);
    return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;  //TYT -1;
  }

  public void cleanBoards() throws InterruptedException {
    int before = getBoardsCount();
    while (before > 4) {
      openFirstPrivateBoard();
      initBoardDeletion();
      confirmBoardDeletion();//.js-delete
      confirmFinishBoardDeletion();//.js-confirm.full
      header.clickOnHomeButtonOnHeader();//[href='/']
      int after = getBoardsCount();
      System.out.println("left " + after + "groups");
      before = app.getBoard().getBoardsCount();
    }
  }

  public void confirmFinishBoardDeletion() {
    click(By.cssSelector(".js-confirm.full"));
  }

  public void confirmBoardDeletion() {
    new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-delete")));
    click(By.cssSelector(".js-delete"));
  }

  public void initBoardDeletion() throws InterruptedException {
    clickMoreButtonInTheMenu();
    clickCloseBoardButton();
    confirmCloseButton();
  }

  public void confirmCloseButton() {
    click(By.cssSelector(".js-confirm.full.negate"));
  }

  public void clickCloseBoardButton() {
    click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));

  }

  public void clickMoreButtonInTheMenu() throws InterruptedException {
    pause(5000);
    click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
  }


  public void openFirstPrivateBoard() throws InterruptedException {
    pause(5000);
    WebElement privateBoardsList = driver.findElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul"));
    String boardNameForDelete = privateBoardsList.findElement(By.xpath(".//li")).getText();
    System.out.println("Deleted board" + boardNameForDelete);
    privateBoardsList.findElement(By.xpath(".//li")).click();
  }

  public void createBoard() throws InterruptedException {
    header.clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm(new Board().setBoardName("Masa+" + System.currentTimeMillis()));
    confirmBoardCreation();
    header.clickOnHomeButtonOnHeader();
  }

  public boolean isBoardPresent()
  {


    return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
  }
}
