package com.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class InvalidarUsuarioStepDefinition {

    @Cuando("se invalida el usuario")
    public void seInvalidaElUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo();
    }

}
