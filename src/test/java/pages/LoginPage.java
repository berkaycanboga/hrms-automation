package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  By username = By.name("username");
  By password = By.name("password");
  By loginBtn = By.cssSelector("button[type='submit']");

  public void login(String user, String pass) {
    waitForVisibility(username).sendKeys(user);
    waitForVisibility(password).sendKeys(pass);
    waitForClickability(loginBtn).click();
  }
}
