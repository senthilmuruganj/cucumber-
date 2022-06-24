package com.flipkart.resources;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonactions {

	public static WebDriver driver;

	public void launch() {

        WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void insertText(WebElement ele,String value) {

		ele.sendKeys(value,Keys.ENTER);

	}

	public void button(WebElement ele) {

		ele.click();

	}

	public void windowsHandling() {

        String parent = driver.getWindowHandle();

		Set<String> child = driver.getWindowHandles();
		for (String x : child) {

			if(!x.equals(parent)){
				driver.switchTo().window(x);
				System.out.println("window switched");
			}

		}

	}

	public void scrollDown(WebElement element) {

		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public void scrollDown() {

		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,100)");

	}

}