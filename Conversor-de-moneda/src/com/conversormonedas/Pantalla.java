package com.conversormonedas;

import javax.lang.model.util.ElementScanner6;
import java.util.Scanner;

public class Pantalla {

    private Scanner teclado;

    public Pantalla() {
        this.teclado = new Scanner(System.in);
    }

    public static void bienvenida() {
        System.out.println("       Gracias por usar AppConversor!");
    }

    public static void menu() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("| Opcion *  Nombre                       |");
        System.out.println("|----------------------------------------|");
        System.out.println("|   1    |  Peso mexicano (MXN)          |");
        System.out.println("|   2    |  Boliviano boliviano (BOB)    |");
        System.out.println("|   3    |  Real brasileño (BRL)         |");
        System.out.println("|   4    |  Peso chileno (CLP)           |");
        System.out.println("|   5    |  Peso colombiano (COP)        |");
        System.out.println("|   6    |  Dólar estadounidense (USD)   |");
        System.out.println("|   7    |  SALIR                        |");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("     Selecciona una opción de moneda:");
    }

    public String  leerTeclado() {
        String lineaLeida = this.teclado.nextLine();
        return lineaLeida;
    }

    public boolean validarOpcion(String opcion) {
        int opcionInt = Integer.parseInt(opcion);
        if (opcionInt >= 1 && opcionInt <= 6) {
          return true;
        }
        return false;
    }

    public boolean esOpcionSalida(String opcion) {
        int opcionInt = Integer.parseInt(opcion);
        if (opcionInt == 7 ) {
            return true;
        }
        return false;
    }

    public static void mensajeDespedida() {
        System.out.println("       Hasta pronto!");
    }

    public static void mensajeOpcionInvalida() {
        System.out.println("      Opción inválida!");
    }


    public static void mensajeSegundaMoneda(String moneda) {
        String salida = "Selecciono %s, ahora elija el cambio de moneda: ";
        System.out.println(String.format(salida, moneda));
    }

    public static void mensajeConversion(Conversor conversor) {
        String salida = "Convertir %.2f(%s) equivale a %.2f(%s)\n\n\n";
        System.out.println(String.format(salida, conversor.getMonto(), conversor.getCodigoMonedaInicial(), conversor.getConversion(), conversor.getCodigoMonedaFinal()));
    }

    public static void mensajeIngreseMonto() {
        System.out.println("      Ingresa el monto que deseas convertir:");
    }


}
