package E2EProjectCopy.CalendarAppCopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author AKHIL BINGI
 *
 */

public class invokeURLfromtextfile extends mainClass {

	public String geturl() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/E2EProjectCopy/CalendarAppCopy/Data.properties");
		prop = new Properties();
		prop.load(fis);
		String websitename = prop.getProperty("url");
		return websitename;
	}
}
