
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Banco {

    private List<Cuenta> lstCuentas = new ArrayList<Cuenta>();

    //metodos
    public Banco() {
    }

    public boolean CrearCuenta(Cuenta cta) {
        boolean creada = false;
        boolean val = validarCuenta(cta);
        if (!val) {
            this.lstCuentas.add(cta);
            creada = true;
        }
        return creada;
    }

    public Cuenta BuscarCuenta(String num) {
        Cuenta cta = null;

        for (Cuenta c : this.lstCuentas) {
            if (c.getNumero().equals(num)) {
                cta = new Cuenta();
                cta = c;
                break;
            }
        }
        return cta;
    }

    public boolean ModificarCuenta(Cuenta cta) {
        boolean modificada = false;
        for (int i = 0; i < this.lstCuentas.size(); i++) {
            if (this.lstCuentas.get(i).getNumero().equals(cta.getNumero())) {
                this.lstCuentas.add(i, cta);
                modificada = true;
                break;
            }
        }
        return modificada;
    }

    public boolean EliminarCuenta(Cuenta cta) {
        boolean eliminada = false;
        for (int i = 0; i < this.lstCuentas.size(); i++) {
            if (this.lstCuentas.get(i).getNumero().equals(cta.getNumero())) {
                this.lstCuentas.remove(i);
                eliminada = true;
                break;
            }
        }
        return eliminada;
    }

    public boolean validarCuenta(Cuenta cta) {
        boolean existe = false;
        for (Cuenta c : lstCuentas) {
            if (c.getNumero().equals(cta.getNumero())) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public double Transaccion(String numeroCta, double valor, String tipoTra) {
        for (int i = 0; i < this.lstCuentas.size(); i++) {
            if (this.lstCuentas.get(i).getNumero().equals(numeroCta)) {
                switch (tipoTra) {
                    case "Consignar": {
                        if(this.lstCuentas.get(i).Consignar(valor)) {
                            //this.lstCuentas.get(i).Consignar(valor);
                            JOptionPane.showMessageDialog(null, "Consignación realizada con éxito");
                            this.lstCuentas.get(i).setSaldo(this.lstCuentas.get(i).getSaldo() - valor);
                            //JOptionPane.showMessageDialog(null, this.lstCuentas.get(i).getSaldo());
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "No se puedo realizar la consignación");
                            JOptionPane.showMessageDialog(null, this.lstCuentas.get(i).getSaldo());
                        }
                        return this.lstCuentas.get(i).getSaldo();
                    }
                    case "Retirar": {
                        if(this.lstCuentas.get(i).Retirar(valor)) {
                            //this.lstCuentas.get(i).Retirar(valor);
                            JOptionPane.showMessageDialog(null, "Retiro exitoso");
                            //this.lstCuentas.get(i).setSaldo(this.lstCuentas.get(i).getSaldo() - valor);
                            //JOptionPane.showMessageDialog(null, this.lstCuentas.get(i).getSaldo());
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "No se puedo realizar el retiro");
                            JOptionPane.showMessageDialog(null, this.lstCuentas.get(i).getSaldo());
                        }
                        
                        return this.lstCuentas.get(i).getSaldo();
                    }
                    case "Saldo": {
                        JOptionPane.showMessageDialog(null, this.lstCuentas.get(i).getSaldo());
                        return this.lstCuentas.get(i).getSaldo();
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Ingrese una opción váida...");
                        return this.lstCuentas.get(i).getSaldo();
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Esta cuenta no existe");
                return this.lstCuentas.get(i).getSaldo();
            }
        }
        return 0;
    }
}
