package com.telran.tests.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChangeAvatarTest extends TestBase
{

    @BeforeMethod
    public void preconditions() throws IOException {
        app.getProfile().takeScreenshot();    //Делаем скриншот в начале теста
    }

    @Test
    public void ChangeAvatarTest() throws InterruptedException {
        app.getSession().clickOnAvatar();
        app.getProfile().clickOnProfileButton();  //getProfile() nash Getter.
        app.getSession().pause(2000);
        app.getProfile().moveToImage();
        app.getProfile().attachPhoto(new File("src/test/resources/l392PLWw.jpeg"));
        app.getHeader().clickOnHomeButtonOnHeader();

    }

    @AfterMethod
    public void postactions() throws IOException {
        app.getProfile().takeScreenshot();  //Делаем скриншот в конце теста
    }
}