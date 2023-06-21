
import java.util.Date;

//import java.util.Calendar;

public class Cuenta {

    private String Numero;
    private String Titular;
    private Date FechaApertura;
    private double Saldo;
    private Date FechaUM;
    private String Clave;
    private boolean Estado;

    public Cuenta() {
    }

    public Cuenta(String num, String tit, Date FecA, double sal, Date UlM, String cla, boolean est) {
        this.Numero = num;
        this.Titular = tit;
        this.FechaApertura = FecA;
        this.Saldo = sal;
        this.FechaUM = UlM;
        this.Clave = cla;
        this.Estado = est;
    }

    public String getNumero() {
        return this.Numero;
    }

    public void setNumero(String numero) {
        this.Numero = numero;
    }

    public String getTitular() {
        return this.Titular;
    }

    public void setTitular(String tit) {
        this.Titular = tit;
    }

    public Date getFechaApertura() {
        return this.FechaApertura;
    }

    public void setFechaApertura(Date fec) {
        this.FechaApertura = fec;
    }

    public double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(double sal) {
        this.Saldo = sal;
    }

    public Date getFechaUM() {
        return this.FechaUM;
    }

    public void setFechaUM(Date fec) {
        this.FechaUM = fec;
    }

    public String getClave() {
        return this.Clave;
    }

    public void setClave(String cla) {
        this.Clave = cla;
    }

    public boolean getEstado() {
        return this.Estado;
    }

    public void setEstado(boolean est) {
        this.Estado = est;
    }

    public boolean Consignar(double valor) {
        boolean consignado = false;

        if (this.Saldo - valor >= 0) {
            consignado = true;
        }

        return consignado;
    }

    public boolean Retirar(double valor) {
        boolean retirado = false;

        if (this.Saldo >= valor) {
            this.Saldo -= valor;
            retirado = true;
        }

        return retirado;
    }
}
