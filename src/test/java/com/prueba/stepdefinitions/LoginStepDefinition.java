package com.prueba.stepdefinitions;

import com.prueba.task.Logueo;
import com.prueba.util.Comunes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class LoginStepDefinition {

    @Cuando("ingresa las credenciales")
    public void ingresaLasCredenciales(Map<String, String> datosRegistro) {
        Comunes comunes = new Comunes();
        String body = comunes.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Logueo.usuario(body));
    }

    @Entonces("el servicio debe retornar un codigo valido")
    public void elServicioDebeRetornarUnCodigoValido() {
        OnStage.theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(200)));
    }
}
