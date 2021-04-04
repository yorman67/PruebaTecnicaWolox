package com.prueba.stepdefinitions;

import com.prueba.task.Comprar;
import com.prueba.util.Ayuda;
import com.prueba.util.VariablesSesion;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.MatcherAssert;


public class CompraAlbumStepDefinition {

    @Cuando("se realiza la compra del album {string}")
    public void seRealizaLaCompraDelAlbum(String idAlbum) {
        OnStage.theActorInTheSpotlight().attemptsTo(Comprar.album(Serenity.sessionVariableCalled(VariablesSesion.TOKEN),idAlbum));
    }

    @Entonces("valdiar la funcionalidad")
    public void valdiarLaFuncionalidad() {
        Ayuda ayuda = new Ayuda();
        MatcherAssert.assertThat("Hubo un error comprando el album",ayuda.albumComprado());

    }
}
