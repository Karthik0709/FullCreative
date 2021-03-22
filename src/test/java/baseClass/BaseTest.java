package baseClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;*/

public class BaseTest {

	public WebDriver driver;
	public SoftAssert softAssert;
	/*public ExtentReports report;
	public ExtentSparkReporter skReport;
	public ExtentTest testStep;*/
	private static final String chromepath = "./src/main/resources/drivers/chromedriver.exe";

	protected WebDriver setChromeDriver() {

		System.setProperty("webdriver.chrome.driver", chromepath);
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("start-maximized");
		driver = new ChromeDriver(opts);
		return driver;
	}

	public WebDriver getChromeDriver() {
		return driver;
	}

	public SoftAssert getAssert() {
		return softAssert;
	}

	public void setAssert() {
		softAssert = new SoftAssert();
	}
	
	@BeforeMethod
	public void beginmethod() throws FileNotFoundException, IOException {
		System.out.println("Setting up Browser");
		setChromeDriver();
		System.out.println("Setting up Assert");
		setAssert();
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
		driver.quit();
		try {
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		} catch (IOException e) {
			System.out.println("Error while Killing Chromedriver"+ e.getMessage());
		}

	}

}
