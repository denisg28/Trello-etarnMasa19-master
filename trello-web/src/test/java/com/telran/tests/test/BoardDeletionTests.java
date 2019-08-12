package com.telran.tests.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getBoard().isBoardPresent())
    {
      app.getBoard().createBoard();
    }

  }



  @Test
  public void testBoardDeletion() throws InterruptedException {
    int before = app.getBoard().getBoardsCount();

    app.getBoard().openFirstPrivateBoard();
    app.getBoard().initBoardDeletion();
    app.getBoard().confirmBoardDeletion();//.js-delete
    app.getBoard().confirmFinishBoardDeletion();//.js-confirm.full
    app.getHeader().clickOnHomeButtonOnHeader();//[href='/']
    int after = app.getBoard().getBoardsCount();

    Assert.assertEquals(after, before - 1);
    System.out.println(after +":" + before);
  }
}
