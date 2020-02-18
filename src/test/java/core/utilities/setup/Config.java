package core.utilities.setup;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.NotFoundException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;

public class Config {
    public static final String WORKSPACE = getProperty("user.dir");
    public static String env = getProperty("env", "https://qa-library-dev.herokuapp.com/");
    public static final String USER = getProperty("user", "user1");

    private String platform;
    private String deviceName;
    private String url;
    private Map<String, Object> capabilities;

    private boolean isAndroid;
    private boolean isIos;
    private boolean isWeb;
    private boolean isMobile;

    public Config() {
        Logger.getLogger("org.openqa.core.remote").setLevel(Level.ALL);
        // set platform property to -> Android, iOS, or Web
        platform = getProperty("platform", "Android");
        setCapabilitiesForPlatform(platform);
    }

    String getPlatform() {
        return platform;
    }

    public Map<String, Object> getCapabilities() {
        return capabilities;
    }

    public boolean isAndroid() {
        return isAndroid;
    }

    public boolean isIos() {
        return isIos;
    }

    public boolean isWeb() {
        return isWeb;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public String getUrl() {
        return url;
    }

    public static String getEnv() {
        return env;
    }

    private void setCapabilitiesForPlatform(String platform) {
        isAndroid = platform.equalsIgnoreCase("Android");
        isIos = platform.equalsIgnoreCase("iOS");
        isWeb = platform.equalsIgnoreCase("Web");
        isMobile = isAndroid || isIos;

        if (isAndroid) setAndroidCapabilities();
        else if (isIos) setIosCapabilities();
        else if (isWeb) setWebCapabilities();
        else throw new NotFoundException("Platform not set");
    }

    private void setIosCapabilities() {
        deviceName = getProperty("deviceName", "iPhone x");
        url = getProperty("seleniumGrid", "http://0.0.0.0:4723/wd/hub");

        capabilities = getDeviceCapabilities(deviceName);
        capabilities.put("app", Paths.get(WORKSPACE, "apps", "appHere").toString());
        capabilities.put("platformName", "iOS");
        capabilities.put("automationName", "XCUITest");
        capabilities.put("xcodeOrgId", getProperty("xcodeOrgId", "ID_HERE"));
        capabilities.put("xcodeSigningId", getProperty("xcodeSigningId", "iPhone Developer"));
    }

    // NOTE
  /* use -> capabilities.put("app", Paths.get(WORKSPACE, "createAppFolderInProject", "appInFolderHere").toString()); <-
  /* instead of [appPackage], [appActivity] you have an app to use */
    private void setAndroidCapabilities() {
        deviceName = getProperty("deviceName", "emulator-5554");
        url = getProperty("seleniumGrid", "http://0.0.0.0:4723/wd/hub");

        capabilities = getDeviceCapabilities(deviceName);
        capabilities.put("appPackage", "com.android.chrome");
        capabilities.put("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.put("platformName", "Android");
        capabilities.put("automationName", "UiAutomator2");
        capabilities.put("systemPort", parseInt(getProperty("systemPort", "8200")));
        capabilities.put("autoGrantPermissions", true);
    }

    private void setWebCapabilities() {
        deviceName = getProperty("deviceName", "chrome");
        url = getProperty("seleniumGrid", "http://0.0.0.0:4444/wd/hub");

        capabilities = getDeviceCapabilities(deviceName);
    }

    private HashMap<String, Object> getDeviceCapabilities(String device) {
        InputStream file = getClass().getResourceAsStream("/jsonData/devices.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        Type hashType = new TypeToken<HashMap<String, Object>>() {}.getType();
        JsonElement jsonElement = new JsonParser().parse(reader).getAsJsonObject().get(device);
        return new Gson().fromJson(jsonElement, hashType);
    }
}
