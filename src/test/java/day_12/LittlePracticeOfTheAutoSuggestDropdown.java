package day_12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LittlePracticeOfTheAutoSuggestDropdown {
	public static void main(String args[]) throws InterruptedException {
		// in this program i am just exploring the auto suggest dropdowns
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// lets go to the Google.com this time
		driver.get("https://www.google.com/");
		// get the search box
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		// lets type something into it
		String searchText = "marvel";
		searchBox.sendKeys(searchText);
		// wait for the suggestions to come
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// -----------------
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul")));
		Thread.sleep(3000);
		// now lets get all the options
		List<WebElement> suggestions = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li"));
		// print all the suggestions
		for (WebElement suggestion : suggestions) {
			System.out.println("Suggestion for: " + searchText + " -> " + suggestion.getText());
		}
		// close the driver
		driver.close();
	}
}
