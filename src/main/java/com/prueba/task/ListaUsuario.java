package com.prueba.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import org.apache.http.HttpHeaders;

public class ListaUsuario implements Task {

    private final String token;
    private final int pagina;

    public ListaUsuario(String token, int pagina) {
        this.token = token;
        this.pagina = pagina;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users")
                        .with(request -> request
                                .queryParam("page",pagina )
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .header("Authorization",token)
                                .relaxedHTTPSValidation())
        );
    }

    public static ListaUsuario con (String token, int pagina){
        return Tasks.instrumented(ListaUsuario.class,token,pagina);
    }
}
