package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import utils.Driver;

public class Hooks {

  @Before
  public void setUp() {
    Driver.getDriver();
  }

  @AfterStep
  public void takeScreenshotOnFailure(Scenario scenario) {
    if (scenario.isFailed()) {
      final byte[] screenshot =
              ((TakesScreenshot) Driver.getDriver())
                      .getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
    }
  }

  @After
  public void tearDown() {
    Driver.quitDriver();
  }
}
