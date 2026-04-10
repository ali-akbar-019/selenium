package day_01;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class firstSelenium {
	public static void main(String args[]) {
		//this will use the chromedriver and will open the chrome browser
		WebDriver driver = new ChromeDriver();
		//get a url -> this will open this url in a chrome browser
		driver.get("https://www.saucedemo.com/");
		//we have to get the title and print it in the console
		//printing the title
		if(driver.getTitle().isBlank()) {
			System.out.println("No title found");
		}else {
			System.out.println(driver.getTitle());
		}
		
		//close the browser
		driver.close();
		
		
		
	}
}
