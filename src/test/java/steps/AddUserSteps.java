package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AddUserPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class AddUserSteps {

  LoginPage loginPage = new LoginPage();
  DashboardPage dashboardPage = new DashboardPage();
  AddUserPage addUserPage = new AddUserPage();

  private String uniqueUsername;

  @Given("admin is logged in for user creation")
  public void admin_is_logged_in_for_user_creation() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
    Assert.assertTrue(dashboardPage.isDashboardDisplayed());
  }

  @When("admin navigates to Add User page")
  public void admin_navigates_to_add_user_page() {
    addUserPage.goToAddUserPage();
  }

  @And("admin creates ESS user for employee")
  public void admin_creates_ess_user_for_employee() {
    // Her build için unique username üret
    uniqueUsername = "ali.ess" + System.currentTimeMillis();
    addUserPage.fillUserForm("Ali Veli", uniqueUsername, "Qa@2026Test!");
  }

  @And("admin saves the new user")
  public void admin_saves_the_new_user() {
    addUserPage.saveUser();
  }

  @Then("user should be created successfully")
  public void user_should_be_created_successfully() {
    Assert.assertTrue(addUserPage.isUserCreated());
    System.out.println("Created user: " + uniqueUsername);
  }
}
