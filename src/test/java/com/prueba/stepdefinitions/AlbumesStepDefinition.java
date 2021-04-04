package com.prueba.stepdefinitions;

import com.prueba.questions.ValidarLista;
import com.prueba.task.ListadoAlbumes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.prueba.util.VariablesSesion.TOKEN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AlbumesStepDefinition {

    @Cuando("se consultan los albumes")
    public void seConsultanLosAlbumes() {
        OnStage.theActorInTheSpotlight().attemptsTo(ListadoAlbumes.con(Serenity.sessionVariableCalled(TOKEN)));
    }

    @Entonces("se valida el response")
    public void seValidaElResponse() {
        OnStage.theActorInTheSpotlight().should(seeThat("El response no devolvio un lista", ValidarLista.albumes()));
    }
}
