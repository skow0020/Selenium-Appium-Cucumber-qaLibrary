package core.utilities.setup;

import core.data.TestData;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class Hooks {
    private DriverFactory factory;
    private static RemoteWebDriver driver;
    private static Config config = new Config();
    private static TestData testData;
    private static SoftAssertions softAssert;
    private static Scenario currentScenario;

    public static SoftAssertions getSoftAssert() {
        return softAssert;
    }

    public static TestData getTestData() {
        return testData;
    }

    public static void setTestData(TestData newTestData) {
        testData = newTestData;
    }

    public Hooks() {
        softAssert = new SoftAssertions();
    }

    public static RemoteWebDriver getDriver() {
        return driver;
    }

    public static Config getConfigInfo() {
        return config;
    }

    @Before(order = 1)
    public void beforeAll() throws MalformedURLException {
        if (factory == null) {
            factory = new DriverFactory(config.getUrl(), config.getCapabilities());
        }

        setTestData(new TestData(Config.USER));

        driver = factory.createDriver(config.getPlatform());
    }

    @Before("@Web")
    public void beforeWeb() {
        driver.get(Config.env);
    }

    @After(order = 1)
    public void afterAll(Scenario scenario) {
        try {
            if (scenario.isFailed()) embedScreenshot();
            if (!softAssert.errorsCollected().isEmpty()) softAssert.assertAll();

        } finally {
            if (driver != null) driver.quit();
        }
    }

    public static void embedScreenshot() {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            currentScenario.embed(screenshot, "image/png");
        } catch (WebDriverException | NullPointerException e) {
            System.out.println("Failed to take embed Screenshot");
        }
    }
}
