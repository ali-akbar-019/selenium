package day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {
	public static void main(String args[]) {
		//
		WebDriver driver = new ChromeDriver();
		//maximize the window
		driver.manage().window().maximize();
		//go to the url
		driver.get("https://demoqa.com/text-box");
		//now get all the web elements
		WebElement fName = driver.findElement(By.xpath("//input[@id='userName']"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder, '@example.com')]"));
		WebElement currAdd = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		WebElement permAdd = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
		
//		add data
		fName.sendKeys("Ali Akbar");
		email.sendKeys("Ali@gmail.com");
		currAdd.sendKeys("add test");
		permAdd.sendKeys("perm add test");
		//scroll into view the submit button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",submitBtn);
		//
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		submitBtn.click();
		//
		//validate 
		WebElement submitedCurrAdd = driver.findElement(By.xpath("//p[@id='permanentAddress']")); 
		if(submitedCurrAdd.getText().equals("Permananet Address :perm add test")) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		driver.quit();
		
	}	
}
