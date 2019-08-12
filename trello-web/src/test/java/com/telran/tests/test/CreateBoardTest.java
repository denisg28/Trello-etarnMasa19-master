package com.telran.tests.test;

import com.telran.tests.model.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateBoardTest  extends  TestBase{

   // Logger logger = LoggerFactory.getLogger(CreateBoardTest.class);   //Создаем логгер и ассоциируем его с этим классом.



  @Test
  public void boardCreationTestFromHeader () throws InterruptedException {

int beforeCreation = app.getBoard().getBoardsCount();
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getBoard().selectCreateBoardFromDropDown();
    app.getBoard().fillBoardCreationForm(new Board().setBoardName("Masa+" + System.currentTimeMillis()));
    app.getBoard().confirmBoardCreation();
    app.getHeader().clickOnHomeButtonOnHeader();

    int afterCreation= app.getBoard().getBoardsCount();

    System.out.println(beforeCreation + " : " + afterCreation);

    Assert.assertEquals(afterCreation, beforeCreation +1);
  }

    @AfterClass


    public void postAction() throws InterruptedException {
        app.getBoard().cleanBoards();
    }


}
