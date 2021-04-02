package com.prueba.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = { "src/test/resources/com/prueba/features/login.feature" },
        glue = { "com.prueba.stepdefinitions" },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class LoginRunner {

}
