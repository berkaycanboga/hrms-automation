package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

  LoginPage loginPage = new LoginPage();
  DashboardPage dashboardPage = new DashboardPage();

  @When("admin logs in with valid credentials")
  public void admin_logs_in_with_valid_credentials() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
  }

  @Then("admin should see the dashboard page")
  public void admin_should_see_the_dashboard_page() {
    Assert.assertTrue(dashboardPage.isDashboardDisplayed());
  }
}
