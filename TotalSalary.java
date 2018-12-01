package com.ibm.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class TotalSalary {

	// Declaration of main method
	public static void main(String[] args) {

		
		//Setting path for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
				
		// Launch the web site for datatables
		driver.get("https://datatables.net");

		// Finding the total number of rows in the table.
		List<WebElement> rows = (List<WebElement>) driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int rowTotal = rows.size();
		System.out.println("Total no.of rows in the table are " + rowTotal);

		// Finding the rotal number of columns in the table
		List<WebElement> columns = (List<WebElement>) driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td"));
		int colTotal = columns.size();
		System.out.println("Total Columns in table are " + colTotal);

		int totalsalary = 0;
		int j = 0;

		//Locating the salary element of each row and calculating the total salary 
		for (int i = 1; i <= rowTotal; i++) {
			j = i + 1;
			// To locate and click on the name element value in each row
			WebElement nameCell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[1]"));
			nameCell.click();

			// Locating salary element value
			WebElement salElt = driver
					.findElement(By.xpath("(//table[@id='example']/tbody/tr[" + j + "]/td[1]/descendant::span)[2]"));

			// Replacing the special characters $ , with empty value in a string
			String salValue = salElt.getText().trim().replace("$", "").replace(",", "");
			// Calculating total salary
			totalsalary = totalsalary + Integer.parseInt(salValue);

			// To click on name element value again
			nameCell.click();

		}
		// Printing total salary on console
		System.out.println("Total Salary:" + totalsalary);

	}

}//End of program
