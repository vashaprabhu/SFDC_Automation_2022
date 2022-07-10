package Runners;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\java\\com\\featureFiles"},
					glue = {"com.stepDefnitionFiles"}, 
					plugin = { "pretty" , "html:target/cucumber-reports.html"},
					monochrome = true, tags = "@Smoke")   /* to ignore perticular scenario we should give tags = "not @ignore" */
public class runner extends AbstractTestNGCucumberTests{

}
