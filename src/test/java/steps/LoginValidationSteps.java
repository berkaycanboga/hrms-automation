package steps;

import io.cucumber.java.en.*;
import pages.LoginValidationPage;

import static org.junit.Assert.*;

public class LoginValidationSteps {

  LoginValidationPage loginPage = new LoginValidationPage();

  @Given("User is on login validation page")
  public void user_is_on_login_validation_page() {
    assertTrue(loginPage.isLoginPageDisplayed());
  }

  @When("User enters validation username {string} and password {string}")
  public void user_enters_validation_username_and_password(String username, String password) {
    if (!username.equals("EMPTY")) {
      loginPage.enterUsername(username);
    }
    if (!password.equals("EMPTY")) {
      loginPage.enterPassword(password);
    }
  }

  @And("User clicks login button")
  public void user_clicks_login_button() {
    loginPage.clickLogin();
  }

  @Then("Validation error message {string} should be shown")
  public void validation_error_message_should_be_shown(String expectedMessage) {
    String actual = loginPage.getErrorMessage();
    assertEquals(expectedMessage, actual);
  }

  @And("User stays on login page")
  public void user_stays_on_login_page() {
    assertTrue(loginPage.isLoginPageDisplayed());
  }
}
