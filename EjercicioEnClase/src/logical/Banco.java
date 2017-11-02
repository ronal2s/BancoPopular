package logical;

import java.util.ArrayList;

/**
 *
 * @author 20160207
 */
public class Banco {
    
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Cliente> clientes;
    private static Banco banco = null;
    
    private Banco() {
    	super();
        cuentas = new ArrayList<Cuenta>();
        clientes = new ArrayList<Cliente>();
    }
    
    public static Banco getInstance()
    {
    	if(banco == null)
    	{
    		banco = new Banco();
    	}
    	return banco;
    }
    //    private String cedula, nombre, apellidos, direccion, telefono;

    
    public void agregarCliente(String cedula, String nombre, String apellidos, String direccion, String telefono)
    {
    	Cliente cliente = new Cliente(cedula, nombre, apellidos, direccion, telefono, cuentas);
    	clientes.add(cliente);
    }
    
    public void agregarCuenta(Cliente cliente, Cuenta cuenta)
    {
    	ArrayList<Cuenta> cuentasCliente = cliente.getCuentas();
    	cuentasCliente.add(cuenta);
    }
    //C
    public double revision(String cedula)
    {
        Cliente cliente = buscarCliente(cedula);
        return cliente.revision();
    }
    /*Implemente el método retirar dinero para ellos el cliente 
introducirá el  número de cuenta y el monto a retirar. El sistema 
devolverá verdadero si pudo efectuar la operación o falso sino se 
pudo porque se han violado algunas de las restricciones del banco.
*/
    
    //D
    public boolean retirarDinero(String numeroCuenta, int montoRetiro)
    {
        Cuenta cuentaARetirar = getCuentaOfCliente(numeroCuenta);
        boolean retirado = false;
        if(cuentaARetirar.getEstado().equalsIgnoreCase("habilitada"))
        {
            double montoActual = cuentaARetirar.getSaldo();
            montoActual = montoActual - montoRetiro;
            cuentaARetirar.setSaldo(montoActual);
            retirado = true;
        }
        
        return retirado;
    }
    
    /*Implemente el método ingresar saldo, el cliente dirá el 
    número de cuenta y se procederá a efectuar todas las 
    actualizaciones correspondientes a la cuenta.*/
    //E
    public boolean ingresarDinero(String numeroCuenta, int montoIngreso)
    {
        boolean ingresado = false;
        Cuenta cuentaIngreso = getCuentaOfCliente(numeroCuenta);
        if(cuentaIngreso.getEstado().equalsIgnoreCase("habilitado"))
        {
            double saldoActual = cuentaIngreso.getSaldo();
            saldoActual += montoIngreso;
            cuentaIngreso.setSaldo(saldoActual);
        }
        return ingresado;
    }
    //F
    public int puntosAcumulados(String cedula)
    {
        Cuenta c = getCuentaOfCliente(cedula);
        int puntosAcumulado = c.getPuntos();
        return puntosAcumulado;
    }
    
    public Cuenta getCuentaOfCliente(String numeroCuenta)
    {
        int i=0;
        Cuenta c = null;
        while(i< cuentas.size() || c == null)
        {
            if(cuentas.get(i).getCodigo().equalsIgnoreCase(numeroCuenta))
            {
                c = cuentas.get(i);
            }
            i++;
        }
        return c;
    }
    
    public Cliente buscarCliente(String cedula)
    {
        boolean encontrado = false;
        int i = 0;
        Cliente c = null;
        while(i<clientes.size() || !encontrado)
        {
            if(clientes.get(i).getCedula().equalsIgnoreCase(cedula))
            {
                encontrado = true;
                c = clientes.get(i);
            }
            i++;
        }
        return c;
    }
    
}
