package com.prueba.stepdefinitions;

import com.prueba.task.Fotos;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.core.Serenity;

import net.serenitybdd.screenplay.actors.OnStage;

import static com.prueba.util.VariablesSesion.TOKEN;

public class FotosAlbumStepDefiniton {

    @Cuando("se consultan la fotos del almbum")
    public void seConsultanLaFotosDelAlmbum() {
        OnStage.theActorInTheSpotlight().attemptsTo(Fotos.album(Serenity.sessionVariableCalled(TOKEN),"1"));
    }

}
