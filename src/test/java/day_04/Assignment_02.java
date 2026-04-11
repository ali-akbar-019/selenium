package day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02 {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/login");
			//locators
			WebElement username = driver.findElement(By.xpath("//input[@placeholder='UserName']"));
			WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]"));
			WebElement loginBtn  = driver.findElement(By.xpath("//button[@id='login']"));
			//fill 
			username.sendKeys("ali akbar");
			password.sendKeys("123123123");
			loginBtn.click();
//			
			Thread.sleep(2000);
			//output element
			WebElement output = driver.findElement(By.xpath("//p[@id='name']"));
			String out = "Invalid username or password!";
			
			
			if(output.isDisplayed() && output.getText().equals(out)) {
				System.out.println("Test case passed");
			}else {
				System.out.println("Test Failed");
			}
			driver.close();
	
		}catch (Exception e) {
			System.out.println("Error -> " + e.getLocalizedMessage());
			driver.close();
		}
	}
}
