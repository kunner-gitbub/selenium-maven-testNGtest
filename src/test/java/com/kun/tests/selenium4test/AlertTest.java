package com.kun.tests.selenium4test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ClassName: Alert
 * Package: com.kun.tests.selenium4test
 * Description:
 *
 * @Author KunJiang
 * @Create 11/26/24 4:05 PM
 * @Version 1.0
 */

public class AlertTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            // Open the W3Schools Tryit Editor page
            driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

            // Switch to the iframe containing the "Try it" button
            driver.switchTo().frame("iframeResult");

            // Click the button to trigger the alert
            driver.findElement(By.xpath("//button[text()='Try it']")).click();

            // Handle the alert
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText()); // Print the alert text
            alert.accept(); // Accept the alert
            // Switch back to the main content if needed
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

    }
}
