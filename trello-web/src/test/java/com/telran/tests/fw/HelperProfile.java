package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class HelperProfile extends HelperBase
{

    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    public void clickOnProfileButton()
    {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void moveToImage()
    {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("[class='MrFeHFqEkuBP9W _1h1BubYfUOs6MB']"))).pause(5).click().perform();
    }


    public void attachPhoto(File file) throws InterruptedException {
        attach(By.xpath("//*[@name='file']"),file);

        pause(10000);
    }

}