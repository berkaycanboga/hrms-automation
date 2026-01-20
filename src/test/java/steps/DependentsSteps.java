package steps;

import io.cucumber.java.en.*;
import pages.DependentsPage;
import pages.LoginPage;
import utils.ConfigReader;

public class DependentsSteps {

  LoginPage loginPage = new LoginPage();
  DependentsPage dependentsPage = new DependentsPage();

  @Given("ESS user is logged in for dependents")
  public void ess_user_is_logged_in_for_dependents() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
  }

  @When("ESS user navigates to Dependents of {string}")
  public void ess_user_navigates_to_dependents_of(String employeeName) {
    dependentsPage.goToDependentsOf(employeeName);
  }

  @Then("Dependents section should be displayed")
  public void dependents_section_should_be_displayed() {
    assert dependentsPage.isDependentsSectionDisplayed();
  }

  @When("ESS user adds a dependent with {string} {string} {string}")
  public void ess_user_adds_a_dependent(String name, String relationship, String dob) {
    dependentsPage.addDependent(name, relationship, dob);
  }

  @Then("Dependent should be added successfully")
  public void dependent_should_be_added_successfully() {
    assert dependentsPage.isAddSuccessful();
  }
}
