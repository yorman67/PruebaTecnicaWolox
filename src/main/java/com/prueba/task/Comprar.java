package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

public class Comprar implements Task {

    private String token;
    private String idAlbum;

    public Comprar(String token, String idAlbum) {
        this.token = token;
        this.idAlbum = idAlbum;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/albums/".concat(idAlbum))
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation()
                                .body("{}"))
        );
    }

    public static Comprar album(String token, String idAlbum){
        return Tasks.instrumented(Comprar.class,token,idAlbum);
    }
}
