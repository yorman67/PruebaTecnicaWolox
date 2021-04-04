package com.prueba.questions;

import com.prueba.util.Ayuda;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static com.prueba.util.VariablesSesion.CORREO;

public class ValdiarResponse implements Question<Boolean> {

    Ayuda ayuda = new Ayuda();

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Map<String,String>> usuarios = SerenityRest.lastResponse().path("page");
        return ayuda.buscarUsuariosCorrectos(
                SerenityRest.lastResponse().path("total_pages"),
                SerenityRest.lastResponse().path("current_page"),
                usuarios, Serenity.sessionVariableCalled(CORREO));
    }

    public static ValdiarResponse correcta (){
        return new ValdiarResponse();
    }
}
