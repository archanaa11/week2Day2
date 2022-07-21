package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		//Enter email address
		driver.findElement(By.id("email")).sendKeys("archanaa11@gmail.com");
		//Append a text and press Keyboard tab
		String tt=driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/following::input)[1]")).getText();
		String text=" to the text";
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/following::input)[1]")).sendKeys(tt+text);	
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/following::input)[1]")).sendKeys(Keys.TAB);
		//Get Default text entered
		WebElement current=driver.switchTo().activeElement();
		String value1= current.getAttribute("value");
		System.out.println("The Default text is "+value1);
		//Clear the text
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/following::input)[3]")).clear();
		//confirm disabled field
		WebElement disablecheck=driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/following::input)[4]"));
		if(disablecheck.isEnabled())

			System.out.println("The field is Enabled");
		else
			System.out.println("The field is disabled");


	}

}
