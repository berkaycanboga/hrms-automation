package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.Driver;

public class BaseTest {

  @Before
  public void setUp() {
    Driver.getDriver().get(ConfigReader.getProperty("url"));
  }

  @After
  public void tearDown() {
    Driver.quitDriver();
  }
}
