package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.nio.file.Paths;

public class ProfilePicturePage extends BasePage {

  By pimMenu = By.xpath("//span[normalize-space()='PIM']");
  By employeeListMenu = By.xpath("//a[normalize-space()='Employee List']");
  By empNameInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
  By searchBtn = By.xpath("//button[@type='submit']");

  By profileImage = By.cssSelector(".orangehrm-edit-employee-image-wrapper");
  By addImageButton = By.cssSelector("button.employee-image-action");
  By fileInput = By.cssSelector("input[type='file']");
  By saveBtn = By.xpath("//button[@type='submit']");
  By successToast = By.xpath("//p[normalize-space()='Successfully Updated']");
  By formLoader = By.cssSelector("div.oxd-form-loader");

  public void goToProfilePictureOf(String employeeName) {
    click(pimMenu);
    click(employeeListMenu);

    sendText(empNameInput, employeeName);
    click(searchBtn);

    By empRowDynamic = By.xpath("//div[@role='row'][.//div[normalize-space()='" +
            employeeName.split(" ")[0] + "'] and .//div[normalize-space()='" +
            employeeName.split(" ")[1] + "']]");
    waitForClickability(empRowDynamic).click();

    waitForVisibility(profileImage);
    click(profileImage);
  }

  public boolean isProfilePictureSectionDisplayed() {
    return waitForVisibility(profileImage).isDisplayed();
  }

  public void uploadProfilePicture(String relativePathToResources) {
    File file = Paths.get(relativePathToResources).toAbsolutePath().toFile();
    String imagePath = file.getAbsolutePath();

    waitForClickability(addImageButton).click();

    WebElement input = waitForVisibility(fileInput);
    input.sendKeys(imagePath);

    waitForClickability(saveBtn).click();
  }

  public boolean isUploadSuccessful() {
    waitForLoaderToDisappear();
    return waitForVisibility(successToast).isDisplayed();
  }

  public void waitForLoaderToDisappear() {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
  }
}
