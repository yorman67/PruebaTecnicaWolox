package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpHeaders;

import java.util.Map;

public class Compra implements Task {

    private String token;
    private  Map<String,String> usuarioLogueado;

    public Compra(String token,  Map<String,String> usuarioLogueado) {
        this.token = token;
        this.usuarioLogueado = usuarioLogueado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users/".concat(String.valueOf(usuarioLogueado.get("user_id"))).concat("/albums"))
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation())
        );
    }

    public static Compra albumes(String token, Map<String,String> usuarioLogueado){
        return Tasks.instrumented(Compra.class,token,usuarioLogueado);
    }
}
