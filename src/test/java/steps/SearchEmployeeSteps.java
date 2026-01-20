package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.ConfigReader;

public class SearchEmployeeSteps {

  LoginPage loginPage = new LoginPage();
  EmployeeListPage empListPage = new EmployeeListPage();

  @Given("admin is logged in for employee search")
  public void admin_is_logged_in_for_employee_search() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
  }

  @And("admin navigates to Employee List page")
  public void admin_navigates_to_employee_list_page() {
    empListPage.goToEmployeeList();
  }

  @When("admin searches employee by name {string}")
  public void admin_searches_employee_by_name(String name) {
    empListPage.searchByName(name);
  }

  @When("admin searches employee by id {string}")
  public void admin_searches_employee_by_id(String id) {
    empListPage.searchById(id);
  }

  @Then("employee with name {string} should be displayed")
  public void employee_with_name_should_be_displayed(String name) {
    Assert.assertTrue(empListPage.isEmployeeDisplayedByName(name));
  }

  @Then("employee with id {string} should be displayed")
  public void employee_with_id_should_be_displayed(String id) {
    Assert.assertTrue(empListPage.isEmployeeDisplayedById(id));
  }

  @Then("system should show No Records Found message")
  public void system_should_show_no_records_found_message() {
    Assert.assertTrue(empListPage.isNoRecordsMessageDisplayed());
  }
}
