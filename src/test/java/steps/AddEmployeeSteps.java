package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class AddEmployeeSteps {

  LoginPage loginPage = new LoginPage();
  DashboardPage dashboardPage = new DashboardPage();
  AddEmployeePage addEmployeePage = new AddEmployeePage();

  @Given("admin is logged in")
  public void admin_is_logged_in() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
    Assert.assertTrue(dashboardPage.isDashboardDisplayed());
  }

  @When("admin navigates to Add Employee page")
  public void admin_navigates_to_add_employee_page() {
    addEmployeePage.goToAddEmployee();
  }

  @And("admin enters employee first and last name")
  public void admin_enters_employee_first_and_last_name() {
    addEmployeePage.enterEmployeeName("Ali", "Veli");
  }

  @And("admin saves the employee")
  public void admin_saves_the_employee() {
    addEmployeePage.saveEmployee();
  }

  @Then("employee should be added successfully")
  public void employee_should_be_added_successfully() {
    Assert.assertTrue(addEmployeePage.isEmployeeSaved());
  }
}
