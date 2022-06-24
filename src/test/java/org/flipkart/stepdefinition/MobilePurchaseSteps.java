package org.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.objectrepository.MobilePurchasePage;
import com.flipkart.resources.Commonactions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps extends Commonactions{

	Commonactions c = new Commonactions();
	MobilePurchasePage m = new MobilePurchasePage();


	@Given("User launches flipkart application")
	public void user_launches_flipkart_application() {



	}

	@Given("user able to login flipkart with credentials")
	public void user_able_to_login_flipkart_with_credentials() {

		try{


			m.getCloseIcon().isDisplayed();
			m.getCloseIcon().click();

		}catch (Exception e) {

			System.out.println("Login not required");

		}

	}

	@When("user search mobiles and choose")
	public void user_search_mobiles_and_choose() {


	    c.insertText(m.getSearch(), "realme");
	    String fn = m.getMobileName().getText();
		System.out.println("Mobile Name is :"+fn);	
		c.button(m.getMobileName());

	}

	@When("user add mobile to addToCart and doing payment")
	public void user_add_mobile_to_addToCart_and_doing_payment() {

       c.windowsHandling();

	}

	@Then("user validates confirmation message")
	public void user_validates_confirmation_message() {

		System.out.println("drpdown & screenshot");

		c.scrollDown(m.getBuy());

		String text = m.getBuy().getText();

		Assert.assertTrue(m.getBuy().isDisplayed());

		Assert.assertEquals("BUY NOW", text);

		driver.quit();


	}

	@When("user search mobiles and choose by one dim list")
	public void user_search_mobiles_and_choose_by_one_dim_list(DataTable dataTable) {

		List<String> asList = dataTable.asList();

		c.insertText(m.getSearch(), asList.get(0));
		WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'"+asList.get(0)+"')])[2]"));
	    String fn = mobileName.getText();
		System.out.println("Mobile Name is :"+fn);

		mobileName.click();

	}

	@When("user search mobiles and choose by one dim map")
	public void user_search_mobiles_and_choose_by_one_dim_map(DataTable dataTable) {

		Map<String, String> asMap = dataTable.asMap(String.class, String.class);
		c.insertText(m.getSearch(), asMap.get("phone3"));
		WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'"+asMap.get("phone3")+"')])[2]"));
	    String fn = mobileName.getText();
		System.out.println("Mobile Name is :"+fn);

		mobileName.click();

	}

	@When("user search mobiles and choose {string}")
	public void user_search_mobiles_and_choose(String name) {

		c.insertText(m.getSearch(), name);
		WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'"+name+"')])[2]"));
	    String fn = mobileName.getText();
		System.out.println("Mobile Name is :"+fn);

		mobileName.click();

	}

}