package pages;

import org.openqa.selenium.By;

public class EmployeeListPage extends BasePage {

  By pimMenu = By.xpath("//span[normalize-space()='PIM']");
  By employeeListMenu = By.xpath("//a[normalize-space()='Employee List']");

  By empNameInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
  By empIdInput = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");

  By searchBtn = By.xpath("//button[@type='submit']");

  By noRecordsMsg = By.xpath("//p[normalize-space()='No Records Found']");

  public void goToEmployeeList() {
    click(pimMenu);
    click(employeeListMenu);
  }

  public void searchByName(String name) {
    sendText(empNameInput, name);
    click(searchBtn);
  }

  public void searchById(String id) {
    sendText(empIdInput, id);
    click(searchBtn);
  }

  public boolean isEmployeeDisplayedByName(String name) {
    String[] parts = name.split(" ");
    By empNameInTable = By.xpath(
            "//div[@role='row'][.//div[normalize-space()='" + parts[0] + "'] and .//div[normalize-space()='" + parts[1] + "']]"
    );
    return waitForVisibility(empNameInTable).isDisplayed();
  }

  public boolean isEmployeeDisplayedById(String id) {
    By empIdInTable = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']/div[normalize-space(.)='" + id + "']");
    return waitForVisibility(empIdInTable).isDisplayed();
  }

  public boolean isNoRecordsMessageDisplayed() {
    return waitForVisibility(noRecordsMsg).isDisplayed();
  }
}
