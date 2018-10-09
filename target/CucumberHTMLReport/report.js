$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featureFiles/BookingFlow.feature");
formatter.feature({
  "name": "Booking Flow",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "SC01_TC02_Verify user is able to book cruise through Jet blue application",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@JBS_SC01_TC01"
    }
  ]
});
formatter.step({
  "name": "User Launches JetBlue Application",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on I am feeling Lucky",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Google",
        "lucky"
      ]
    },
    {
      "cells": [
        "Google",
        "lucky"
      ]
    }
  ]
});
formatter.scenario({
  "name": "SC01_TC02_Verify user is able to book cruise through Jet blue application",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@JBS_SC01_TC01"
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
  "status": "passed"
});
formatter.step({
  "name": "User clicks on I am feeling Lucky",
  "keyword": "When "
});
formatter.match({
  "location": "BookingFlowStepDef.clickLetsCruise()"
});
formatter.result({
  "status": "passed"
});
});