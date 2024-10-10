package com.swapi.principal;

import com.google.gson.Gson;
import com.swapi.modelo.Pelicula;

import java.io.IOException;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    public static void main(String[] args) {

        Gson gson = new Gson();
        try {

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);
            Pelicula miPelicula = gson.fromJson(json, Pelicula.class);
            System.out.println(miPelicula);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en la URI, verifique la dirección");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
