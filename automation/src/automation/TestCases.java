package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCases {
	
	WebDriver driver;
	
	
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
		Thread.sleep(1000);
		driver.navigate().to("http://localhost:8080/returnBook");
	}
	
	public void fillForm() {
		driver.findElement(By.id("formulate--returnBook-1")).sendKeys("John Doe");
		
		driver.findElement(By.cssSelector("label[for='formulate--returnBook-2_yes']")).click();
		
		driver.findElement(By.id("formulate--returnBook-5")).sendKeys("Goosebumps");
		
		driver.findElement(By.id("formulate--returnBook-6")).sendKeys("RL Stein");
		
		driver.findElement(By.id("formulate--returnBook-7")).sendKeys("265");
		
		driver.findElement(By.id("formulate--returnBook-8")).sendKeys("000.11.333");
		
		Select amountRead = new Select(driver.findElement(By.id("formulate--returnBook-9")));
		amountRead.selectByValue("unread");
		
		Select timeTaken = new Select(driver.findElement(By.id("formulate--returnBook-10")));
		timeTaken.selectByVisibleText("2 to 3 weeks");
		
		Select rating = new Select(driver.findElement(By.id("formulate--returnBook-11")));
		rating.selectByIndex(3);
	}
	
	public void clickSubmit() {
		driver.findElement(By.cssSelector("button[name='Submit']")).click();
	}
	
	public void checkBookCreated() {
		driver.findElement(By.linkText("Books")).click();
		WebElement lastBook = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/fieldset/div/ul/li[last()]"));
		lastBook.getText().contains("{ 'townResident': 'yes', 'amountRead': 'unread', 'timeToRead': 'twoTo3weeks', 'rating': 'two', 'name': 'John Doe', 'title': 'Goosebumps', 'author': 'RL Stein', 'numberOfPages': '265', 'dewey': '000.11.333', ");
	}
	
	public void close() {
		driver.quit();
	}
	

}
