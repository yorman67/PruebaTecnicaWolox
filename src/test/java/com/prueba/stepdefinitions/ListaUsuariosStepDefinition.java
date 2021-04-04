package com.prueba.stepdefinitions;

import com.prueba.questions.ValdiarResponse;
import com.prueba.task.Consultar;
import com.prueba.task.ListaUsuario;
import com.prueba.util.Ayuda;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import java.util.Map;

import static com.prueba.util.VariablesSesion.CORREO;
import static com.prueba.util.VariablesSesion.TOKEN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ListaUsuariosStepDefinition {

    Ayuda ayuda = new Ayuda();

    @Cuando("se consulta la lista con las credenciales")
    public void seConsultaLaListaConLasCredenciales(Map<String, String> datosRegistro) {
        Serenity.setSessionVariable(CORREO).to(datosRegistro.get("email"));
        String body = ayuda.convertirAJson(datosRegistro);
        OnStage.theActorInTheSpotlight().attemptsTo(Consultar.token(body));
        OnStage.theActorInTheSpotlight().attemptsTo(ListaUsuario.con(Serenity.sessionVariableCalled(TOKEN),1));
    }

    @Cuando("se ingresa token invalido")
    public void seIngresaTokenInvalido() {
        OnStage.theActorInTheSpotlight().attemptsTo(ListaUsuario.con("2346364575978",1));
    }

    @Cuando("se ingresa pagina que no existe")
    public void seIngresaPaginaQueNoExiste() {
        OnStage.theActorInTheSpotlight().attemptsTo(ListaUsuario.con(Serenity.sessionVariableCalled(TOKEN),3000));
    }

    @Entonces("se valida que el response sea correcto")
    public void seValidaQueElResponseSeaCorrecto() {
        OnStage.theActorInTheSpotlight().should(seeThat("El servicio retorno los usurarios de manera incorrecta : "
                + SerenityRest.lastResponse().body().asString(), ValdiarResponse.correcta()));
    }



}
