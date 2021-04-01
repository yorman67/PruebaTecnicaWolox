package com.prueba.util;

import com.github.javafaker.Faker;
import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Comunes {

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

}
