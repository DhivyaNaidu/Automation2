package stepDefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Assert;
import org.junit.runners.model.InitializationError;

import Utils.WebDriverUtils;
import cucumber.api.Scenario;
import cucumber.api.TestStep;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.ScenarioImpl;
import cucumber.runtime.model.CucumberFeature;
import gherkin.ast.ScenarioDefinition;
import pageClasses.LaunchApplication;



public class CommonFns extends WebDriverUtils {
	
	LaunchApplication la = new LaunchApplication();

	
	
	public String scenarioName;
	
	
	@Before
	public void setUpTestData(Scenario s) throws IOException {
		ArrayList<String> tagsList = (ArrayList<String>) s.getSourceTagNames();
		stepCounter=0;
		for (String eachTagName : tagsList) {
			if (eachTagName.contains("JBS_")) {
				currentTestCaseID = eachTagName.replace("@", "").replace("JBS_", "");
			} else if (eachTagName.contains("Module")) {
				scenarioTestDataSheetName = eachTagName.replace("Module_", "").replace("@", "")+ "TestData";
			}
		}
		App_log.debug("Running Test Case With ID " + currentTestCaseID
				+ " Data will be retrieved with respect to test case ID");
		App_log.debug("Testdata sheet configured "+scenarioTestDataSheetName);
	}
	
	
	@Before
	public void getListOfStepsInCurrentScenario(Scenario s) throws FileNotFoundException {
		List<Integer> lineNumber=s.getLines();
		String featureFilePath=s.getUri();
		int lineCounter=0;
		Scanner fileScanner = new Scanner(new File(featureFilePath));
		currentScenarioStepsList=new ArrayList<String>();
		while(fileScanner.hasNextLine() && lineCounter<lineNumber.get(0)){
			if(lineCounter>=lineNumber.get(1) && lineCounter<=lineNumber.get(0)) {
				currentScenarioStepsList.add(fileScanner.nextLine().replace("'", "").replace("<", "").replace(">", ""));
				if(currentScenarioStepsList.get(currentScenarioStepsList.size()-1).trim().equalsIgnoreCase("")) {
					currentScenarioStepsList.remove(currentScenarioStepsList.size()-1);
					break;
				}
			}else {
				fileScanner.nextLine();
			}
			if(lineCounter>lineNumber.get(0)) {
				break;
			}
			lineCounter++;
		}
		for(String eachStep:currentScenarioStepsList) {
			App_log.debug("Step ==>"+eachStep);
		}
		System.out.println("Debugger");
	}

	}

