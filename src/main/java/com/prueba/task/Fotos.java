package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpHeaders;

public class Fotos implements Task {

    private String token;
    private String idAlbum;

    public Fotos(String token, String idAlbum) {
        this.token = token;
        this.idAlbum = idAlbum;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/albums/".concat(idAlbum).concat("/photos"))
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation())
        );
    }

    public static Fotos album (String token,String idAlbum){
        return Tasks.instrumented(Fotos.class,token,idAlbum);
    }
}
