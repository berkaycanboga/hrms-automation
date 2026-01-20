package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsPage extends BasePage {

  By pimMenu = By.xpath("//span[normalize-space()='PIM']");
  By employeeListMenu = By.xpath("//a[normalize-space()='Employee List']");
  By empNameInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
  By searchBtn = By.xpath("//button[@type='submit']");
  By contactDetailsTab = By.xpath("//a[normalize-space()='Contact Details']");
  By contactDetailsSection = By.xpath("//h6[text()='Contact Details']");
  By saveBtn = By.xpath("//button[@type='submit']");
  By successToast = By.xpath("//p[normalize-space()='Successfully Updated']");
  By formLoader = By.cssSelector("div.oxd-form-loader");

  By addressStreet1Input = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Street 1']]//input");
  By addressStreet2Input = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Street 2']]//input");
  By cityInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='City']]//input");
  By stateInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[contains(text(),'State')]]//input");
  By zipCodeInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[contains(text(),'Zip')]]//input");
  By countryDropdown = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Country']]//div[contains(@class,'oxd-select-text')]");
  By homePhoneInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Home']]//input");
  By mobilePhoneInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Mobile']]//input");
  By workPhoneInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Work']]//input");
  By workEmailInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Work Email']]//input");
  By otherEmailInput = By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Other Email']]//input");

  public void goToContactDetailsOf(String employeeName) {
    click(pimMenu);
    click(employeeListMenu);

    sendText(empNameInput, employeeName);
    click(searchBtn);

    By empRowDynamic = By.xpath(
            "//div[@role='row'][.//div[normalize-space()='" + employeeName.split(" ")[0] + "'] " +
                    "and .//div[normalize-space()='" + employeeName.split(" ")[1] + "']]"
    );
    waitForClickability(empRowDynamic).click();
    waitForClickability(contactDetailsTab).click();
    waitForVisibility(contactDetailsSection);
  }

  public boolean isContactDetailsPageDisplayed() {
    return waitForVisibility(contactDetailsSection).isDisplayed();
  }

  public void waitForLoaderToDisappear() {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
  }

  public void editContactDetails(String addressStreet1, String addressStreet2, String city,
                                 String state, String zipCode, String country,
                                 String homePhone, String mobilePhone, String workPhone,
                                 String workEmail, String otherEmail) {

    waitForLoaderToDisappear();

    safeInput(addressStreet1Input, addressStreet1);
    safeInput(addressStreet2Input, addressStreet2);
    safeInput(cityInput, city);
    safeInput(stateInput, state);
    safeInput(zipCodeInput, zipCode);

    waitForClickability(countryDropdown).click();
    waitForClickability(By.xpath("//span[text()='" + country + "']")).click();

    safeInput(homePhoneInput, homePhone);
    safeInput(mobilePhoneInput, mobilePhone);
    safeInput(workPhoneInput, workPhone);

    String uniqueSuffix = System.currentTimeMillis() % 10000 + "";
    safeInput(workEmailInput, appendEmailSuffix(workEmail, uniqueSuffix));
    safeInput(otherEmailInput, appendEmailSuffix(otherEmail, uniqueSuffix));

    waitForClickability(saveBtn).click();
    waitForLoaderToDisappear();
  }

  public boolean isUpdateSuccessful() {
    return waitForVisibility(successToast).isDisplayed();
  }

  private void safeInput(By locator, String text) {
    WebElement element = waitForClickability(locator);
    element.click();
    element.clear();
    element.sendKeys(text);
  }

  private String appendEmailSuffix(String email, String suffix) {
    if (email.contains("@")) {
      String[] parts = email.split("@");
      return parts[0] + suffix + "@" + parts[1];
    } else {
      return email + suffix;
    }
  }
}
