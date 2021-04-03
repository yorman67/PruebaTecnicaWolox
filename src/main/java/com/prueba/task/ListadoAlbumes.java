package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpHeaders;

public class ListadoAlbumes implements Task {

    private String token;

    public ListadoAlbumes(String token) {
        this.token = token;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/albums")
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation())
        );
    }

    public static ListadoAlbumes con (String token){
        return Tasks.instrumented(ListadoAlbumes.class,token);
    }

}
