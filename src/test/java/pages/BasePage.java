package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public abstract class BasePage {

  public WebDriver driver = Driver.getDriver();
  protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  public WebElement waitForVisibility(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected WebElement waitForClickability(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void jsClick(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
  }

  protected void hover(By locator) {
    WebElement element = waitForVisibility(locator);
    Actions actions = new Actions(driver);
    actions.moveToElement(element).perform();
  }

  protected void sendText(By locator, String text) {
    WebElement el = waitForVisibility(locator);
    el.clear();
    el.sendKeys(text);
  }

  protected void click(By locator) {
    waitForClickability(locator).click();
  }
}
