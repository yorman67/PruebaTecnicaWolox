package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

public class Invalidar implements Task {

    private String token;

    public Invalidar(String token) {
        this.token = token;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users/sessions/invalidate_all")
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation()
                                .body("{}"))
        );
    }

    public static  Invalidar usuario(String token){
        return Tasks.instrumented(Invalidar.class,token);
    }
}
