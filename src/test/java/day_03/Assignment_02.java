package day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02 {
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();;
		driver.get("https://demoqa.com/automation-practice-form");
		//----------------------------------
		WebElement firstName = driver.findElement(By.cssSelector("[placeholder='First Name']"));
		WebElement lastName = driver.findElement(By.cssSelector("[placeholder='Last Name']"));
		WebElement email = driver.findElement(By.cssSelector("[placeholder='name@example.com']"));
		WebElement gender = driver.findElement(By.xpath("//input[@name='gender' and @value='Male' ]"));
		WebElement mobile = driver.findElement(By.cssSelector("[placeholder='Mobile Number']"));
		WebElement subject = driver.findElement(By.cssSelector("#subjectsInput"));
		WebElement hobbies = driver.findElement(By.xpath("//input[@type='checkbox' and @value='1' ]"));
		
		WebElement currAdd = driver.findElement(By.cssSelector("#currentAddress"));
		WebElement state = driver.findElement(By.cssSelector("#react-select-3-input"));
		WebElement submit = driver.findElement(By.cssSelector("#submit"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		firstName.sendKeys("ali ");
		lastName.sendKeys("akbar ");
		email.sendKeys("ali@gmail.com");
		gender.click();
		mobile.sendKeys("1231231231");
		subject.sendKeys("hola hola");
		js.executeScript("scrollBy(0,500)");
		Thread.sleep(3000);
		hobbies.click();
		currAdd.sendKeys("Test address");
		state.sendKeys("Uttar Pradesh");
	
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		Thread.sleep(3000);
		submit.click();
		
		if(driver.findElement(By.cssSelector(".modal-content")).isDisplayed()) {
			System.out.println("PASSED!");
		}else {
			System.out.println("FALED!");
		}
		driver.close();

		
		
	}
}
