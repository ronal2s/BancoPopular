package logical;

/**
 *
 * @author 20160207
 */
public class FI extends Cuenta{
    /*La cuenta FI tiene un interés fijo otorgado 
    arbitrariamente el día de apertura de la cuenta 
    y su interés se calcula el fijo% de monto que el
    banco le otorgó como fondo de inversión x la cantidad 
    de meses que tiene abierta la cuenta
    */
    
    private double interesFijo;
    public FI(String codigo, int mesesApertura, int corteDelMes, int puntos, String estado, double saldo, double interesFijo) {
        super(codigo, mesesApertura, corteDelMes, puntos, estado, saldo);
        this.interesFijo = interesFijo;
    }

    @Override
    public double obtenerInteres() {
        return interesFijo * mesesApertura;//OJO NO SÉ SI ESO ESTÁ BIEN
    }

    
    
}
