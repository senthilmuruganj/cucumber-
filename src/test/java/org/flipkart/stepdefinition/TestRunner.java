package org.flipkart.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features",
                     glue = "org.flipkart.stepdefinition",
                   plugin = "html:target",
               monochrome = true,
                   dryRun = false,
                     tags = {"@Smoke"})

public class TestRunner {

}