package com.telran.tests.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {
  WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }


  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator , String text) {  //method type was;
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void attach(By locator , File file)
  {
    //method "type" was;attach - это метод для выбора файлов автоматически; //
//    click(locator);
//    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(file.getAbsolutePath()); //передаем адресс С:/trello...file.
  }

  public boolean isElementsPresent(By locator) {
    return driver.findElements(locator).size()>0;
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }

public void takeScreenshot() throws IOException {
  File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  File screenshot = new File("src/test/screenshots/screenshot-" + System.currentTimeMillis() + ".png");

  Files.copy(tmp, screenshot);
  System.out.println("Screenshot name: "+ screenshot.getName());     //getAbsolutePath() - распечатай путь к этому скриншоту; getName() - печатает только название скриншота

}

}
