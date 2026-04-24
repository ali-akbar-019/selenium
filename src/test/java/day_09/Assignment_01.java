package day_09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {
	public static void main(String args[]) {
		//
		WebDriver driver = new ChromeDriver();
		//
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		//
		WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));
		//
		System.out.println("Current States");
		if (checkBox1.isSelected()) {
			System.out.println("Checkbox1 is checked");
		} else {
			System.out.println("Checkbox1 is not checked");

		}
		if (checkBox2.isSelected()) {
			System.out.println("Checkbox1 is checked");
		} else {
			System.out.println("Checkbox1 is not checked");

		}
		// ---------
		checkBox1.click();
		checkBox2.click();
		System.out.println("After - States");
		if (checkBox1.isSelected()) {
			System.out.println("Checkbox1 is checked");
		} else {
			System.out.println("Checkbox1 is not checked");

		}
		if (checkBox2.isSelected()) {
			System.out.println("Checkbox1 is checked");
		} else {
			System.out.println("Checkbox1 is not checked");

		}
		driver.close();
	}
}
