package com.kun.tests.restapi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static org.testng.Assert.assertTrue;

/**
 * ClassName: RestApiTest
 * Package: com.kun.tests.restapi
 * Description:
 *
 * @Author KunJiang
 * @Create 11/26/24 2:08 PM
 * @Version 1.0
 */

public class RestApiTest {
    private String apiUrl;
    private String jsonInput;

    @BeforeMethod
    public void setUp() {
        apiUrl = "https://reqres.in/api/users";
        jsonInput = readJsonFromFile("src/test/resources/requestData.json");
        if (jsonInput == null) {
            System.out.println("Error reading JSON file.");
        }
        System.out.println("test setup");
    }

    @Test
    public void testPostRequest() {
        if (jsonInput != null) {
            // execute post request
            try {
                String response = executePostRequest(apiUrl, jsonInput);

                // check result
                assertTrue(response.contains("John"), "Expected 'John' in response");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tear down, test is completed!");
    }

    // 执行 execute post request
    private String executePostRequest(String apiUrl, String jsonInput) throws Exception {
        // create url object
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // set requestMethod to post
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        // send request information
        try (OutputStream os = connection.getOutputStream()) {
            os.write(jsonInput.getBytes());
            os.flush();
        }

        // read response
        Scanner scanner = new Scanner(connection.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return response.toString();
    }

    //read from json file
    private String readJsonFromFile(String filePath) {
        StringBuilder jsonContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonContent.toString();
    }
}
