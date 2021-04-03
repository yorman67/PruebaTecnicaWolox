package com.prueba.stepdefinitions;

import com.prueba.task.ListaUsuario;
import com.prueba.task.Logueo;
import com.prueba.util.Comunes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.MatcherAssert;

import java.util.List;
import java.util.Map;

import static com.prueba.util.VariablesSesion.CORREO;
import static com.prueba.util.VariablesSesion.TOKEN;

public class ListaUsuariosStepDefinition {

    Comunes comunes = new Comunes();

    @Cuando("se consulta la lista con las credenciales")
    public void seConsultaLaListaConLasCredenciales(Map<String, String> datosRegistro) {
        Serenity.setSessionVariable(CORREO).to(datosRegistro.get("email"));
        String body = comunes.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Logueo.usuario(body));
        Serenity.setSessionVariable(TOKEN).to(SerenityRest.lastResponse().header("Authorization"));
        OnStage.theActorInTheSpotlight().attemptsTo(ListaUsuario.con(Serenity.sessionVariableCalled(TOKEN),1));
    }

    @Entonces("se valida que el response sea correcto")
    public void seValidaQueElResponseSeaCorrecto() {
        List<Map<String,String>>usuarios = SerenityRest.lastResponse().path("page");
        MatcherAssert.assertThat("El servicio retorno los usurarios de manera incorrecta",comunes.buscarUsuariosCorrectos(
                SerenityRest.lastResponse().path("total_pages"),
                SerenityRest.lastResponse().path("current_page"),
                usuarios,Serenity.sessionVariableCalled(CORREO)));
    }
}
