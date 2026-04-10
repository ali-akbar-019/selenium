package day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * // By ID
driver.findElement(By.cssSelector("#userName"));

// By Class
driver.findElement(By.cssSelector(".form-control"));

// By Attribute
driver.findElement(By.cssSelector("[placeholder='Full Name']"));

// By Tag + Attribute
driver.findElement(By.cssSelector("input[placeholder='Full Name']"));

// By Child
driver.findElement(By.cssSelector("form > input"));

// Contains
driver.findElement(By.cssSelector("[placeholder*='Name']"));

// Starts With
driver.findElement(By.cssSelector("[placeholder^='Full']"));

// Ends With
driver.findElement(By.cssSelector("[placeholder$='Name']"));
 * 
 * 
 */
public class Assignment_01 {
	
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		//------
		driver.manage().window().maximize();
		//get url
		driver.get("https://demoqa.com/text-box");
		Thread.sleep(2000);
		//
		//we have to select all the form fields and fill them using the css selectors
		WebElement fName = driver.findElement(By.cssSelector("[placeholder='Full Name']"));
		WebElement email = driver.findElement(By.cssSelector("#userEmail"));
		WebElement currentAdd = driver.findElement(By.cssSelector("#currentAddress"));
		WebElement permAdd = driver.findElement(By.cssSelector("#permanentAddress"));
		WebElement submitBtn = driver.findElement(By.cssSelector("#submit"));
		///fill values
		//
		fName.sendKeys("Ali Akbar");
		email.sendKeys("ali@gmail.com");
		currentAdd.sendKeys("test current address");
		permAdd.sendKeys("Test perm address");
		//now we gotta scroll to the submit btn
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", submitBtn);
		Thread.sleep(2000); //small pause
		//
		submitBtn.click();
		//
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
