package day_11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task_02 {
	public static void main(String args[]) {
		// handling the dynamic dropdown
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// the dropdown opener
		WebElement languageDropdownOpener = driver.findElement(By.xpath("//div[@id='msdd']"));
		// open the drop down
		languageDropdownOpener.click();
		// get all the options
		// we have to make a good xpath that will select all the elements
		List<WebElement> optionsForLanguage = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
		// now select a option
		// select danish
		driver.findElement(By.xpath("//a[normalize-space()='Danish']")).click();
		// print all the options
		System.out.println("options for the langugae");
		for (WebElement opt : optionsForLanguage) {
			System.out.println("Language Skill - " + opt.getText());
		}
		// now for the skills
		WebElement skillsDropdown = driver.findElement(By.xpath("//select[@id='Skills']"));
		// get all the options
		Select skillsSel = new Select(skillsDropdown);
		List<WebElement> skillsOptions = skillsSel.getOptions();
		// select an option and print
		skillsSel.selectByIndex(2);
//		print
		for (WebElement skill : skillsOptions) {
			System.out.println("Skills Option - " + skill.getText());
		}
//		all done 
		System.out.println("All Done");
		driver.close();
	}
}
