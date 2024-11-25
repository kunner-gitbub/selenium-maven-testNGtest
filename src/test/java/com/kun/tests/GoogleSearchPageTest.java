package com.kun.tests;

import com.kun.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * ClassName: GoogleSearchPageTest
 * Package: com.kun.tests
 * Description:
 *
 * @Author KunJiang
 * @Create 11/25/24 2:29 PM
 * @Version 1.0
 */

public class GoogleSearchPageTest {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private WebDriverWait wait;
    @BeforeTest
    public void setUp(){
        // Setup WebDriver using WebDriverManager， launch web browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

    }
    @Test
    public void testSearchPage(){
        //input search message and search
        String searchMessage = "Automation step to step";
        googleSearchPage.enterSearchText(searchMessage);
        googleSearchPage.clickSearchButton();

        //check new page title
        String pageTitle = googleSearchPage.getPageTitle();
        Assert.assertTrue(pageTitle.contains(searchMessage),
                "Page title does not contain search text");
        System.out.println("new pageTitle = " + pageTitle);
    }
    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
