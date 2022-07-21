package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/checkbox.html");
		//Select languages
		driver.findElement(By.xpath("(//div[@class='example'][1]/input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example'][1]/input)[3]")).click();

		//confirm Selenium is checked
		WebElement check=driver.findElement(By.xpath("(//div[@class='example'][1]/following::input)[1]"));
		if(check.isSelected())
			System.out.println("The Selenium checkbox is checked");
		else
			System.out.println("The Selenium checkbox is not selected");

		//Deselect only checked
		WebElement e1=driver.findElement(By.xpath("(//div[@class='example'])[3]/input[1]"));
		WebElement e2=driver.findElement(By.xpath("(//div[@class='example'])[3]/input[2]"));
		if(e1.isSelected())
			e1.click();
		else if(e2.isSelected())
			e2.click();


		//Select all check boxes
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[2]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[3]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[4]")).click();
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[5]")).click();		
		driver.findElement(By.xpath("(//div[@class='example'])[4]/input[6]")).click();


	}
}
