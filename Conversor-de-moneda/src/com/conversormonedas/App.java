package com.conversormonedas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();
        Pantalla.bienvenida();
        boolean esOpcionCorrecta = false;
        boolean ejecutando = true;
        do {
            Pantalla.menu();
            Conversor conversor = new Conversor();
            String lineaLeida;
            do {
                lineaLeida = pantalla.leerTeclado();
                if (pantalla.esOpcionSalida(lineaLeida)) {
                    ejecutando = false;
                    break;
                }
                esOpcionCorrecta = pantalla.validarOpcion(lineaLeida);
                if (!esOpcionCorrecta) {
                    Pantalla.mensajeOpcionInvalida();
                    continue;
                }
                String monedaInicial =  conversor.obtenerCodigoMoneda(lineaLeida);
                conversor.setCodigoMonedaInicial(monedaInicial);
            } while (!esOpcionCorrecta);

            if (pantalla.esOpcionSalida(lineaLeida)) {
                ejecutando = false;
                break;
            }

            Pantalla.mensajeSegundaMoneda(conversor.getCodigoMonedaInicial());
            do {
                lineaLeida = pantalla.leerTeclado();
                if (pantalla.esOpcionSalida(lineaLeida)) {
                    ejecutando = false;
                    break;
                }
                esOpcionCorrecta = pantalla.validarOpcion(lineaLeida);
                if (!esOpcionCorrecta) {
                    Pantalla.mensajeOpcionInvalida();
                    continue;
                }
                String monedaFinal =  conversor.obtenerCodigoMoneda(lineaLeida);
                conversor.setCodigoMonedaFinal(monedaFinal);
            } while (!esOpcionCorrecta);

            if (pantalla.esOpcionSalida(lineaLeida)) {
                ejecutando = false;
                break;
            }
            Pantalla.mensajeIngreseMonto();
            lineaLeida = pantalla.leerTeclado();
            float monto = Float.parseFloat(lineaLeida);
            conversor.setMonto(monto);
            ConexionAPI api = new ConexionAPI(conversor.getCodigoMonedaInicial());
            float valorMonedaFinal =  api.obtenMonto(conversor.getCodigoMonedaFinal());
            conversor.setConversion(conversor.getMonto() * valorMonedaFinal);
            Pantalla.mensajeConversion(conversor);

        } while(ejecutando);

        Pantalla.mensajeDespedida();

    }





}
