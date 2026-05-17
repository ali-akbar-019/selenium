package day_13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationPractice {
	public static void main(String args[]) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
		// first of all scroll the table into the view
		WebElement tableContainer = driver.findElement(By.cssSelector("#example_wrapper"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", tableContainer);
		// now get the pagination next button

		while (true) {
			WebElement nextBtn = driver.findElement(By.xpath("//button[contains(text(),'›')]"));
			// till the nextBtn is not deactivated

			// get the number of the rows
			int rows = driver.findElements(By.xpath("//table[@id='example']//tr")).size() - 2;
			// get the number of the cols
			int cols = driver.findElements(By.xpath("//table[@id='example']//tr//th")).size() / 2;
			// now loop to print
			// print headers
			for (int col = 1; col <= cols; col++) {
				String text = driver.findElement(By.xpath("//table[@id='example']//tr[1]/th[" + col + "]")).getText();
				System.out.print(text + "\t");
			}
			for (int i = 2; i <= rows; i++) {
				for (int j = 1; j <= cols; j++) {
					WebElement currCol = driver
							.findElement(By.xpath("//table[@id='example']//tr[" + i + "]//td[" + j + "]"));
					System.out.print(currCol.getText() + "\t");
				}
				System.out.println();
			}
			// we will print the table page by page
			if (nextBtn.getAttribute("class").contains("disabled")) {
				System.out.println("Successfully printed all the page of the table");
				break;
			}
			// go to the next page
			nextBtn.click();
			Thread.sleep(3000);

		}
		driver.close();
	}
}
