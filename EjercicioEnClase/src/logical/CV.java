/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logical;

/**
 *
 * @author 20160207
 */
public class CV extends Cuenta{
//De la CV se conoce además el tiempo que durará ahorrando dinero (en meses) y el monto que usted ingresará mensual a ese ahorro
    
    private int tiempoADurar;
    private double montoMensual;
    
    public CV(String codigo, int mesesApertura, int corteDelMes, int puntos, String estado, double saldo, int tiempoADurar, double montoMensual) {
        super(codigo, mesesApertura, corteDelMes, puntos, estado, saldo);
        this.tiempoADurar = tiempoADurar;
        this.montoMensual = montoMensual;
    }
//El interés de la cuenta CV se calcula 
    //el 3% del monto que usted ingresa mensual x la cantidad de meses que se encuentre abierta la cuenta
    @Override
    public double obtenerInteres() {
        return (montoMensual*0.3)*mesesApertura;
    }
    
}
