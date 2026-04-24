package day_08;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesCommandsDemo {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		// get all
		Set<Cookie> sOfc = driver.manage().getCookies();
		for (Cookie c : sOfc) {
			System.out.println("key: " + c.getName() + " Value: " + c.getValue());
		}
		// get a specific
		Cookie sessionid = driver.manage().getCookieNamed("sessionId");
		// add a new cookie
		driver.manage().addCookie(new Cookie("ali", "akbar"));

		// delete cookies
		driver.manage().deleteAllCookies();
		// close
		driver.close();
	}

}
