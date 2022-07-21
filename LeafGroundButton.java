package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Button.html");
		//Go to Home Page
				driver.findElement(By.id("home")).click();
				
		//Go back to button page
		driver.findElement(By.xpath("(//a[@class='wp-categories-link maxheight'])[2]")).click();
		//Find position of button(x,y)
		WebElement position1=driver.findElement(By.id("position"));
		System.out.println("The position of the button is "+position1.getLocation());
		//Get button Color
		WebElement color1=driver.findElement(By.id("color"));
		String colors=color1.getCssValue("background-color");
		System.out.println("The color of the buttoj is "+colors);
		//Find the Height and Width
		WebElement size=driver.findElement(By.id("size"));
		System.out.println("The position of the button is "+size.getSize());
	
		
	}

}
