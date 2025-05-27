package co.edu.uniquindio.alquiler.model;

public class ConsultaDato {

    private int valor;
    private static ConsultaDato consulta;
    private int codigoProducto;

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

    public int getcodigoProducto() {
        return codigoProducto;
    }

    public void setcodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
}
