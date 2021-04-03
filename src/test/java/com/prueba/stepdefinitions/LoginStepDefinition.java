package com.prueba.stepdefinitions;

import com.prueba.task.Logueo;
import com.prueba.util.Comunes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.MatcherAssert;
import java.util.Map;

public class LoginStepDefinition {

    @Cuando("ingresa las credenciales")
    public void ingresaLasCredenciales(Map<String, String> datosRegistro) {
        Comunes comunes = new Comunes();
        String body = comunes.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Logueo.usuario(body));
    }

    @Entonces("se valida los datos del header")
    public void seValidaLosDatosDelHeader() {
        String authorization = SerenityRest.lastResponse().header("Authorization");
        MatcherAssert.assertThat("El campo Autorizacion se encuentra vacio",!authorization.isEmpty());
    }


}
