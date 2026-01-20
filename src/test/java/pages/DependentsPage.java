package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DependentsPage extends BasePage {

  By pimMenu = By.xpath("//span[normalize-space()='PIM']");
  By employeeListMenu = By.xpath("//a[normalize-space()='Employee List']");
  By empNameInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
  By searchBtn = By.xpath("//button[@type='submit']");

  By dependentsTab = By.xpath("//a[normalize-space()='Dependents']");

  By dependentsSection = By.xpath("//h6[normalize-space()='Assigned Dependents']");
  By addButton = By.xpath("//button[.//i[contains(@class,'bi-plus')]]");

  By saveBtn = By.xpath("//button[@type='submit']");
  By successToast = By.xpath("//p[normalize-space()='Successfully Saved']");

  public void goToDependentsOf(String employeeName) {
    click(pimMenu);
    click(employeeListMenu);

    sendText(empNameInput, employeeName);
    click(searchBtn);

    By empRowDynamic = By.xpath("//div[@role='row'][.//div[normalize-space()='" +
            employeeName.split(" ")[0] + "'] and .//div[normalize-space()='" +
            employeeName.split(" ")[1] + "']]");
    waitForClickability(empRowDynamic).click();

    waitForClickability(dependentsTab).click();
    waitForVisibility(dependentsSection);
  }

  public boolean isDependentsSectionDisplayed() {
    return waitForVisibility(dependentsSection).isDisplayed();
  }

  public void addDependent(String name, String relationship, String dob) {
    waitForClickability(addButton).click();

    WebElement nameField = waitForVisibility(By.xpath("//label[text()='Name']/../following-sibling::div//input"));
    nameField.clear();
    nameField.sendKeys(name);

    WebElement relationshipField = waitForClickability(By.xpath("//label[text()='Relationship']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]"));
    relationshipField.click();
    waitForClickability(By.xpath("//span[text()='" + relationship + "']")).click();

    WebElement dobField = waitForVisibility(By.xpath("//label[text()='Date of Birth']/../following-sibling::div//input[@placeholder='yyyy-mm-dd']"));
    dobField.clear();
    dobField.sendKeys(dob);

    waitForClickability(saveBtn).click();
  }

  public boolean isAddSuccessful() {
    return waitForVisibility(successToast).isDisplayed();
  }
}
