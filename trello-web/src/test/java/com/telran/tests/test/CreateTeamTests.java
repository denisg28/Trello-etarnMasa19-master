package com.telran.tests.test;

import com.telran.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateTeamTests extends TestBase
{






@Test


    public void createTeamFromHeaderTest() throws InterruptedException {
    int before = app.getTeam().getTeamsCount();
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getTeam().selectCreateTeamFromDropDown();
    /////////////////////
    //Team team1 = new Team(.setTeamName("M+" + System.currentTimeMillis()).setDescription("description"));
    app.getTeam().fillTeamForm(new Team()
            .setTeamName("M+" + System.currentTimeMillis())
            .setDescription("description"));
    /////////////////////
    app.getTeam().confirmTeamCreationButton();
    app.getHeader().clickOnHomeButtonOnHeader();


    int after = app.getTeam().getTeamsCount();
    Assert.assertEquals(after,before+1);
    System.out.println("After="+after +":" + "Before="+before);
}


    @Test(dataProvider = "teams", dataProviderClass = Providers.class)


    public void createTeamFromHeaderwithdataProviderTest(Team team) throws InterruptedException
    {
        int before = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButtonOnHeader();
        app.getTeam().selectCreateTeamFromDropDown();
        /////////////////////
        //Team team1 = new Team(.setTeamName("M+" + System.currentTimeMillis()).setDescription("description"));
        app.getTeam().fillTeamForm(team);
        /////////////////////
        app.getTeam().confirmTeamCreationButton();
        app.getHeader().clickOnHomeButtonOnHeader();


        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after,before+1);
        System.out.println("After="+after +":" + "Before="+before);
    }
   @AfterClass


    public void postAction() throws InterruptedException {
       app.getTeam().cleanTeams();
   }

}



