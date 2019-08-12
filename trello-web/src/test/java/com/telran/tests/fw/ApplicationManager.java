package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  SessionHelper session;
  BoardHelper board;
  TeamHelper team;
  HeaderPage header;
  HelperProfile profile;


 EventFiringWebDriver driver;

    public String browser;

    public class MyListener extends AbstractWebDriverEventListener
    {
        HelperBase helper = new HelperBase(driver);
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Start search element " +by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("element" + by + "found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {

            logger.error(throwable.toString());
            try {
                helper.takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ApplicationManager(String browser)
    {

        this.browser = browser;
    }

    public void init() throws InterruptedException {

    if(browser.equals(BrowserType.CHROME))
    {
        driver = new EventFiringWebDriver(new ChromeDriver());
    }
    else if(browser.equals(BrowserType.IE))
    {
        driver = new EventFiringWebDriver(new InternetExplorerDriver());
    }
    else if(browser.equals(BrowserType.FIREFOX))
    {
        driver = new EventFiringWebDriver(new FirefoxDriver());
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
       driver.register(new MyListener());
        session.login("de/niskog28@rambler.ru", "denisg28g28g28");
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
