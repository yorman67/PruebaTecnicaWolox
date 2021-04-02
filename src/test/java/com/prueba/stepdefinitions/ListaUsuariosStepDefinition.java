package com.prueba.stepdefinitions;

import com.prueba.task.ListaUsuario;
import com.prueba.task.Logueo;
import com.prueba.util.Comunes;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

public class ListaUsuariosStepDefinition {

    @Cuando("se consulta la lista con las credenciales")
    public void seConsultaLaListaConLasCredenciales(Map<String, String> datosRegistro) {
        Comunes comunes = new Comunes();
        String body = comunes.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Logueo.usuario(body));
        String authorization = SerenityRest.lastResponse().header("Authorization");
        OnStage.theActorInTheSpotlight().attemptsTo(ListaUsuario.con(authorization));
    }

}
