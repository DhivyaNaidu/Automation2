$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featureFiles/BookingFlow.feature");
formatter.feature({
  "name": "Booking Flow",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "SC01_TC01_Verify user is able to book cruise through Jet blue application",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@JBS_SC01_TC02"
    }
  ]
});
formatter.step({
  "name": "User Launches JetBlue Application",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on Lets Cruise",
  "keyword": "When "
});
formatter.step({
  "name": "User filter cruise by\u0027\u003cCruiseline\u003e\u0027",
  "keyword": "Then "
});
formatter.step({
  "name": "User selects a cruise from search results",
  "keyword": "And "
});
formatter.step({
  "name": "User Enter the \u0027\u003cPassengerdetails\u003e\u0027",
  "keyword": "And "
});
formatter.step({
  "name": "Enters \u0027\u003cCarddetails\u003e\u0027",
  "keyword": "And "
});
formatter.step({
  "name": "User Enters \u0027\u003cBillingAddress\u003e\u0027",
  "keyword": "And "
});
formatter.step({
  "name": "Agree to terms and conditions",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify Confirmation Message",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Cruiseline",
        "Passengerdetails",
        "Carddetails",
        "BillingAddress"
      ]
    },
    {
      "cells": [
        "Cruiseline",
        "Passengerdetails",
        "Carddetails",
        "BillingAddress"
      ]
    }
  ]
});
formatter.scenario({
  "name": "SC01_TC01_Verify user is able to book cruise through Jet blue application",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@JBS_SC01_TC02"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launches JetBlue Application",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingFlowStepDef.launch_portal()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of all elements located by By.xpath: //*[@id\u003d\u0027searchSubmit\u0027] (tried for 10 second(s) with 500 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:81)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:271)\r\n\tat Utils.WebDriverUtils.isElementPresent(WebDriverUtils.java:847)\r\n\tat pageClasses.LaunchApplication.verifyUrlLoaded(LaunchApplication.java:103)\r\n\tat stepDefinitions.BookingFlowStepDef.launch_portal(BookingFlowStepDef.java:23)\r\n\tat ✽.User Launches JetBlue Application(src/test/resources/featureFiles/BookingFlow.feature:6)\r\nCaused by: org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d69.0.3497.100)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027LAPTOP-V2TG2PVB\u0027, ip: \u0027192.168.1.10\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591088 (7b2b2dca23cca0..., userDataDir: C:\\Users\\SANJAY~1\\AppData\\L...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:51115}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 69.0.3497.100, webStorageEnabled: true}\nSession ID: a6e59a87108e2b1a3e1e3e935eec36c3\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\u0027searchSubmit\u0027]}\r\n\tat sun.reflect.GeneratedConstructorAccessor11.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:346)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementsByXPath(RemoteWebDriver.java:425)\r\n\tat org.openqa.selenium.By$ByXPath.findElements(By.java:356)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:307)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElements(ExpectedConditions.java:914)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$200(ExpectedConditions.java:44)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$8.apply(ExpectedConditions.java:232)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$8.apply(ExpectedConditions.java:229)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:248)\r\n\tat Utils.WebDriverUtils.isElementPresent(WebDriverUtils.java:847)\r\n\tat pageClasses.LaunchApplication.verifyUrlLoaded(LaunchApplication.java:103)\r\n\tat stepDefinitions.BookingFlowStepDef.launch_portal(BookingFlowStepDef.java:23)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:31)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:25)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:37)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:40)\r\n\tat cucumber.api.TestStep.executeStep(TestStep.java:102)\r\n\tat cucumber.api.TestStep.run(TestStep.java:83)\r\n\tat cucumber.api.TestCase.run(TestCase.java:58)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:80)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:140)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:118)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:56)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:127)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User clicks on Lets Cruise",
  "keyword": "When "
});
formatter.match({
  "location": "BookingFlowStepDef.clickLetsCruise()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User filter cruise by\u0027Cruiseline\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingFlowStepDef.selectCruizeLine(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User selects a cruise from search results",
  "keyword": "And "
});
formatter.match({
  "location": "BookingFlowStepDef.selectCruize()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User Enter the \u0027Passengerdetails\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "BookingFlowStepDef.EnterPassengerDetails(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Enters \u0027Carddetails\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "BookingFlowStepDef.EnterCardsDetails(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User Enters \u0027BillingAddress\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "BookingFlowStepDef.EnterBillingAddress(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Agree to terms and conditions",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingFlowStepDef.termsandConditions()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify Confirmation Message",
  "keyword": "And "
});
formatter.match({
  "location": "BookingFlowStepDef.verifyconfirmationMessage()"
});
formatter.result({
  "status": "skipped"
});
});