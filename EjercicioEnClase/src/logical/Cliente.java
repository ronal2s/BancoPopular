package logical;

import java.util.ArrayList;

public class Cliente {
    /*De los clientes tenemos su cédula, nombre, apellidos, dirección y teléfono, así como la lista de todas las cuentas que posee
    */
    private String cedula, nombre, apellidos, direccion, telefono;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String cedula, String nombre, String apellidos, String direccion, String telefono, ArrayList<Cuenta> cuentas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuentas = cuentas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    /*La revisión mensual 
    de la cuenta hace lo siguiente: Saldo = saldo + intereses_cuenta – comisión. 
    Todas las cuentas tienen una comisión de 3€ por cada mes desde su apertura.
    */
    public double revision()
    {
        double saldoReal = 0;
        for (Cuenta cuenta : cuentas) {
            saldoReal = saldoReal + (cuenta.getSaldo() + cuenta.obtenerInteres() - cuenta.comision);
        }
        return saldoReal;
    }
    
}
