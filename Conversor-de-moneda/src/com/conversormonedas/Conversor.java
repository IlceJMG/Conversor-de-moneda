package com.conversormonedas;

public class Conversor {

    private String codigoMonedaInicial;
    private String codigoMonedaFinal;
    private float monto;
    private float conversion;

    public Conversor() {

    }



    public String obtenerCodigoMoneda(String opcion) {
        Integer opcionInt = Integer.parseInt(opcion);
        String codigoMoneda = "";
        switch (opcionInt) {
            case 1:
                codigoMoneda = "MXN";
                break;
                case 2:
                    codigoMoneda = "BOB";
                    break;
                    case 3:
                        codigoMoneda = "BRL";
                        break;
                        case 4:
                            codigoMoneda = "CLP";
                            break;
                            case 5:
                                codigoMoneda = "COP";
                                break;
                                case 6:
                                    codigoMoneda = "USD";
                                    break;
        }
        return codigoMoneda;
    }

    public String getCodigoMonedaInicial() {
        return codigoMonedaInicial;
    }

    public void setCodigoMonedaInicial(String codigoMonedaInicial) {
        this.codigoMonedaInicial = codigoMonedaInicial;
    }

    public String getCodigoMonedaFinal() {
        return codigoMonedaFinal;
    }

    public void setCodigoMonedaFinal(String codigoMonedaFinal) {
        this.codigoMonedaFinal = codigoMonedaFinal;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getConversion() {
        return conversion;
    }

    public void setConversion(float conversion) {
        this.conversion = conversion;
    }
}
