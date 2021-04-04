package com.prueba.questions;

import com.prueba.util.Ayuda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarLista implements Question<Boolean> {

    Ayuda ayuda = new Ayuda();

    @Override
    public Boolean answeredBy(Actor actor) {
        return !ayuda.listaAlbumes();
    }

    public static ValidarLista albumes(){
        return new ValidarLista ();
    }
}
