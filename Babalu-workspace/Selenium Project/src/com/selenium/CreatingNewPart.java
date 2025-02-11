package com.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class CreatingNewPart {
    public static void main(String[] args) {
        // Automatically manage ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open blank page first
//            driver.get("about:blank");

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
            
            String mainWindowHandle = driver.getWindowHandle();

            WebElement createButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div[1]/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",createButton);

            	System.out.println("Clicked on Create button using XPath.");
            	
            	// Wait for the new window to open
            	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
            	waits.until(ExpectedConditions.numberOfWindowsToBe(2));

            	// Get all window handles
            	Set<String> allWindowHandles = driver.getWindowHandles();

            	// Identify the new window handle
            	String newWindowHandle = allWindowHandles.stream()
            	    .filter(handle -> !handle.equals(mainWindowHandle))
            	    .findFirst()
            	    .orElseThrow(() -> new RuntimeException("New window not found"));

            	// Switch to the new window
            	driver.switchTo().window(newWindowHandle);
            	System.out.println("Switched to the new window.");

            	
            	
            	// Locate the dropdown
            	WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
            	    By.xpath("//*[@id=\"!~objectHandle~partHandle~!createType\"]")
            	));

            	// Create Select instance
            	Select select = new Select(dropdown);

            	// Select by visible text
            	select.selectByVisibleText("Part");

            	// Select by index (starting from 0)
            	select.selectByIndex(6);

            	WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
            	WebElement nameField = waitt.until(ExpectedConditions.elementToBeClickable(By.name("tcomp$attributesTable$OR:wt.pdmlink.PDMLinkProduct:65687$___null!~objectHandle~partHandle~!_col_name___textbox")));
            	nameField.sendKeys("NewTestPart");

            	WebElement Finish = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ext-gen39\"]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",Finish);

            	
            	System.out.println("Part created successfully");
            	
            	JavascriptExecutor js= (JavascriptExecutor) driver;
            	js.executeScript("alert('Part Created Successfully.!!');");
            
                 } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred during the automation process.");
            
        }
          finally {
            // Close the browser after execution
              try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Giving time to see the created part on the web page.

            driver.quit();
            System.out.println("Browser closed.");
        }
    }
    }
 