package day_02;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment_02 {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		//go to the page
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		Thread.sleep(2000);
		//getting the three buttons
		WebElement clickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
		WebElement rightClickBtn = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		WebElement dblClickBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		//
		Thread.sleep(2000);
		//now perform the actions
		clickBtn.click();
		//for the right click and the dbl click we need actions class
		Actions action = new Actions(driver);
		action.contextClick(rightClickBtn).perform();
		action.doubleClick(dblClickBtn).perform();
		//now we have to verify the output
		WebElement clkOut = driver.findElement(By.id("dynamicClickMessage"));
		WebElement dblClkOut = driver.findElement(By.id("doubleClickMessage"));
		WebElement rgtClkOut = driver.findElement(By.id("rightClickMessage"));

		String expectedClickOut = "You have done a dynamic click";
		String expectedRgtClickOut = "You have done a right click";
		String expectedDblClickOut = "You have done a double click";
		//compare 
		if(clkOut.getText().equals(expectedClickOut) && dblClkOut.getText().equals(expectedDblClickOut)
			&& rgtClkOut.getText().equals(expectedRgtClickOut)	
			) {
			System.out.println("Test case passed!\nAll three buttons clicked.");
		}else {
			System.out.println("Test case Failed!");
		}
		driver.close();
		
	}
}
