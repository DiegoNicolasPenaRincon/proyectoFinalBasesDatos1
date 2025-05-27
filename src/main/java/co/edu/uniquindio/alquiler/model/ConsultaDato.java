package co.edu.uniquindio.alquiler.model;

public class ConsultaDato {

    private int valor;
    private static ConsultaDato consulta;
    private int codigoUniversal;

    private ConsultaDato(){
    }

    public static ConsultaDato getInstance(){
        if(consulta == null)
        {
            consulta = new ConsultaDato();
        }

        return consulta;
    }


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getcodigoUniversal() {
        return codigoUniversal;
    }

    public void setcodigoUniversal(int codigoUniversal) {
        this.codigoUniversal = codigoUniversal;
    }
}
