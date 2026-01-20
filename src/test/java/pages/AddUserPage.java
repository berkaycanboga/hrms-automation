package pages;

import org.openqa.selenium.By;

public class AddUserPage extends BasePage {

  By adminMenu = By.xpath("//span[normalize-space()='Admin']");

  By userManagement = By.xpath(
          "//span[contains(@class,'oxd-topbar-body-nav-tab-item') and contains(normalize-space(.),'User Management')]"
  );

  By usersMenu = By.xpath(
          "//a[contains(@class,'oxd-topbar-body-nav-tab-link') and normalize-space(.)='Users']"
  );

  By addBtn = By.xpath("//button[.//i[contains(@class,'bi-plus')]]");

  By userRoleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
  By essOption = By.xpath("//span[normalize-space()='ESS']");

  By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
  By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
  By enabledOption = By.xpath("//span[normalize-space()='Enabled']");

  By usernameInput = By.xpath("//label[text()='Username']/../following-sibling::div/input");
  By passwordInput = By.xpath("//label[text()='Password']/../following-sibling::div/input");
  By confirmPasswordInput = By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input");

  By saveBtn = By.xpath("//button[@type='submit']");
  By successToast = By.xpath("//p[normalize-space()='Successfully Saved']");

  public void goToAddUserPage() {
    waitForClickability(adminMenu).click();

    waitForClickability(userManagement).click();

    waitForClickability(usersMenu).click();
    waitForClickability(addBtn).click();
  }

  public void fillUserForm(String empName, String username, String password) {
    waitForClickability(userRoleDropdown).click();
    waitForClickability(essOption).click();

    waitForVisibility(employeeNameInput).sendKeys(empName);
    waitForVisibility(By.xpath("//span[contains(normalize-space(.),'" + empName + "')]")).click();

    waitForClickability(statusDropdown).click();
    waitForClickability(enabledOption).click();

    waitForVisibility(usernameInput).sendKeys(username);
    waitForVisibility(passwordInput).sendKeys(password);
    waitForVisibility(confirmPasswordInput).sendKeys(password);
  }

  public void saveUser() {
    waitForClickability(saveBtn).click();
  }

  public boolean isUserCreated() {
    return waitForVisibility(successToast).isDisplayed();
  }
}
