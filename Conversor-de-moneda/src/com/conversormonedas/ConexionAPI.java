package com.conversormonedas;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAPI {

    private String response;

    private JsonElement root;

    public ConexionAPI(String baseCode) {
        String direccion = "https://v6.exchangerate-api.com/v6/71a81f05fd25f85b4b492949/latest/" + baseCode;
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            this.response = response.body();
            leeRespuesta();
        } catch (IOException e) {
            System.out.println("Error al obtener el recurso");
        } catch (InterruptedException e) {
            System.out.println("Interrupción al obtener el recurso");
        }
    }

    public String getResponse() {
        return response;
    }


    public void leeRespuesta() {
        JsonParser jp = new JsonParser();
        root = jp.parse(this.response);

    }
    public float obtenMonto(String codigoMonedaFinal) {
        JsonObject jsonobj = root.getAsJsonObject();
        JsonObject tipoMonedas = jsonobj.get("conversion_rates").getAsJsonObject();
        float monto = tipoMonedas.get(codigoMonedaFinal).getAsFloat();
        return monto;
    }



}
