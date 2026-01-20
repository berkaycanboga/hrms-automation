package steps;

import io.cucumber.java.en.*;
import pages.ProfilePicturePage;
import pages.LoginPage;
import utils.ConfigReader;

public class ProfilePictureSteps {

  LoginPage loginPage = new LoginPage();
  ProfilePicturePage profilePage = new ProfilePicturePage();

  @Given("ESS user is logged in for profile picture upload")
  public void ess_user_logged_in_for_profile_picture() {
    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
    );
  }

  @When("ESS user navigates to profile picture of {string}")
  public void ess_user_navigates_to_profile_picture(String employeeName) {
    profilePage.goToProfilePictureOf(employeeName);
  }

  @Then("Profile picture section should be displayed")
  public void profile_picture_section_displayed() {
    assert profilePage.isProfilePictureSectionDisplayed();
  }

  @When("ESS user uploads a profile picture")
  public void ess_user_uploads_profile_picture() {
    profilePage.uploadProfilePicture();
  }
}
