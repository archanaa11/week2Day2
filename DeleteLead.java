package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		//http://leaftaps.com/opentaps/control/main
		 
		//Delete Lead:
		//	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.manage().window().maximize();
		
		//	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

		//	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//	Click on Phone
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		//	Enter phone number
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-plain-body x-plain-body-noheader x-plain-body-noborder'])[12]/following::input[2]")).sendKeys("9840222621");
		//	Click find leads button
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		
		//	Capture lead ID of First Resulting lead
		Thread.sleep(3000);
		WebElement text=driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String flead=text.getAttribute("innerHTML");
		System.out.println(flead);
		
		//	Click First Resulting lead
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		//	Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//	Enter captured lead ID
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item'][1]//following::input")).sendKeys(flead);
		
		//	Click find leads button
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		//	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String verify="No records to display";
		//String confirm=driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		Thread.sleep(3000);
		String confirm=driver.findElement(By.className("x-paging-info")).getText();
		System.out.println(confirm);
		if(confirm.contains(verify))
		System.out.println("There is no such record verified");
		

		
		//	Close the browser (Do not log out)
		driver.close();
	}

}
