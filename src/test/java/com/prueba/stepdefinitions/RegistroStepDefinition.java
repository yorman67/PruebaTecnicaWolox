package com.prueba.stepdefinitions;

import com.prueba.task.Registra;
import com.prueba.util.Ayuda;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.MatcherAssert;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class RegistroStepDefinition {



    @Cuando("envia los datos correctos")
    public void enviaLosDatosCorrectos() {
        Ayuda ayuda = new Ayuda();
        String body = ayuda.convertirAJson(ayuda.datosNuevoUsuario());
        OnStage.theActorInTheSpotlight().attemptsTo(Registra.nuevoUsuario(body));
    }

    @Entonces("se valida la respuesta del servicio")
    public void seValidaLaRespuestaDelServicio() {
       OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(201)));
    }

    @Cuando("ingresa los datos no validos")
    public void ingresaLosDatosNoValidos(Map<String, String> datosRegistro) {
        Ayuda ayuda = new Ayuda();
        String body = ayuda.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Registra.nuevoUsuario(body));
    }


    @Cuando("ingrese los datos firstName y lastName con valores numericos")
    public void ingreseLosDatosFirstNameYLastNameConValoresNumericos() {
        Ayuda ayuda = new Ayuda();
        String body = ayuda.convertirAJson(ayuda.datosConValoresNumerico());
        OnStage.theActorInTheSpotlight().attemptsTo(Registra.nuevoUsuario(body));
    }

    @Entonces("No se deberia crear el usuario")
    public void noSeDeberiaCrearElUsuario() {
        OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(400)));
    }

}
