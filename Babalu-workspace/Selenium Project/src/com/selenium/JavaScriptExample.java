package com.selenium;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class JavaScriptExample {
    public static void main(String[] args) {
        // Set up Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open Google
            driver.get("https://www.google.com");
           
            driver.manage().window().maximize();

            
            // Create JavascriptExecutor instance
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            // Display JavaScript alert popup
            js.executeScript("alert('Google opened successfully!');");
            
            // Wait for user to manually close the popup
            Thread.sleep(4000); // Giving time to see the alert


            // Find the search box and enter a search term using JavaScript
            WebElement searchBox = driver.findElement(By.name("q"));
            js.executeScript("arguments[0].value='ptc windchill';", searchBox);
            
            // Find the search button and click using JavaScript
            WebElement searchButton = driver.findElement(By.name("btnK"));
            js.executeScript("arguments[0].click();", searchButton);
            
         // Check if CAPTCHA iframe is present
            if (driver.findElements(By.xpath("//iframe[contains(@src, 'recaptcha')]")).size() > 0) {
                System.out.println("CAPTCHA detected! Please verify manually.");

                // Show alert popup for manual CAPTCHA solving
                js.executeScript("alert('CAPTCHA detected! Please solve it manually and then click OK to continue.');");

                Thread.sleep(4000);  // Adjust the sleep time as needed to view the alert

            }
            else {
                js.executeScript("alert(' CAPTCHA detected!...Solve it to proceed');");

            	System.out.println("Captcha detectd");
            }
                
               // Wait for user to manually solve CAPTCHA
                Thread.sleep(25000); // Adjust time as needed

                // Switch back to main content after CAPTCHA solving
                driver.switchTo().defaultContent();
                System.out.println("Continuing execution after CAPTCHA verification...");

                // Scroll down using JavaScript
                js.executeScript("window.scrollBy(0,1000)");

                
             }  catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close the browser
               driver.quit();
           }
    	}
    }