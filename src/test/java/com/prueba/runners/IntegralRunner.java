package com.prueba.runners;


import org.junit.Test;
import org.junit.runner.JUnitCore;

public class IntegralRunner {

    @Test
    public void ingralCompleta(){
        JUnitCore.runClasses(RegistroRunner.class);
        JUnitCore.runClasses(LoginRunner.class);
        JUnitCore.runClasses(ListaUsuarioRunner.class);
        JUnitCore.runClasses(AlbumesRunner.class);
        JUnitCore.runClasses(FotosAlbumesRunner.class);
        JUnitCore.runClasses(ConsultaCompraAlbumRunner.class);
        JUnitCore.runClasses(AlbumesCompradosRunner.class);
        JUnitCore.runClasses(InvalidarUsuarioRunner.class);
    }

}
