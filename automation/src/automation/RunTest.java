package automation;

public class RunTest {

	public static void main(String[] args) throws InterruptedException {
		
		TestCases obj = new TestCases();
		obj.launchBrowser();
		
		obj.fillForm();
		Thread.sleep(2000);	
		
		obj.clickSubmit();
		Thread.sleep(2000);	
		
		obj.checkBookCreated();
		Thread.sleep(2000);	
		
		obj.goToHomepage();
		Thread.sleep(2000);	
		
		obj.close();
	}

}
