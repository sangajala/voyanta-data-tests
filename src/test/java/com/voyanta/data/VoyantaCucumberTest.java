package com.voyanta.data;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@Cucumber.Options(tags="@inprogress",format = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"})
public class VoyantaCucumberTest {
}





