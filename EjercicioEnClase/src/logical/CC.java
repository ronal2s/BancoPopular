package logical;

/**
 *
 * @author 20160207
 */
public class CC extends Cuenta{

    public CC(String codigo, int mesesApertura, int corteDelMes, int puntos, String estado, double saldo) {
        super(codigo, mesesApertura, corteDelMes, puntos, estado, saldo);
    }
//el interés se calcula 10% de ese monto máximo antes citado x cantidad de meses que se encuentre abierta la cuenta
    @Override
    public double obtenerInteres() {
        return saldo*0.10*mesesApertura;
    }
    
}
