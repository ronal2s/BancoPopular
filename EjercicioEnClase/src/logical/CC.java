package logical;

/**
 *
 * @author 20160207
 */
public class CC extends Cuenta{

	private double montoMaximo;
	
    public CC(String codigo, int corteDelMes, int puntos, String estado, double saldo, double montoMaximo) {
        super(codigo, corteDelMes, puntos, estado, saldo);
        this.montoMaximo = montoMaximo;
    }
//el interés se calcula 10% de ese monto máximo antes citado x cantidad de meses que se encuentre abierta la cuenta
    @Override
    public double obtenerInteres() {
        return montoMaximo*0.10*mesesApertura;
    }
    
}
