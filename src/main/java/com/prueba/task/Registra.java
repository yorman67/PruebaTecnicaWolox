package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

public class Registra implements Task {

    private final String body;

    public Registra(String body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users").with(request -> request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(body))
        );
    }

    public static Registra nuevoUsuario(String body){
        return Tasks.instrumented(Registra.class,body);
    }
}
