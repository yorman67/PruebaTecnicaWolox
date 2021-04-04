package com.prueba.stepdefinitions;

import com.prueba.task.Invalidar;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.prueba.util.VariablesSesion.TOKEN;

public class InvalidarUsuarioStepDefinition {

    @Cuando("se invalida el usuario")
    public void seInvalidaElUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo(Invalidar.usuario(Serenity.sessionVariableCalled(TOKEN)));
    }

}
