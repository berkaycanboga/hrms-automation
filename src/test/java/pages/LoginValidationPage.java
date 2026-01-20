package pages;

import org.openqa.selenium.By;

public class LoginValidationPage extends BasePage {

  By usernameInput = By.name("username");
  By passwordInput = By.name("password");
  By loginBtn = By.xpath("//button[@type='submit']");

  By alertError = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

  By requiredFieldError = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

  public boolean isLoginPageDisplayed() {
    return waitForVisibility(usernameInput).isDisplayed();
  }

  public void enterUsername(String username) {
    waitForVisibility(usernameInput).clear();
    sendText(usernameInput, username);
  }

  public void enterPassword(String password) {
    waitForVisibility(passwordInput).clear();
    sendText(passwordInput, password);
  }

  public void clickLogin() {
    click(loginBtn);
  }

  public String getErrorMessage() {
    try {
      return waitForVisibility(alertError).getText();   // Invalid credentials
    } catch (Exception e) {
      return waitForVisibility(requiredFieldError).getText(); // Required
    }
  }
}
