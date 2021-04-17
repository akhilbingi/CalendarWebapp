package E2EProjectCopy.CalendarAppCopy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author AKHIL BINGI
 *
 */
public class reportsGen {
	static ExtentReports extent;

	public static ExtentReports getReports() {
		// Path where reports are generated after the execution of each steps
		String path = System.getProperty("user.dir") + "/reports/index.html";
		ExtentSparkReporter repo = new ExtentSparkReporter(path);
		repo.config().setReportName("Calender create page");
		repo.config().setDocumentTitle("Analysis");

		extent = new ExtentReports();
		extent.attachReporter(repo);
		extent.setSystemInfo("Tester", "Akhil Bingi");
		return extent;
	}

}
