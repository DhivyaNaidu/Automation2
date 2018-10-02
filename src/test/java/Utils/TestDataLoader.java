package Utils;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TestDataLoader extends SupportUtils {

   

                public JSONObject getTestData(String testDataSheet, String dataType) {
                        JSONObject testData = null;
                        JSONObject fullDataSheet = null;
                        //System.out.println(fullDataSheet);
                        JSONParser parser = new JSONParser();

                        String fileName="";
                        File fr;
                        try {
                        	fileName = "src/test/resources/testData/" + testDataSheet + ".json";
                         fr = new File(fileName); 
                         	if (!fr.exists()) {
                         		fileName = "src/test/config/" + testDataSheet + ".json";
                                fr = new File(fileName); 
							}
                            fullDataSheet = (JSONObject) parser.parse(new FileReader(fr));
                            //System.out.println(fullDataSheet.size());
                            
                           // System.out.println("fullDataSheet: "+ fullDataSheet);
                            testData=(JSONObject) fullDataSheet.get(dataType);
                        } catch (Exception e) {
                        		
                            throw new RuntimeException("Failed to read test data from " + fileName, e);
                        }
                        return testData;
                }
                
                public JSONObject getTestData(String testDataSheet,String scenarioName , String dataType) {
                    JSONObject testData = null;
                    JSONObject fullDataSheet = null;
                    //System.out.println(fullDataSheet);
                    JSONParser parser = new JSONParser();

                    String fileName="";
                    File fr;
                    try {
                    	fileName = "src/test/resources/testData/" + testDataSheet + ".json";
                     fr = new File(fileName); 
                     	if (!fr.exists()) {
                     		fileName = "src/test/config/" + testDataSheet + ".json";
                            fr = new File(fileName); 
						}
                        fullDataSheet = (JSONObject) parser.parse(new FileReader(fr));
                        //System.out.println(fullDataSheet.size());
                        
                       // System.out.println("fullDataSheet: "+ fullDataSheet);
                        testData=(JSONObject) ((JSONObject) fullDataSheet.get(scenarioName)).get(dataType);
                    } catch (Exception e) {
                    		
                        throw new RuntimeException("Failed to read test data from " + fileName, e);
                    }
                    return testData;
            }

                
}

