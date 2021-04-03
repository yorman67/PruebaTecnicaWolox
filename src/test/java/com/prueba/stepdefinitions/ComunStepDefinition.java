package com.prueba.stepdefinitions;

import com.prueba.task.Consultar;
import com.prueba.util.Ayuda;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;

public class ComunStepDefinition {

    private EnvironmentVariables env;

    @Dado("que el {word} establece la url base")
    public void queElAnalistaEstableceLaUrlBase(String actor) {
        String theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(env).getProperty("restapi.baseurl");;
        OnStage.theActorCalled(actor).whoCan(CallAnApi.at(String.valueOf(theRestApiBaseUrl)));
    }

    @Entonces("valido el esquema del response con el esquema {string}")
    public void validoElEsquemaDelResponseConElEsquemaEsquema(String esquema) {
        OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)
                .body(matchesJsonSchemaInClasspath(esquema))));
    }

    @Entonces("el servicio debe retornar un codigo valido")
    public void elServicioDebeRetornarUnCodigoValido() {
        OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)));
    }

    @Entonces("se valida que la respuesta contenga el {string} y el {int}")
    public void seValidaQueLaRespuestaContengaElYElCodigo(String error, int codigo) {
        OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(codigo)
                .body(containsString(error))));
    }

    @Y("consulta el token con credenciales")
    public void consultaElTokenConCredenciales(Map<String, String> credenciales) {
        Ayuda ayuda = new Ayuda();
        OnStage.theActorInTheSpotlight().attemptsTo(Consultar.token(ayuda.convertirAJson(credenciales)));
    }

}
