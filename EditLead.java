package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		//http://leaftaps.com/opentaps/control/main
		
	// 1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Object Duration;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.manage().window().maximize();
		
		// 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		// 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//8	Enter first name
		//div[@class='x-form-item x-tab-item'][2]//following::input
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item'][2]//following::input")).sendKeys("Archanaa");
		//9	Click Find leads button
		//button[contains(text(),'Find Leads')]
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		//10 Click on first resulting lead
		//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]//following::a
		Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
				
		//11 Verify title of the page
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("The page is loaded correctly");
		}
			
		String company="DXC";
		//12 Click Edit
		driver.findElement(By.xpath("//a[@class='subMenuButton'][3]")).click();
		//13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		
		//14 Click Update
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		//15 Confirm the changed name appears
		String update1=driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		
		System.out.println(update1);
		//String[] upd=update1.split(" ");
		if(update1.contains(company)) {
			System.out.println("The company is updated "+company);
		}
		//16 Close the browser (Do not log out)
		driver.close();

	}

}
