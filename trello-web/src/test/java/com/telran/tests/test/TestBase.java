package com.telran.tests.test;

import com.telran.tests.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeMethod(alwaysRun = true)
  public void startLogger(Method method, Object[]p)
  {
    logger.info("Start CreateBoardTest" + method.getName() + "with parameters" + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void stopLogger(Method method)
  {
    logger.info("Stop CreateBoardTest");

  }

  public static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws InterruptedException {
    app.init();
  }

  @AfterSuite
  public void tearDown(){
    app.stop();
  }

}
