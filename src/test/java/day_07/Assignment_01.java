package day_07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_01 {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait my_wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//		//now get the start button and click it
//		WebElement startBtn = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
//		startBtn.click();
//		//now we gotta wait for the hello world
//		//
//		WebElement output = my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
//		if(output.getText().equals("Hello World!")){
//			System.out.println("Passed");
//		}else {
//			System.out.println("Failed");
//		}
//		part 2
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		//now get the start button and click it
		WebElement startBtn = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
		startBtn.click();
		//
		my_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
		WebElement output = my_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
		if(output.getText().equals("Hello World!")) {
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		//now we gotta wait for the hello world
		driver.close();
	}
}
