package com.prueba.stepdefinitions;

import com.prueba.task.ListadoAlbumes;
import com.prueba.util.Ayuda;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.MatcherAssert;

import static com.prueba.util.VariablesSesion.TOKEN;

public class AlbumesStepDefinition {

    @Cuando("se consultan los albumes")
    public void seConsultanLosAlbumes() {
        OnStage.theActorInTheSpotlight().attemptsTo(ListadoAlbumes.con(Serenity.sessionVariableCalled(TOKEN)));
    }

    @Entonces("se valida el response")
    public void seValidaElResponse() {
        Ayuda ayuda = new Ayuda();
       MatcherAssert.assertThat("El response no devolvio un lista",!ayuda.listaAlbumes());
    }
}
