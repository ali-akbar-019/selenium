package day_11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task_01 {
	// for the dropdowns
	// simple dropdown using the dropdown element
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//
		driver.get("https://the-internet.herokuapp.com/dropdown");
		//
		driver.manage().window().maximize();
		// now the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait 10 s
		// now get the dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		// convert it to the select
		Select dropdownSelect = new Select(dropdown);
		// get all the options
		List<WebElement> options = dropdownSelect.getOptions();
		dropdownSelect.selectByVisibleText("Option 1");

		// print the output
		for (WebElement el : options) {
			if (el.isSelected()) {
				System.out.println("Selected Right Now: " + el.getText());
			}
		}

		Thread.sleep(2000);
		// now select the second one
		dropdownSelect.selectByVisibleText("Option 2"); // select the second option
		// print the option
		for (WebElement el : options) {
			if (el.isSelected()) {
				System.out.println("Selected Right Now: " + el.getText());
			}
		}
		// now if we are here then its done and then just print Passed
		System.out.println("Dropdown Checked Successfully!");
		driver.close();
	}
}
