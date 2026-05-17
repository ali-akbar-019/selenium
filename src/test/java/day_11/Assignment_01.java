package day_11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_01 {
	public static void main(String args[]) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().window().maximize();
		//
		driver.get("https://the-internet.herokuapp.com/dropdown");
		//
		WebElement selInp = driver.findElement(By.xpath("//select[@id='dropdown']"));
		//
		Select selectDropdown = new Select(selInp);
		//
		selectDropdown.selectByVisibleText("Option 1");
		//
		Thread.sleep(2000);
		selectDropdown.selectByValue("2");
		//
		Thread.sleep(2000);
		// get all the options and print them in the console
		List<WebElement> options = selectDropdown.getOptions();
		for (WebElement opt : options) {
			System.out.println("Option - " + opt.getText());
			if (opt.isSelected()) {
				System.out.println("Selected Option - " + opt.getText());
			}
		}
		//
		driver.close();

	}
}
