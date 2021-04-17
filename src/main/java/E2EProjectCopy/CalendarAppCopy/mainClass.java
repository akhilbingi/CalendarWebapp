package E2EProjectCopy.CalendarAppCopy;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author AKHIL BINGI
 *
 */
public class mainClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialize() throws IOException {
          
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/E2EProjectCopy/CalendarAppCopy/Data.properties");

		prop = new Properties();
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--headless");
			
			// Headless method will not invoke the browser but execution will be done at the
			// back
			if (browsername.contains("headless")) {
				
				options.addArguments("headless");

			}
			
			driver = new ChromeDriver(options);
			
		}

		else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "/Users/bingis/Downloads/geckodriver");
			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	// Method to take screenshot when ever there is a failure
	public String TakingScreenshot(String getTestCasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir") + "/reports/demo.html";
		FileUtils.copyFile(source, new File(DestinationFile));
		return DestinationFile;

	}

}
