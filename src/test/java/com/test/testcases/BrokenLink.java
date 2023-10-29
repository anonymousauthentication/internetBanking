package com.test.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {
	static WebDriver driver;

	public static void main(String args[]) throws IOException {
		getBrokenLink();
		// scrollWeb();
	}

	public static void getBrokenLink() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> ll = driver.findElements(By.tagName("a"));
		System.out.println(ll.size());

		SoftAssert a = new SoftAssert();
		for (WebElement getLink : ll) {
			String url = getLink.getAttribute("href");
			try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();

			
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			}
			catch(Exception e){
				System.out.println(url + " - " + "is a broken link");
			}

		}
		a.assertAll();
	}

	public static void scrollWeb() {
		driver = new ChromeDriver();
		driver.get("https://webkul.com/");
		JavascriptExecutor sss = (JavascriptExecutor) driver;
		sss.executeScript("window.scrollBy(0,220)");
	}
}
