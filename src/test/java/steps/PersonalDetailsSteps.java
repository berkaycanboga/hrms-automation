package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.EmployeeListPage;
import pages.PersonalDetailsPage;
import pages.LoginPage;
import utils.ConfigReader;

public class PersonalDetailsSteps {

  LoginPage loginPage = new LoginPage();
  EmployeeListPage empListPage = new EmployeeListPage();
  PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();

  @Given("ESS user is logged in")
  public void ess_user_is_logged_in() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
  }

  @When("ESS user navigates to Employee List page")
  public void ess_user_navigates_to_employee_list_page() {
    empListPage.goToEmployeeList();
  }

  @When("ESS user searches for employee {string}")
  public void ess_user_searches_for_employee(String empName) {
    empListPage.searchByName(empName);
    Assert.assertTrue(empListPage.isEmployeeDisplayedByName(empName));
  }

  @When("ESS user opens personal details of {string}")
  public void ess_user_opens_personal_details_of(String empName) {
    String[] parts = empName.split(" ");
    By empRowLocator = By.xpath(
            "//div[@role='row'][.//div[normalize-space()='" + parts[0] + "'] " +
                    "and .//div[normalize-space()='" + parts[1] + "']]"
    );
    ((org.openqa.selenium.JavascriptExecutor) empListPage.driver)
            .executeScript("arguments[0].click();", empListPage.waitForVisibility(empRowLocator));
  }

  @Then("personal details page should be displayed")
  public void personal_details_page_should_be_displayed() {
    Assert.assertTrue(personalDetailsPage.isPersonalDetailsPageDisplayed());
  }

  @When("ESS user updates personal details with {string}, {string}, {string}, {string}, {string}, {string}")
  public void ess_user_updates_personal_details(String firstName, String middleName, String lastName,
                                                String gender, String nationality, String maritalStatus) {
    personalDetailsPage.editPersonalDetails(firstName, middleName, lastName, gender, nationality, maritalStatus);
  }

  @Then("personal details should be updated successfully")
  public void personal_details_should_be_updated_successfully() {
    Assert.assertTrue(personalDetailsPage.isUpdateSuccessful());
  }
}
