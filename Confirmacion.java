public class Confirmacion{
    private String tarjeta;
    private int cuotas;
    private boolean isPrimeraClase;
    private String numeroAsiento;
    private int cantidadMaletas;

    
    /** 
     * @param tarjeta
     * @param cuotas
     * @param isPrimeraClase
     * @param numeroAsiento
     * @param cantidadMaletas
     * @description Constructor con parámetros requeridos para la creación de este tipo de objeto y evitar errores al añadirlo a listas.
     */
    public Confirmacion(String tarjeta, int cuotas, boolean isPrimeraClase, String numeroAsiento, int cantidadMaletas){
        this.tarjeta = tarjeta;
        this.cuotas = cuotas;
        this.isPrimeraClase = isPrimeraClase;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
    }

    
    /** 
     * @return String
     * @description geter
     */
    public String getTarjeta() {
        return tarjeta;
    }

    
    /** 
     * @return int
     * @description geter
     */
    public int getCuotas() {
        return cuotas;
    }

    
    /** 
     * @return boolean
     * @description geter
     */
    public boolean isPrimeraClase() {
        return isPrimeraClase;
    }

    
    /** 
     * @return String
     * @description geter
     */
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    
    /** 
     * @return int
     * @description geter
     */
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    
    /** 
     * @param tarjeta
     * @description seter
     */
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    
    /** 
     * @param cuotas
     * @description seter
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    
    /** 
     * @param isPrimeraClase
     * @description seter
     */
    public void setPrimeraClase(boolean isPrimeraClase) {
        this.isPrimeraClase = isPrimeraClase;
    }

    
    /** 
     * @param numeroAsiento
     * @description seter
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    
    /** 
     * @param cantidadMaletas
     * @description seter
     */

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    
    /** 
     * @return String
     * @description Devuelve un String con la información del obejto
     */
    public String toString(){
        return "Número de tarjeta: " + this.tarjeta +
                " Cantidad de cuotas: " + this.cuotas +
                " " + traducirClase() +
                " Número de asiento: " + this.numeroAsiento + 
                " Cantidad de maletas: " + this.cantidadMaletas;
    }

    
    /** 
     * @return String
     * @description El atributo isPrimeraClase es verdadero si el tipo de vuelo es de primera clase y falso si es de clase coach. Este método permite traducir los valores booleanos a sus respectivas cadenas de texto.
     */
    public String traducirClase(){
        if(isPrimeraClase){
            return "Primera Clase";
        }
        return "Clase Coach";

    }
}