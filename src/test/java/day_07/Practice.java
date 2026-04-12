package day_07;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Practice {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver  = new ChromeDriver();
//		//implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		
//		//
//		driver.get("https://ali-akbar.vercel.app");
//		//
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(1000);
//		js.executeScript("window.scrollBy(0, 500000)");
		
		//explicit wait
//		WebDriverWait my_wait = new WebDriverWait(driver, Duration.ofSeconds(10));//this is the declaration
		/*
		 
		 *	// wait until element is visible on the page
			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("userName"))
			);
			
			// wait until element is clickable
			WebElement button = wait.until(
			    ExpectedConditions.elementToBeClickable(By.id("login"))
			);
			
			// wait until element is present in DOM (not necessarily visible)
			WebElement el = wait.until(
			    ExpectedConditions.presenceOfElementLocated(By.id("userName"))
			);
			
			// wait until page title contains specific text
			wait.until(ExpectedConditions.titleContains("Dashboard"));
			
			// wait until URL contains specific text
			wait.until(ExpectedConditions.urlContains("dashboard"));
			
			// wait until element text is present
			wait.until(ExpectedConditions.textToBePresentInElementLocated(
			    By.id("message"), "Success"
			));
			
			// wait until element becomes invisible
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
			
			// wait until alert is present
			wait.until(ExpectedConditions.alertIsPresent());
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 */
//		driver.get("https://ali-akbar.vercel.app");
//		Thread.sleep(3000);
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		HashSet<String> st= new HashSet<String>();
//		//
//		Thread.sleep(3000);
//		int number = 1;
//		for(WebElement link: links) {
//			st.add(link.getAttribute("href"));
//		}
//		for(String link: st) {
//			System.out.println("link "+number+" ->"+link);
//			number++;
//		}
		
		
//		how to use the fluent wait
		//fluent wait k baqi methods sarey explicit wait wale jese hi ha
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
		.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class);
//		
		WebElement element = fluentWait.until(
			dr -> dr.findElement(By.id("userName"))	
		);
				
		
		
		driver.close();

	}
}
