import java.io.IOException;
import java.time.Duration;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		
		//Open the URL of webpage
		driver.get("https://unicreds.com/contact-us");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(35000);
		
		//alert for	
		WebElement alert = driver.findElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
		alert.click();
		
		
	    
		//close the Popup 
		WebElement popup = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
		popup.click();
		
		
		//Full Name
		WebElement FullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
		FullName.sendKeys("Darshan");
		System.out.println("Full name has been enterd.");
		
		//Email Address
		WebElement Email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		Email.sendKeys("p.s.mehtre@gmail.com");
		System.out.println("Address has been enterd.");

		
		//Country code
		Select CountryCode = new Select (driver.findElement(By.xpath("//select[@class='p-2 pl-4 pr-4 m-2 mt-2 mb-2 form-control form-control-md']")));
		CountryCode.selectByVisibleText("India (+91)");
		System.out.println("Country code has been enterd.");

		
		//Phone
		WebElement Phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
		Phone.sendKeys("0123456789");
		System.out.println("Phone number has been enterd.");

		
		//Message
		WebElement message = driver.findElement(By.xpath("//textarea[@placeholder='Message']"));
		message.sendKeys("The Assignment for the Quality Assurance has been Completed");
		System.out.println("Message has been enterd.");

		
		//Submit
		driver.findElement(By.xpath("//button[@id='contactButton']")).click();
		System.out.println("Submit button has been clicked.");
		
		
		//verify the message has been sent
		WebElement actualMessage= driver.findElement(By.xpath("//div[@id='formMessage']"));
		actualMessage.isDisplayed();
		System.out.println("Verification of message sent Successfully Completed");
			
		
	
		driver.quit();
		System.out.println("Form is submitted successfully");
		
		
	}
}
