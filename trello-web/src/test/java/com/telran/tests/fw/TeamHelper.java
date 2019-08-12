package com.telran.tests.fw;

import com.telran.tests.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends  HelperBase {
  HeaderPage header = new HeaderPage(driver);

  public TeamHelper(WebDriver driver) {
    super(driver);
  }

  public void confirmTeamDeletionButton() {
    new WebDriverWait(driver, 15)
            .until(ExpectedConditions
                    .presenceOfElementLocated(By.cssSelector(".js-confirm")));
    click(By.cssSelector(".js-confirm"));
  }

  public void clickDeleteTeamLink() throws InterruptedException {
    Thread.sleep(5000);
    click(By.cssSelector(".quiet-button"));
  }

  public void clickOnTeamSettings() {
    click(By.cssSelector("a .icon-gear"));
  }

  public void clickOnFirstTeam() {
    click(By.cssSelector("[data-test-id='home-team-tab-name']"));
  }

  public int getTeamsCount() throws InterruptedException {

    WebElement teamsList = driver.findElement(By
            .cssSelector("nav.home-left-sidebar-container .js-react-root"));
    return teamsList.findElements(By.xpath(".//li")).size();
  }

  public int getTeamsCount2() {
    return driver.findElements(By
            .cssSelector("nav.home-left-sidebar-container .js-react-root li")).size();
  }

  public boolean isTeamPresent() {
    //._1vHmTKeiB3R9df .js-react-root li
    return isElementPresent(By.cssSelector("nav.home-left-sidebar-container .js-react-root li"));
  }

  public void createTeam() throws InterruptedException {
    header.clickOnPlusButtonOnHeader();
    selectCreateTeamFromDropDown();
    fillTeamForm(new Team()
            .setTeamName("M+" + System.currentTimeMillis())
            .setDescription("description"));
    confirmTeamCreationButton();
    header.clickOnHomeButtonOnHeader();

  }

  public void confirmTeamCreationButton() {
    click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
  }

  public void fillTeamForm(Team team) {
    type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
    type(By.cssSelector("[name='desc']"), team.getDescription());
  }

  public void selectCreateTeamFromDropDown() {
    click(By.xpath("//*[@data-test-id='header-create-team-button']"));
  }


  public void cleanTeams() throws InterruptedException {
    int count = getTeamsCount();

    while (count > 3) {
      clickOnFirstTeam();
      clickOnTeamSettings();
      clickDeleteTeamLink();
      confirmTeamDeletionButton();
      count = getTeamsCount();
    }
  }
}