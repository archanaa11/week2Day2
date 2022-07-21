package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("Archanaa");
		// Step 8: Enter the last name
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys("M");

		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("9840552621");

		// Step 10: Enterthe password
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys("tester@123");
		
		// Step 11: Handle all the three drop downs
		Select date=new Select(driver.findElement(By.xpath("//select[@class='_9407 _5dba _9hk6 _8esg'][1]")));
		date.selectByVisibleText("11");
		Select month=new Select(driver.findElement(By.xpath("//select[@class='_9407 _5dba _9hk6 _8esg'][2]")));
		month.selectByValue("11");
		Select year=new Select(driver.findElement(By.xpath("//select[@class='_9407 _5dba _9hk6 _8esg'][3]")));
		year.selectByVisibleText("2008");
		
		
		// Step 12: Select the radio button "Female" 
		  //          ( A normal click will do for this step) 
		driver.findElement(By.xpath("//input[@class='_8esa'][1]")).click();

	}

}
