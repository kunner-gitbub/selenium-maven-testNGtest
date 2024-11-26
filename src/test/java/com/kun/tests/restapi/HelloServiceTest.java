package com.kun.tests.restapi;

/**
 * ClassName: HelloServiceTest
 * Package: com.kun.tests.restapi
 * Description:
 *
 * @Author KunJiang
 * @Create 11/26/24 12:14 PM
 * @Version 1.0
 */

import com.kun.restapi.HelloService;
import org.testng.annotations.Test;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HelloServiceTest {

    @Test
    public void testSendPost() {
        // Arrange
        HelloService helloService = new HelloService();
        Map<String, String> input = new HashMap<>();
        input.put("name", "morpheus");
        input.put("job", "leader");

        // Act
        Response response = helloService.sendPost(input);

        // Assert
        assertEquals(response.getStatus(), 201, "Response status code should be 201");
        String jsonResponse = response.getEntity().toString();
        System.out.println("jsonResponse = " + jsonResponse);
        assertTrue(jsonResponse.contains("\"name\":\"morpheus\""), "Response should contain 'name'");
        assertTrue(jsonResponse.contains("\"job\":\"leader\""), "Response should contain 'job'");
        assertTrue(jsonResponse.contains("\"id\":"), "Response should contain an 'id'");
        assertTrue(jsonResponse.contains("\"createdAt\""), "Response should contain 'createdAt'");
    }
}

