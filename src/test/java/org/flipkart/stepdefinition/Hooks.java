package org.flipkart.stepdefinition;

import com.flipkart.resources.Commonactions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Commonactions{

	Commonactions c = new Commonactions();

	@Before
	public void beforeScenario() {

		System.out.println("Before Each and every scenario");
		// launch
		c.launch();

	}

	@After
	public void afterScenario() {

		System.out.println("After Each and every scenario");
		//quit
		driver.quit();

	}

	//Before
	//Background
	//scenario
	//after

}