package day_07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_02 {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait my_wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		//		/
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		//
		my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Remove']"))).click();
		WebElement msg=  my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		System.out.println(msg.getText());
		//get ad
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		 msg=  my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
			
		System.out.println(msg.getText());
		
		//now enabling and typing and disabling
		my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Enable']"))).click();
		 msg=  my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
			
		System.out.println(msg.getText());
		my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']"))).sendKeys("Ali Akbar");
		my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Disable']"))).click();
		 msg=  my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
			
		System.out.println(msg.getText());
		
		//
		driver.close();
	}
}
