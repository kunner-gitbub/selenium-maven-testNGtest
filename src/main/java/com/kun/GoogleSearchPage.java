package com.kun;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ClassName: GoogleSearchPage
 * Package: com.kun
 * Description:
 *
 * @Author KunJiang
 * @Create 11/25/24 2:19 PM
 * @Version 1.0
 */

public class GoogleSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //page elements
    private By searchBox = new By.ByName("q");
    private By searchButton= new By.ByName("btnK");

    //constructor
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //enter search message
    public void enterSearchText(String message){
        //driver.findElement(searchBox).sendKeys(message);

        try {
            //wait till search element is ready
            //WebElement searchInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBox)));
            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
            //input message
            searchInput.sendKeys(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //click search button
    public void clickSearchButton(){
        //driver.findElement(searchButton).sendKeys(Keys.RETURN);

        //wait till click button is ready
        // Wait for the submit button to be clickable
        try {
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            submitBtn.sendKeys(Keys.RETURN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
