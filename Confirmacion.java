public class Confirmacion{
    private String tarjeta;
    private int cuotas;
    private boolean isPrimeraClase;
    private String numeroAsiento;
    private int cantidadMaletas;

    public Confirmacion(String tarjeta, int cuotas, boolean isPrimeraClase, String numeroAsiento, int cantidadMaletas){
        this.tarjeta = tarjeta;
        this.cuotas = cuotas;
        this.isPrimeraClase = isPrimeraClase;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public boolean isPrimeraClase() {
        return isPrimeraClase;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public void setPrimeraClase(boolean isPrimeraClase) {
        this.isPrimeraClase = isPrimeraClase;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    public String toString(){
        return "Número de tarjeta: " + this.tarjeta +
                " Cantidad de cuotas: " + this.cuotas +
                " " + traducirClase() +
                " Número de asiento: " + this.numeroAsiento + 
                " Cantidad de maletas: " + this.cantidadMaletas;
    }

    public String traducirClase(){
        if(isPrimeraClase){
            return "Primera Clase";
        }
        return "Clase Coach";

    }
}