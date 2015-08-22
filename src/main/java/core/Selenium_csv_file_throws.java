package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_csv_file_throws {
public static void main(String[] args) throws IOException {
	
	String csvFile = "C:/Workspace/Title_Validation_CSV/src/main/resources/test.csv";
	BufferedReader br = null;
	String line = null;
	String SplitBy = ",";
	String a_value = null;
	String b_value = null;
	String c_value = null;
	
	br = new BufferedReader (new FileReader(csvFile));
	WebDriver driver = new FirefoxDriver();
	while ((line = br.readLine()) != null) {
		String[] csv = line.split(SplitBy);
		a_value = csv[0];
		b_value = csv[1];
		c_value = csv[2];
		
		driver.get(b_value);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();
		
		System.out.println("");

		if (c_value.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + a_value);
			System.out.println("URL: \t\t\t" + b_value);
			System.out.println("Title Expected: \t" + c_value);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + a_value);
			System.out.println("URL: \t\t\t" + b_value);
			System.out.println("Title Expected: \t" + c_value);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
	}
	driver.quit();
	br.close();
}
}
