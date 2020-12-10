package kinChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class submitForm {
	
	WebDriver driver;
	
	public void LaunchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
		
		
	}
	
	public void fillForm() {
		driver.findElement(By.id("formulate---1")).sendKeys("John Doe");
		
		driver.findElement(By.cssSelector("label[for='formulate---2_yes']")).click();
		
		driver.findElement(By.id("formulate---5")).sendKeys("Goosebumps");
		
		driver.findElement(By.id("formulate---6")).sendKeys("RL Stein");
		
		driver.findElement(By.id("formulate---7")).sendKeys("265");
		
		driver.findElement(By.id("formulate---8")).sendKeys("000.11.333");
		
		Select amountRead = new Select(driver.findElement(By.id("formulate---9")));
		amountRead.selectByValue("unread");
		
		Select timeTaken = new Select(driver.findElement(By.id("formulate---10")));
		timeTaken.selectByVisibleText("2 to 3 weeks");
		
		Select rating = new Select(driver.findElement(By.id("formulate---11")));
		rating.selectByIndex(3);
	}
	
	public void clickSubmit() {
		driver.findElement(By.cssSelector("button[name='Submit']")).click();
	}
	
	public void checkBookCreated() {
		driver.findElement(By.linkText("Books")).click();
	}
	
	public void close() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		submitForm obj = new submitForm();
		obj.LaunchBrowser();
		obj.fillForm();
		Thread.sleep(2000);	
//		obj.clickSubmit();
		obj.checkBookCreated();
		Thread.sleep(2000);	
		obj.close();
	}

}
