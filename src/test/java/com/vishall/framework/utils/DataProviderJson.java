package com.vishall.framework.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProviderJson {
    //Json data provider for TestNG
    public static Object[][] jsonforHashMapCOnversionTestNG(String fileLocation) throws IOException {
        String jsonDataProviderFileForTestNG = FileUtils.readFileToString(new File(System.getProperty("user.dir")+fileLocation)
                , StandardCharsets.UTF_8);
        //objectMapper is a class from JacksonBind
        ObjectMapper om = new ObjectMapper();

        //Converts the string to a List of HashMap of strings.
        List<HashMap<String, String>> testData= om.readValue(jsonDataProviderFileForTestNG, new TypeReference<List<HashMap<String, String>>>() {});
        // SIMULATION of how List<HashMap<String, String>> would hold the data:
        // testData is a List with size = 3
        // testData.get(0) = { "username":"alice@example.com", "password":"alice@123", "role":"admin", "rememberMe":"true" }
        // testData.get(1) = { "username":"bob@example.com",   "password":"bob@123",   "role":"user",  "rememberMe":"false" }
        // testData.get(2) = { "username":"charlie@example.com","password":"charlie@123","role":"auditor","rememberMe":"true" }


        //object type array
        //returnData is sized [number_of_test_cases][1]. Each row holds one HashMap<String, String> representing the key–value data for that test case
        //The second dimension is 1 because the test method expects a single argument
        Object[][] returnData = new Object[testData.size()][1];
        // SIMULATION of how the above Object array holds each set of test data:
        // testData.size() = 3
        // returnData is now an Object[3][1]
        // For now, the Object array is empty as shown below:
        // returnData[0][0] = null
        // returnData[1][0] = null
        // returnData[2][0] = null

        //Now, we loop through the List<HashMap<String,String>>
        //Each iteration picks up one HashMap<String, String> from the list ie.,testData.get(i)
        // and saves it in returnData[i][0]
        for (int i =0;i<testData.size();i++){
            returnData[i][0]= testData.get(i);
        }
        // SIMULATION after the loop:
        // i = 0: returnData[0][0] = testData.get(0)  // Alice's map
        // i = 1: returnData[1][0] = testData.get(1)  // Bob's map
        // i = 2: returnData[2][0] = testData.get(2)  // Charlie's ma

        return returnData;
        // Final state:
        // returnData = [
        //   [ {username=alice@example.com, password=alice@123, role=admin,  rememberMe=true} ],
        //   [ {username=bob@example.com,   password=bob@123,   role=user,   rememberMe=false} ],
        //   [ {username=charlie@example.com,password=charlie@123,role=auditor,rememberMe=true} ]
        // ]

    }

    //Json data provider for Cucumber
    public static Map<String, Map<String, String>> jsonforHashMapCOnversionCucumber(String fileLocation) throws IOException {
        String l = FileUtils.readFileToString(new File(System.getProperty("user.dir")+fileLocation), StandardCharsets.UTF_8);
        ObjectMapper ojm = new ObjectMapper();
        Map<String, Map<String, String>> returnCucumberData = ojm.readValue(l, new TypeReference<Map<String, Map<String, String>>>() {});
        return returnCucumberData;
    }
}