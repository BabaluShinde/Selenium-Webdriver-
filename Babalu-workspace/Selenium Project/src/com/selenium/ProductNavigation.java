package com.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductNavigation {
    public static void main(String[] args) {
        // Automatically manage ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open blank page first
            driver.get("about:blank");

            // Inject JavaScript to set credentials and open Windchill
            String windchillURL = "http://swiftplm-pc-09.splm.com/Windchill/app/";
            String script = "window.open('http://wcadmin:wcadmin@swiftplm-pc-09.splm.com/Windchill/app/', '_self')";
            ((JavascriptExecutor) driver).executeScript(script);

            // Maximize window
            driver.manage().window().maximize();
            System.out.println("Window maximized.");

            // Wait for the page to load and check for successful login
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.titleContains("Windchill"));
            System.out.println("Successfully logged in using JavaScript injection.");

            // Log current page title after login
            System.out.println("Current Page Title: " + driver.getTitle());

            // Find and click the "Browse" menu
            WebElement browseMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("object_main_navigation_nav")));
            browseMenu.click();
            System.out.println("Clicked on Browse menu.");
            
         // Wait for and click the product navigation icon (recent products)
            WebElement productNavIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("object_main_navigation__productNavigation")));
            productNavIcon.click();
            System.out.println("Clicked on Product Navigation Icon.");

            
         // Wait for and click the "View All" button
         // Wait for and click the "View All" link after the icon is clicked
            WebElement viewAllLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='app/#ptc1/comp/netmarkets.product.list']")));
            viewAllLink.click();
            System.out.println("Clicked on View All.");

            System.out.println("Navigated to Products.");
            
         // Wait for and click the "Drive System" link after the icon is clicked
            WebElement driveSystemLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Drive System")));
            driveSystemLink.click();
            System.out.println("Clicked on Drive System.");

            WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//*[@id=\"ext-gen360\"]")));
            	createButton.click();
            	System.out.println("Clicked on Create button using XPath.");
            
                 } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred during the automation process.");
        }
//        }  finally {
//            // Close the browser after execution
//            driver.quit();
//            System.out.println("Browser closed.");
//        }
    }
    }
 