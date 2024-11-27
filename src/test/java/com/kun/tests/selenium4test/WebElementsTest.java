package com.kun.tests.selenium4test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * ClassName: WebElementsTest
 * Package: com.kun.tests.selenium4test
 * Description:
 *
 * @Author KunJiang
 * @Create 11/27/24 10:24 AM
 * @Version 1.0
 */
public class WebElementsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://trytestingthis.netlify.app/");

       List<WebElement> elements = driver.findElements(By.id("owc"));
       for(WebElement e : elements){
           System.out.println(e.getText());
       }

        driver.quit();
    }
}
