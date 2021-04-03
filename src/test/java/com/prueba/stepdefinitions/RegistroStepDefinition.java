package com.prueba.stepdefinitions;

import com.prueba.task.Registra;
import com.prueba.util.Comunes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;


public class RegistroStepDefinition {



    @Cuando("envia los datos correctos")
    public void enviaLosDatosCorrectos() {
        Comunes comunes = new Comunes();
        String body = comunes.convertirAJson(comunes.datosNuevoUsuario());
        OnStage.theActorInTheSpotlight().attemptsTo(Registra.nuevoUsuario(body));
    }

    @Entonces("se valida la respuesta del servicio")
    public void seValidaLaRespuestaDelServicio() {
       OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(201)));
    }

    @Cuando("ingresa los datos no validos")
    public void ingresaLosDatosNoValidos(Map<String, String> datosRegistro) {
        Comunes comunes = new Comunes();
        String body = comunes.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Registra.nuevoUsuario(body));
    }


    @Cuando("ingrese los datos firstName y lastName con valores numericos")
    public void ingreseLosDatosFirstNameYLastNameConValoresNumericos() {
        Comunes comunes = new Comunes();
        String body = comunes.convertirAJson(comunes.datosConValoresNumerico());
        OnStage.theActorInTheSpotlight().attemptsTo(Registra.nuevoUsuario(body));
    }

    @Entonces("No se deberia crear el usuario")
    public void noSeDeberiaCrearElUsuario() {
        OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(400)));
    }

}
