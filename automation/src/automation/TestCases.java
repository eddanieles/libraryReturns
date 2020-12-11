package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCases {
	
	WebDriver driver;
	
	
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
		
		Thread.sleep(1000);
		
		System.out.println("Sucessfully launched browser!");
	}
	
	public void fillForm() {
		driver.navigate().to("http://localhost:8080/returnBook");
		
		driver.findElement(By.id("formulate--returnBook-1")).sendKeys("John Doe");
		
		driver.findElement(By.cssSelector("label[for='formulate--returnBook-2_yes']")).click();
		
		driver.findElement(By.id("formulate--returnBook-5")).sendKeys("Goosebumps");
		
		driver.findElement(By.id("formulate--returnBook-6")).sendKeys("RL Stein");
		
		driver.findElement(By.id("formulate--returnBook-7")).sendKeys("265");
		
		driver.findElement(By.id("formulate--returnBook-8")).sendKeys("000.11.333");
		
		Select amountRead = new Select(driver.findElement(By.id("formulate--returnBook-9")));
		amountRead.selectByValue("read");
		
		Select timeTaken = new Select(driver.findElement(By.id("formulate--returnBook-10")));
		timeTaken.selectByVisibleText("2 to 3 weeks");
		
		Select rating = new Select(driver.findElement(By.id("formulate--returnBook-11")));
		rating.selectByIndex(3);
		
		System.out.println("Filled in form!");
	}
	
	public void clickSubmit() {
		driver.findElement(By.cssSelector("button[name='Submit']")).click();
		
		System.out.println("Form submitted!");
		System.out.println("Total pages read should have added 265 from the form value that was submitted.");
	}
	
	public void checkBookCreated() {
		driver.findElement(By.linkText("Books")).click();
		WebElement lastBook = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/fieldset/div/ul/li[last()]"));
		Actions act = new Actions(driver);
		act.moveToElement(lastBook).perform();
		lastBook.getText().contains("{ 'townResident': 'yes', 'amountRead': 'unread', 'timeToRead': 'twoTo3weeks', 'rating': 'two', 'name': 'John Doe', 'title': 'Goosebumps', 'author': 'RL Stein', 'numberOfPages': '265', 'dewey': '000.11.333', ");
	
		System.out.println("Book successfully added to list!");
	}
	
	public void goToHomepage() {
		driver.navigate().to("http://localhost:8080/");
		
		System.out.println("Able to go to homepage!");
	}
	
	public void checkPagesRead() {
		driver.navigate().to("http://localhost:8080/");
		String pagesRead = driver.findElement(By.id("totalPagesRead")).getText();
		
		System.out.println("Total number of pages read: " + pagesRead);
		
		String categoryPagesRead = driver.findElement(By.xpath("//*[@id=\"pagesReadByCategory\"]/li[last()]")).getText();
		System.out.println("Last pages read by category text: " + categoryPagesRead);
	}
	
	public void close() {
		driver.quit();
		
		System.out.println("App works!");
	}
	

}
