package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.nio.file.Paths;

public class ProfilePicturePage extends BasePage {
  By pimMenu = By.xpath("//span[normalize-space()='PIM']");
  By employeeListMenu = By.xpath("//a[normalize-space()='Employee List']");
  By empNameInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
  By searchBtn = By.xpath("//button[@type='submit']");
  By profileImage = By.cssSelector(".orangehrm-edit-employee-image-wrapper");
  By fileInput = By.cssSelector("input[type='file']");
  By saveBtn = By.xpath("//button[@type='submit']");
  By successToast = By.xpath("//p[normalize-space()='Successfully Updated']");
  By formLoader = By.cssSelector("div.oxd-form-loader");

  public void goToProfilePictureOf(String employeeName) {
    click(pimMenu);
    click(employeeListMenu);
    sendText(empNameInput, employeeName);
    click(searchBtn);
    By empRowDynamic = By.xpath("//div[@role='row'][.//div[normalize-space()='" + employeeName.split(" ")[0] + "'] and .//div[normalize-space()='" + employeeName.split(" ")[1] + "']]");
    waitForClickability(empRowDynamic).click();
    waitForVisibility(profileImage);
    click(profileImage);
  }

  public boolean isProfilePictureSectionDisplayed() {
    return waitForVisibility(profileImage).isDisplayed();
  }

  public void uploadProfilePicture() {
    String relativePath = "src/test/resources/images/testpic.png";
    File file = Paths.get(relativePath).toAbsolutePath().toFile();
    String imagePath = file.getAbsolutePath();
    WebElement input = driver.findElement(fileInput);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].style.display='block'; arguments[0].style.opacity=1;", input);
    input.sendKeys(imagePath);
    waitForClickability(saveBtn).click();
  }

  public void waitForLoaderToDisappear() {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
  }
}