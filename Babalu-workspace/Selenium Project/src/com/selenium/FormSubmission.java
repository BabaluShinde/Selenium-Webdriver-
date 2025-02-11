package com.selenium;

//Java code to find the fields using ID 
//Submit button will be tracked using the CSS Selector

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import java.io.File;


public class FormSubmission {
 public static void main(String[] args) 
 {
   // Add External Dependency first to run the application
     System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();

     File file = new File("D:\\form.html");
     String filePath = "file:///" + file.getAbsolutePath();
     driver.get(filePath);   

     WebElement firstName = driver.findElement(By.id("FirstName"));
     WebElement dob = driver.findElement(By.id("DOB"));
     WebElement email = driver.findElement(By.id("Email"));
     WebElement inputNumber = driver.findElement(By.id("inputNumber"));
     WebElement maleRadioButton = driver.findElement(By.id("Male"));

     firstName.sendKeys("Ram");
     dob.sendKeys("19-01-2001");
     email.sendKeys("ram@example.com");
     inputNumber.sendKeys("1234567890");
     maleRadioButton.click();
     
     try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     driver.findElement(By.cssSelector("button[type='submit']")).click();
     
        Alert alert = driver.switchTo().alert();
     String alertText = alert.getText();

     // Check if the alert is open
     if (alertText != null) 
     {
         System.out.println("Alert is open, and the content is: " + alertText);
         // You can accept the alert if needed: alert.accept();
         
     } 
     else 
     {
         System.out.println("No alert found");
     }      
     driver.quit();
 }
}
