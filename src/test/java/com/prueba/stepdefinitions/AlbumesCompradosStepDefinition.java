package com.prueba.stepdefinitions;

import com.prueba.task.Compra;
import com.prueba.util.Ayuda;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.MatcherAssert;

import static com.prueba.util.VariablesSesion.TOKEN;
import static com.prueba.util.VariablesSesion.USUARIO_LOGUEADO;

public class AlbumesCompradosStepDefinition {

    @Cuando("se consultan los albumes comprados")
    public void seConsultanLosAlbumesComprados() {
        OnStage.theActorInTheSpotlight().attemptsTo(Compra.albumes(Serenity.sessionVariableCalled(TOKEN),
                Serenity.sessionVariableCalled(USUARIO_LOGUEADO)));
    }

    @Entonces("se valida que la respuesta sea correcta")
    public void seValidaQueLaRespuestaSeaCorrecta() {
        Ayuda ayuda = new Ayuda();
        MatcherAssert.assertThat("El response de comprar album no es correcto",!ayuda.albumesComprados());
    }

}
