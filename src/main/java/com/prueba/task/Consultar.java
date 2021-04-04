package com.prueba.task;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static com.prueba.util.VariablesSesion.TOKEN;
import static com.prueba.util.VariablesSesion.USUARIO_LOGUEADO;

public class Consultar implements Task {

    private String body;

    public Consultar(String body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Logueo.usuario(body));
        Serenity.setSessionVariable(TOKEN).to(SerenityRest.lastResponse().header("Authorization"));
         Map<String, String> usuario = SerenityRest.lastResponse().body().as(java.util.Map.class);
        Serenity.setSessionVariable(USUARIO_LOGUEADO).to(usuario);
    }

    public static Consultar token(String body){
        return Tasks.instrumented(Consultar.class,body);
    }

}
