package steps;

import io.cucumber.java.en.*;
import pages.ContactDetailsPage;

public class ContactDetailsSteps {

  ContactDetailsPage contactDetailsPage = new ContactDetailsPage();

  @When("ESS user navigates to Contact Details of {string}")
  public void ess_user_navigates_to_contact_details_of(String employeeName) {
    contactDetailsPage.goToContactDetailsOf(employeeName);
  }

  @Then("Contact Details page should be displayed")
  public void contact_details_page_should_be_displayed() {
    assert contactDetailsPage.isContactDetailsPageDisplayed();
  }

  @When("ESS user updates contact details with {string} {string} {string} {string} {string} {string} {string} {string} {string}")
  public void ess_user_updates_contact_details(String addressStreet1, String addressStreet2,
                                               String city, String state, String zipCode,
                                               String country, String homePhone,
                                               String mobilePhone, String workPhone) {
    contactDetailsPage.editContactDetails(
            addressStreet1, addressStreet2, city, state, zipCode,
            country, homePhone, mobilePhone, workPhone
    );
  }

  @Then("contact details should be updated successfully")
  public void contact_details_should_be_updated_successfully() {
    assert contactDetailsPage.isUpdateSuccessful();
  }
}
