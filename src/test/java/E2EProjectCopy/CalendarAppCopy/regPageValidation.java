package E2EProjectCopy.CalendarAppCopy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

/**
 * @author AKHIL BINGI
 *
 */

public class regPageValidation extends mainClass {
	public WebDriver driver;

	@Test(dataProvider = "getdata")
	public void invokingRegistrationPage(String emailid, String Name, String Username, String password, String URL)
			throws IOException, InterruptedException

	{
		driver = initialize();
		invokeURLfromtextfile i = new invokeURLfromtextfile();
		driver.get(i.geturl());
                registrationPage reg = new registrationPage(driver);
		reg.EnterRegPage().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		reg.getEmail().sendKeys(emailid);
		reg.getName().sendKeys(Name);
		reg.getUsernme().sendKeys(Username);
		reg.getpassword().sendKeys(password);
		reg.getAvatar().sendKeys(URL);
		reg.Submit().click();
		// cust_url is the url of the login user at that instance
		String cust_url = i.geturl() + "/calendar/" + Username;
		String curl_url = driver.getCurrentUrl();

		// according to functonality the user is logging after functionality so
		// validating the url
		Assert.assertTrue(cust_url.equalsIgnoreCase(curl_url),
				"The test case failed as the user could not be able to register");
	}

	@DataProvider
	public Object[][] getdata() {
		// Accesing the excel data from static class TestUtil,Enhanced the code without
		// HardCoding
		Object[][] data = TestUtil.getTestData("reg");
		return data;

	}

	@AfterTest
	public void aftertest() {
		driver.close();
	}

}
