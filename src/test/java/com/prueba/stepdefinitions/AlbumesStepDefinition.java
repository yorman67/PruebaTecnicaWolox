package com.prueba.stepdefinitions;

import com.prueba.task.ListadoAlbumes;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.prueba.util.VariablesSesion.TOKEN;

public class AlbumesStepDefinition {

    @Cuando("se consultan los albumes")
    public void seConsultanLosAlbumes() {
        OnStage.theActorInTheSpotlight().attemptsTo(ListadoAlbumes.con(Serenity.sessionVariableCalled(TOKEN)));
    }

}
