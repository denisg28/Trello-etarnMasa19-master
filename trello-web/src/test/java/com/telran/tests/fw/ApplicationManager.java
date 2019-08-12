package com.telran.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  SessionHelper session;
  BoardHelper board;
  TeamHelper team;
  HeaderPage header;
  HelperProfile profile;

 WebDriver driver;
    public String browser;

    public ApplicationManager(String browser)
    {

        this.browser = browser;
    }

    public void init() throws InterruptedException {

    if(browser.equals(BrowserType.CHROME))
    {
        driver = new ChromeDriver();
    }
    else if(browser.equals(BrowserType.IE))
    {
        driver = new InternetExplorerDriver();
    }
    else if(browser.equals(BrowserType.FIREFOX))
    {
        driver = new FirefoxDriver();
    }else
    {
        System.out.println("Unknown Browser Format");
    }

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.navigate().to("https://trello.com");
    session = new SessionHelper(driver);
    board = new BoardHelper(driver);
    team = new TeamHelper(driver);
    header = new HeaderPage(driver);
    profile = new HelperProfile(driver);

   //session.login("elena.telran@yahoo.com", "12345.com");
        session.login("deniskog28@rambler.ru", "denisg28g28g28");
   //   session.login("denisg28g@gmail.com", "denisg28g28g28");
//        driver.manage().window().maximize();
  }


  public void stop() {
    driver.quit();
  }

  public SessionHelper getSession() {
    return session;
  }

  public BoardHelper getBoard() {
    return board;
  }

  public TeamHelper getTeam() {
    return team;
  }

  public HeaderPage getHeader() {
    return header;
  }

  public String getUrl()
  {
    return driver.getCurrentUrl();
  }

  public HelperProfile getProfile()
  {
      return profile;
  }



  
}
