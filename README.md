Java-Cucumber
======
Test automation skeleton for java-cucumber

Resources
---
- [Cucumber-JVM](https://cucumber.io/docs/reference/jvm)
- [Cucumber-JVM API](http://cucumber.github.io/api/cucumber/jvm/javadoc/)
- [Appium](http://appium.io/)
- [Appium Touch Actions](http://appium.io/docs/en/writing-running-appium/touch-actions/)
- [Appium Touch Actions Through Scripts](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/ios/ios-xctest-mobile-gestures.md)
- [Appium client API](http://appium.github.io/java-client/)
- [Appium capabilities](http://appium.io/docs/en/writing-running-appium/caps/)
- [Android Emulator](https://developer.android.com/studio/run/emulator)
- [ADB](https://developer.android.com/studio/command-line/adb)

Setup
---

**Install** [Android SDK](https://developer.android.com/studio/#downloads)
\
`Create new Android Studio Project` with `default settings` from `API 23(Or Desired API)` and `No Activity`. Continue to import and install any settings suggested by the SDK. 

**Install** [IntelliJ](https://www.jetbrains.com/idea/download):
\
Install cucumber plugin
_`Preferences`_ > _`Plugins`_ > _`Cucumber for Java`_
    
**Download** [Appium Desktop](https://github.com/appium/appium-desktop): 
\
This is what we will use to inspect the devices.

Environment variables
---
**We will use npm to install needed packages:**
[install _current_ Node.js](https://nodejs.org/en/)

#### Windows OS:
NOTE: Unable to run iOS on windows\

**Input command lines into powershell**\
_restart pc if npm is not found_
* `npm install npm@latest -g`
* `npm install appium@latest -g`
* `npm install selenium-standalone@latest -g`
* `selenium-standalone install`

**Set windows variables:**
1. open _powershell as admin_ > enter `rundll32 sysdm.cpl,EditEnvironmentVariables` to open windows variables
2. set the following for `SYSTEM VARIABLES`
```
Variable name -> JAVA_HOME
Variable path -> path\to\javaSDK
```
* set the following for `USER VARIABLES`
```
Variable name -> ANDROID_HOME
Variable path -> path\to\androidSDK
```
3. Select `Path` in `SYSTEM Variables` and click `Edit` then click `New` and enter the following for the variables created:
 ```
%JAVA_HOME%\bin
```
4. Select `Path` in `USER Variables` and click `Edit` then click `New` and enter the following for the variables created:
 ```
%ANDROID_HOME%\emulator
%ANDROID_HOME%\tools
%ANDROID_HOME%\platform-tools
```
    
Usage:
---
#### **Local**
- Start Appium Session
    - Install server dependencies:`$ npm install`
    - Start Appium:`$ appium` or `Start Server in Appium Desktop`
- Start Selenium Session
    - Install Selenium: `$ selenium-standalone install`
    - Start Selenium: `$ selenium-standalone start`
    
App Setup
----
- iOS & Android
    - for local runs create `apps` folder in project directory and move app to newly created folder
        - example `/your/path/to/PROJECT_Folder/apps/put app here`
        - note: if we get a downladable app link for the app this is no longer needed. 
        
Emulator/Simulator Setup
----
- Android
    - Create with Android Studio  
        - Open `Android Studio` and use previously created project 
            - `Tools` > `AVD Manager` > `Create Virtual Device` > Create emulator with needed settings

Appium Inspector Setup
----
1. With the appium server started from terminal or through appium desktop
    - `$ appium` in terminal, or select `Start Sever Version` in appium desktop
    - We will need to startup the emulator for android`$ emulator -avd DEVICE_ID_HERE`
2. Click `Search Icon` in top right
3. Make sure `Automatic Server` is selected to connect to the appium sessions
4. Under `Desired Capabilities` you will enter the following to get an inspector sessions started
    - NOTE: look at the appium desired capabilities resource linked above for more info

#### iOS capabilities example

Name           | Type   | Value
:---:          | :---:  | :---:
platformName   | text   | iOS
platformVersion| text   | 12.1
deviceName     | text   | iPhone X
app            | text   | path/to/app
automationName | text   | XCUITest
noReset        | boolean| true
    
#### Android capabilities example

Name          | Type   | Value
:---:         | :---:  | :---:
platformName  | text   | android
deviceName    | text   | emulator-5554
app           | text   | path/to/app
automationName| text   | uiautomator2
noReset       | boolean| true
    
#### Example of how the JSON will look:  

    {
      "platformName": "iOS",
      "platformVersion": "12.1",
      "deviceName": "iPhone X",
      "app": "/your/path/to/projectNameHERE/apps/appHere",
      "automationName": "XCUITest",
      "noReset": true
    }
   
Running tests
----  
**IntelliJ**
\
Create a run configuration. This will allow you to run Scenarios by right clicking them and selecting run in IntelliJ   
- Create new Cucumber Java run configuration: `Run` > `Edit Configurations`
    - Main class: `cucumber.api.cli.Main`
    - Glue: `core.utilities.setup cucumber.steps`
    - Feature or folder path: `/path/to/features` 
        - Example `/Users/your_username/project_name/src/test/resources/features`

We can also use program arguments to get screenshots or to only run specific tests  
- Example
    ```
     --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvm4SMFormatter --plugin html:target/cucumber-report/cucumber.html --monochrome --tags @TagsYouWantToRun
    ```
Note: *iOS sim must have `connect hardware keyboard` off.*

**Android CheatSheet**
----  
- To see [adb command options](https://developer.android.com/studio/command-line/adb): `$ adb help`
    - Shows List of Connected Devices:`$ adb devices` 
    - Commands For Specific Device: `$ adb -s DEVICE_ID_HERE`
- To see [emulator command options](https://developer.android.com/studio/run/emulator-commandline)`$ emulator -help`
    - List Emulators on Current Device: `$ emulator list-avds `
    - Start and run emulator: `$ emulator -avd DEVICE_ID_HERE` 
     