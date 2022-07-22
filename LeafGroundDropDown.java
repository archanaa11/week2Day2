package week2.day2;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		//Select Training Program using Index
		
		Select select =new Select(driver.findElement(By.id("dropdown1")));
		select.selectByIndex(1);
		
		//Select Training Program using Text
		Select select2 =new Select(driver.findElement(By.xpath("(//select)[2]")));
		select2.selectByVisibleText("Loadrunner");

		//Select Training Program using Value
		Select select3=new Select(driver.findElement(By.id("dropdown3")));
		select3.selectByValue("2");
		

		//Get the number of dropdown options
		Select s1=new Select(driver.findElement(By.cssSelector("select[class='dropdown']")));
		List<WebElement> l1=select.getOptions();
		int count=l1.size();
		System.out.println("The number of options in the dropdown is"+count);
		//int options=selenium.get
			//	driver.findElement(By.xpath("(//select)[4]")).getText().split("\n");
		//options.length;
		
		//Select selectV=new Select(driver.findElement(By.id("dropdown")));
		//selectV.selectByValue("2");
	
		//use sendKeys to select
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("UFT/QTP");
		//selectS.send;
		
		//Select your Program
		Select ss5=new Select(driver.findElement(By.xpath("(//select)[6]")));
		ss5.selectByValue("2");
	}

	

	
}
