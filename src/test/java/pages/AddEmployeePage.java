package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployeePage extends BasePage {

  By pimMenu = By.xpath("//span[normalize-space()='PIM']");

  By addEmployeeBtn = By.xpath("//button[contains(.,'Add')]");

  By firstName = By.name("firstName");
  By lastName = By.name("lastName");

  By saveBtn = By.xpath("//button[@type='submit']");

  By personalDetailsHeader = By.xpath("//h6[normalize-space()='Personal Details']");

  public void goToAddEmployee() {
    waitForClickability(pimMenu).click();
    waitForClickability(addEmployeeBtn).click();
  }

  public void enterEmployeeName(String fName, String lName) {
    waitForVisibility(firstName).sendKeys(fName);
    waitForVisibility(lastName).sendKeys(lName);
  }

  public void saveEmployee() {
    waitForClickability(saveBtn).click();
  }

  public boolean isEmployeeSaved() {
    WebElement header = waitForVisibility(personalDetailsHeader);
    return header.isDisplayed();
  }
}
