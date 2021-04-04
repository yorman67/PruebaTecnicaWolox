package com.prueba.util;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.prueba.task.ListaUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.*;

import static com.prueba.util.VariablesSesion.ID_ALBUMES;
import static com.prueba.util.VariablesSesion.TOKEN;

public class Ayuda {

    private final Faker fake = Faker.instance(new Locale("es"), new Random());

    public  Map <String,Object> datosNuevoUsuario(){
        Map<String, Object> mapInfoRegister = new HashMap<String, Object>();
        mapInfoRegister.put("email",fake.name().username().concat("@wolox.com.ar"));
        mapInfoRegister.put("password",fake.name().username().concat(fake.number().digits(2)));
        mapInfoRegister.put("firstName",fake.name().firstName());
        mapInfoRegister.put("lastName",fake.name().lastName());
        return mapInfoRegister;
    }

    public Map <String,Object> datosConValoresNumerico(){
        Map<String, Object> mapInfoRegister = new HashMap<String, Object>();
        mapInfoRegister.put("email",fake.name().username().concat("@wolox.com.ar"));
        mapInfoRegister.put("password",fake.name().username().concat(fake.number().digits(2)));
        mapInfoRegister.put("firstName",fake.number().numberBetween(1,10));
        mapInfoRegister.put("lastName",fake.number().numberBetween(1,10));
        return mapInfoRegister;
    }

    public String convertirAJson(Object dataTableBody) {
        Gson gson = new Gson();
        return gson.toJson(dataTableBody);
    }

    public boolean admin( List<Map<String,String>> usuarios,int paginaActual,int pagina){
        boolean existeAdmin;

        for (int i = paginaActual; i < pagina; i++) {

            existeAdmin = usuarios.stream().anyMatch(item -> item.get("role").equals("admin"));

            if(existeAdmin) return true;

            OnStage.theActorInTheSpotlight().attemptsTo(
                    ListaUsuario.con(Serenity.sessionVariableCalled(TOKEN),i+1));

            usuarios=SerenityRest.lastResponse().path("page");
        }
        return false;
    }

    public boolean regular( List<Map<String,String>> usuarios,int paginaActual,int pagina){
        boolean existeAdmin;

        for (int i = paginaActual; i < pagina; i++) {

            existeAdmin = usuarios.stream().anyMatch(item -> item.get("role").equals("admin"));

            if(existeAdmin) return false;

            OnStage.theActorInTheSpotlight().attemptsTo(
                    ListaUsuario.con(Serenity.sessionVariableCalled(TOKEN),i+1));

            usuarios=SerenityRest.lastResponse().path("page");
        }
        return true;
    }

    public boolean buscarUsuariosCorrectos(int paginas,int paginaActual, List<Map<String,String>> usuarios, String tipoUsuario ){

        if(tipoUsuario.equals("admin@wolox.com.ar")){
            return admin(usuarios,paginaActual,paginas);
        }else {
            return regular(usuarios,paginaActual,paginas);
        }
    }

    public boolean listaAlbumes () {
        List<Map<String, Object>> albumnes = SerenityRest.lastResponse().getBody().as(List.class);
        Serenity.setSessionVariable(ID_ALBUMES).to(albumnes);
        return  albumnes.isEmpty();
    }
}
