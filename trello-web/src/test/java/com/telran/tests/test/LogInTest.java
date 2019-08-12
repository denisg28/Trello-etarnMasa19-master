package com.telran.tests.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
  @BeforeMethod
public void preconditions(){
  app.getSession().logout();
}
  @Test
  public void loginTest() throws InterruptedException {
    String currentUrl = app.getUrl();

    Assert.assertEquals(currentUrl, "https://trello.com/logged-out");

    app.getSession().clickOnLoginButton();
    app.getSession().fillUserForm("deniskog28@rambler.ru", "denisg28g28g28");
    app.getSession().confirmLoginButton();
    app.getSession().pause(4000);

    Assert.assertTrue(app.getSession().isUserLoggedIn());
  }


}
