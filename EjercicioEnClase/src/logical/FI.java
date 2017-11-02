package logical;

/**
 *
 * @author 20160207
 */
public class FI extends Cuenta{
    /*La cuenta FI tiene un interÃ©s fijo otorgado 
    arbitrariamente el dÃ­a de apertura de la cuenta 
    y su interÃ©s se calcula el fijo% de monto que el
    banco le otorgÃ³ como fondo de inversiÃ³n x la cantidad 
    de meses que tiene abierta la cuenta
    */
    
    private double interesFijo;
    public FI(String codigo, int corteDelMes, int puntos, String estado, double saldo, double interesFijo) {
        super(codigo, corteDelMes, puntos, estado, saldo);
        this.interesFijo = interesFijo;
    }

    @Override
    public double obtenerInteres() {
        return interesFijo * mesesApertura;//OJO NO SÃ‰ SI ESO ESTÃ� BIEN
    }

    
    
}
