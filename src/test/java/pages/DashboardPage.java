package pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

  By dashboardHeader = By.xpath("//*[contains(normalize-space(),'Dashboard')]");

  public boolean isDashboardDisplayed() {
    return waitForVisibility(dashboardHeader).isDisplayed();
  }
}
