package com.prueba.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class Hook {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

}
