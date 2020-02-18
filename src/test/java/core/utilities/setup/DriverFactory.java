package core.utilities.setup;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DriverFactory {
    private final URL url;
    private final DesiredCapabilities capabilities;

    public DriverFactory(String url, Map<String, Object> map) throws MalformedURLException {
        this.url = new URL(url);
        this.capabilities = new DesiredCapabilities(map);
    }

    RemoteWebDriver createDriver(String platform) {
        switch (platform.toUpperCase()) {
            case "ANDROID":
                DesiredCapabilities androidCaps = new DesiredCapabilities();
                androidCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                androidCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
                androidCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                androidCaps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                androidCaps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

                return new AndroidDriver<MobileElement>(url, androidCaps);
            case "IOS":
                return new IOSDriver<MobileElement>(url, capabilities);
            case "WEB":
                return new RemoteWebDriver(url, capabilities);
            default:
                throw new IllegalArgumentException(String.format("Driver Factory type not implemented: [%s]", platform));
        }
    }
}
