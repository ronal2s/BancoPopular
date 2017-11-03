package logical;
public abstract class Cuenta {
    /*Hay tres tipos de cuenta: Cuenta_Corriente (CC), Cuenta_Vivienda (CV) y Fondo_Inversion (FI). */
    /*Las cuentas además posee código, meses de apertura y día de corte del mes y estado (habilitada, bloqueada o cancelada), */
    //Puntos
    protected String codigo;
    protected int mesesApertura;
    protected int corteDelMes;
    protected int puntos;
    protected String estado;
    protected int comision = 3;//3
    protected double saldo;
            
    public Cuenta(String codigo, int corteDelMes, int puntos, String estado, double saldo) {
        this.codigo = codigo;
        this.mesesApertura = 0;
        this.corteDelMes = corteDelMes;
        this.puntos = puntos;
        this.estado = estado;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void comisionMensual()
    {
        saldo = saldo - comision;
    }
            
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMesesApertura() {
        return mesesApertura;
    }

    public void setMesesApertura(int mesesApertura) {
        this.mesesApertura = mesesApertura;
    }

    public int getCorteDelMes() {
        return corteDelMes;
    }

    public void setCorteDelMes(int corteDelMes) {
        this.corteDelMes = corteDelMes;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public abstract double obtenerInteres();
   // public class abstract calcularInteres();
    
}
