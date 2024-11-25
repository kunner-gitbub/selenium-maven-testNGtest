package com.kun.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * ClassName: GoogleSearchTest
 * Package: com.kun.tests
 * Description:
 *
 * @Author KunJiang
 * @Create 11/25/24 11:20 AM
 * @Version 1.0
 */

public class GoogleSearchTest {
    @Test
    public void testGoogleTile(){
        String expectedTitle = "Google";
        String actualTitle = "Google"; // 模拟的结果
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }
    @Test
    public void testGoogleSearch(){
        String searchQuery = "TestNG";
        boolean isSearchSuccessful = searchQuery.length() > 0; // 模拟搜索成功
        Assert.assertTrue(isSearchSuccessful, "Search failed!");
    }
}
