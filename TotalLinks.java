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

public class TotalLinks {
	
	//Declaration of main method
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		//Launch the web site for Amazon
		driver.get("https://amazon.in");

		// To click on
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.click();
		searchBox.sendKeys("Laptops");

		// To locate and lick on search button
		WebElement searchButton = driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following::input"));
		searchButton.click();

		// Locating the each web element for links and storing in list.
		List<WebElement> linksAll = (List<WebElement>) driver.findElements(By.tagName("a"));
		// Finding the total no of links
		int totalLinks = linksAll.size();
		System.out.println("Total No. of links on page :" + totalLinks);
		System.out.println("****************************************");
		System.out.println("");
		System.out.println("Page Link Urls and Links Texts on page:");
		System.out.println("****************************************");
		System.out.println("");
		for (int i = 0; i < totalLinks; i++) {
			WebElement linkElt = linksAll.get(i);
			System.out.println(linkElt.getAttribute("href"));
			System.out.println(linkElt.getText());
			System.out.println();

		}

	}// End of Program

}
