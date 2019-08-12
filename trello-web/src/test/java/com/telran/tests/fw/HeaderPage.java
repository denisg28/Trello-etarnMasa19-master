package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends  HelperBase{
  public HeaderPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnHomeButtonOnHeader() throws InterruptedException {
    pause(10000);
    click(By.cssSelector("a [name=house]"));
    click(By.cssSelector("a [name=house]"));
  }

  public void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }
}
