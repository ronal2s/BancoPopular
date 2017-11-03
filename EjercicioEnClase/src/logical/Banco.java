package logical;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;

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

    public ArrayList<Cliente> getClientes()
    {
    	return clientes;
    }
    public ArrayList<Cuenta> getCuentas()
    {
    	return cuentas;
    }
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
    	int i = getCuentaOfCliente(numeroCuenta);
        Cuenta cuentaARetirar = cuentas.get(i);
        boolean retirado = false;
        double montoActual = -1;
        if(cuentaARetirar.getEstado().equalsIgnoreCase("habilitada"))
        {
        	montoActual = cuentaARetirar.getSaldo();

        	if(cuentaARetirar instanceof CC && montoRetiro > cuentaARetirar.getSaldo())
        	{
        		JOptionPane.showMessageDialog(null, "No puedes retirar esta cantidad de dinero");
        	}
        	else
        	{
	            montoActual = montoActual - montoRetiro;
	            cuentaARetirar.setSaldo(montoActual);
	            retirado = true;
        	}
        	if(cuentaARetirar instanceof FI) 
        	{
        		if(montoRetiro > 500)
        		{
            		montoActual = (montoActual - montoRetiro) - (montoRetiro * 0.1) ;
            		cuentaARetirar.setSaldo(montoActual);

        		}
        		else
        		{
        			montoActual = montoActual - montoRetiro;
        			cuentaARetirar.setSaldo(montoActual);
        		}
        		retirado = true;
        	}
        	
        	if(cuentaARetirar instanceof CV)
        	{
        		JOptionPane.showMessageDialog(null, "No se puede retirar dinero de esta cuenta");
        		retirado = false;
        	}
        		

        }
        if(retirado)
        	JOptionPane.showMessageDialog(null, "Retirado correctamente");
        
        return retirado;
    }
    
    /*Implemente el método ingresar saldo, el cliente dirá el 
    número de cuenta y se procederá a efectuar todas las 
    actualizaciones correspondientes a la cuenta.*/
    //E
    public boolean ingresarDinero(String numeroCuenta, int montoIngreso)
    {
        boolean ingresado = false;
        try
        {
        	int i = getCuentaOfCliente(numeroCuenta);
	        Cuenta cuentaIngreso = cuentas.get(i);
	        if(cuentaIngreso.getEstado().equalsIgnoreCase("habilitada"))
	        {
	            double saldoActual = cuentaIngreso.getSaldo();
	            saldoActual += montoIngreso;
	            cuentaIngreso.setSaldo(saldoActual);
	            cuentaIngreso.setPuntos(cuentaIngreso.getPuntos() + (montoIngreso/10));
	        	JOptionPane.showMessageDialog(null, "Retirado correctamente");

	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(null, "Cuenta no habilitada ");
	        }
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Cuenta no existe");
        }
        return ingresado;
    }
    //F
    public int puntosAcumulados(String codigo)
    {
    	int i = getCuentaOfCliente(codigo);
    	
        return cuentas.get(i).getPuntos();
    }
    
    public int getCuentaOfCliente(String numeroCuenta)
    {
        int i=0;
        int pos = -1;
        while(i< cuentas.size() || pos == -1)
        {
            if(cuentas.get(i).getCodigo().equalsIgnoreCase(numeroCuenta))
            {
                pos = i;
            }
            i++;
        }
        return pos;
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
