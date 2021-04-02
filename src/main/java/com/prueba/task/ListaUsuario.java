package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import org.apache.http.HttpHeaders;

public class ListaUsuario implements Task {

    private final String token;

    public ListaUsuario(String token) {
        this.token = token;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users")
                        .with(request -> request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation())
        );
    }

    public static ListaUsuario con (String token){
        return Tasks.instrumented(ListaUsuario.class,token);
    }
}
