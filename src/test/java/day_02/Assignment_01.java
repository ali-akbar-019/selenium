package day_02;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 we have 
 By.id
 By.name
 By.classname
 By.xpath
 By.linkText
 By.partialLinkText
 By.CssSelector
 
 ---
 FindElement -> return one
 FindElements -> returns List of WebElements
  */
public class Assignment_01 {
	public static void main(String args[]) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		//go to the url
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize(); //this will maximize the window
		//now we have to get the fields and fill values in it
		//get the full name
		WebElement fName = driver.findElement(By.id("userName"));
		//get the email
		WebElement email = driver.findElement(By.id("userEmail"));
		//get the current address
		WebElement currAdd = driver.findElement(By.id("currentAddress"));
		//get the permanent address
		WebElement permAdd = driver.findElement(By.id("permanentAddress"));
		//get the submit button
		WebElement submit = driver.findElement(By.id("submit"));
		//fill all the values
		
		fName.sendKeys("Ali Akbar");
		email.sendKeys("ali.test@gmail.com");
		currAdd.sendKeys("Test current address");
		permAdd.sendKeys("Test Permanent Address");
		
		//click the submit button
		//alr so the submit is giving an error right now lets fix it
		//lets use js executor to first scroll a little bit and then click on it
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", submit); //the submit is stored in the arguments[0]
		Thread.sleep(2000); //small pause
		submit.click();
		
		//now check weather the output is available or not
		WebElement outputName=  driver.findElement(By.id("name"));
		if(outputName.isDisplayed()) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		driver.close();
		
	}
}
