package day_12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LittlePracticeOfTheStaticTables {
	public static void main(String args[]) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// get the url
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		// scroll into view the id customers
		WebElement customersTable = driver.findElement(By.id("customers"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", customersTable);
		Thread.sleep(2000);
		// now get the number of the rows and the number of the cols
		int numberOfRows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int numberOfCols = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th")).size();
		// lets print the header first
		// print headers
		for (int col = 1; col <= numberOfCols; col++) {

			String text = driver.findElement(By.xpath("//table[@id='customers']//tr[1]/th[" + col + "]")).getText();

			System.out.printf("%-20s", text);
		}

		System.out.println();

		System.out.println("------------------------------------------------------------");

		// print table data
		for (int row = 2; row <= numberOfRows; row++) {

			for (int col = 1; col <= numberOfCols; col++) {

				String text = driver.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/td[" + col + "]"))
						.getText();

				System.out.printf("%-20s", text);
			}

			System.out.println();
		}
//		All done
		System.out.println("All done, exiting the browser");
		driver.close();
	}
}
