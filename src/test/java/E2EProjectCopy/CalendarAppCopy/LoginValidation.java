package E2EProjectCopy.CalendarAppCopy;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author AKHIL BINGI
 *
 */
public class LoginValidation extends mainClass {

	public WebDriver driver;

	@DataProvider
	public Object[][] getdatal() throws EncryptedDocumentException, IOException {

		// Object[][] data=TestUtil.getTestData("login");
		// return data;
		Object[][] data = new Object[2][2];
		data[0][0] = "akhilbingi32";
		data[0][1] = "Matrix@321456";

		data[1][0] = "akhilbingi64679@gmail.com";
		data[1][1] = "Matrix@32164";

		return data;

	}

	@Test(dataProvider = "getdatal")
	public void invokingLoginPage(String Username, String password) throws IOException, InterruptedException

	{
		driver = initialize();
		invokeURLfromtextfile i = new invokeURLfromtextfile();
		driver.get(i.geturl());
		loginPage log = new loginPage(driver);
		log.enterLoginPage().click();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.lemail().sendKeys(Username);
		log.lpassword().sendKeys(password);
		log.lbutton().click();
		String date = log.getCurrDate().getText();
		String my = log.getcurrMonYear().getText();
		String Umy = my.toUpperCase();
		System.out.println("Date  is " + date);
		System.out.println("Date  is " + Umy);

		LocalDate currentdate = LocalDate.now();
		System.out.println("Current date: " + currentdate);
		// Getting the current day
		int currentDay = currentdate.getDayOfMonth();
		String cd = String.valueOf(currentDay);
		System.out.println("Current day: " + currentDay);

		// Getting the current month
		Month currentMonth = currentdate.getMonth();
		// converting currentMonth to a String
		String Mon = String.valueOf(currentMonth);
		System.out.println("Current month: " + currentMonth);

		// getting the current year
		int currentYear = currentdate.getYear();
		System.out.println("Current month: " + currentYear);

		// converting current year to string
		String year = String.valueOf(currentYear);
		String monYear = Mon + ", " + year;
		System.out.println(monYear);

		// Testing funtionality number 1
		// verifying the current date and todays date are matching
		Assert.assertTrue(date.equalsIgnoreCase(cd));
		// Testing funtionality number 2
		// veryfing the month and year is corresponding to today's date month year

		Assert.assertTrue(Umy.equalsIgnoreCase(monYear));
		log.getToDoList().sendKeys("Create Jira user stories");
		log.addToDo().click();

	}

	// Data provider for passing the set of values to the invokingLoginPage method

	@AfterTest
	public void aftertest() {
		// close the browser after execution of test
		driver.close();
	}

}
