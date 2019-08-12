package com.telran.tests.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {


  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if (!app.getTeam().isTeamPresent())
    {
      app.getTeam().createTeam();
    }

  }

  @Test
  public void testTeamDeletion() throws InterruptedException {
    app.getSession().pause(5000);
    int before = app.getTeam().getTeamsCount();
    app.getTeam().clickOnFirstTeam();
    app.getTeam().clickOnTeamSettings();
    app.getTeam().clickDeleteTeamLink();
    app.getTeam().confirmTeamDeletionButton();

    int after = app.getTeam().getTeamsCount();
    System.out.println("before deletion" + before + " and after deletion: " + after);
  }


}
