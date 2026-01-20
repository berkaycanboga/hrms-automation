package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalDetailsPage extends BasePage {

  By pimMenu = By.xpath("//span[normalize-space()='PIM']");
  By personalDetailsSection = By.xpath("//h6[text()='Personal Details']");

  By firstNameInput = By.name("firstName");
  By middleNameInput = By.name("middleName");
  By lastNameInput = By.name("lastName");

  By maleRadio = By.xpath("//div[contains(@class,'--gender-grouped-field')]//label[contains(.,'Male')]/span");
  By femaleRadio = By.xpath("//div[contains(@class,'--gender-grouped-field')]//label[contains(.,'Female')]/span");

  By nationalityDropdown = By.xpath("//label[text()='Nationality']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
  By maritalStatusDropdown = By.xpath("//label[text()='Marital Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");

  By saveBtn = By.xpath("//button[@type='submit']");
  By successToast = By.xpath("//p[normalize-space()='Successfully Updated']");
  By formLoader = By.cssSelector("div.oxd-form-loader");

  public void goToPersonalDetails() {
    waitForClickability(pimMenu).click();
    waitForVisibility(personalDetailsSection);
  }

  public boolean isPersonalDetailsPageDisplayed() {
    return waitForVisibility(personalDetailsSection).isDisplayed();
  }

  public void waitForLoaderToDisappear() {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
  }

  public void editPersonalDetails(String firstName, String middleName, String lastName,
                                  String gender, String nationality, String maritalStatus) {

    // Wait until inputs are clickable
    WebElement firstNameEl = waitForClickability(firstNameInput);
    WebElement middleNameEl = waitForClickability(middleNameInput);
    WebElement lastNameEl = waitForClickability(lastNameInput);

    // Clear + sendKeys
    firstNameEl.clear();
    firstNameEl.sendKeys(firstName);

    middleNameEl.clear();
    middleNameEl.sendKeys(middleName);

    lastNameEl.clear();
    lastNameEl.sendKeys(lastName);

    waitForLoaderToDisappear();

    // Gender selection
    if (gender.equalsIgnoreCase("Male")) {
      waitForClickability(maleRadio).click();
    } else if (gender.equalsIgnoreCase("Female")) {
      waitForClickability(femaleRadio).click();
    }

    // Dropdowns
    waitForClickability(nationalityDropdown).click();
    waitForClickability(By.xpath("//span[text()='" + nationality + "']")).click();

    waitForClickability(maritalStatusDropdown).click();
    waitForClickability(By.xpath("//span[text()='" + maritalStatus + "']")).click();

    // Save
    waitForClickability(saveBtn).click();
  }

  public boolean isUpdateSuccessful() {
    return waitForVisibility(successToast).isDisplayed();
  }
}
