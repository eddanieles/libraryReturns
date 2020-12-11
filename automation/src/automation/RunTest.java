package automation;

public class RunTest {

	public static void main(String[] args) throws InterruptedException {
		
		TestCases obj = new TestCases();
		obj.launchBrowser();
		
		obj.checkPagesRead();
		
		obj.fillForm();
		Thread.sleep(2000);	
		
		obj.clickSubmit();
		Thread.sleep(2000);	
		
		obj.checkBookCreated();
		Thread.sleep(2000);	
		
		obj.checkPagesRead();
		
		obj.goToHomepage();
		Thread.sleep(2000);	
		
		obj.close();
	}

}
