public class Reserva{
    public String username;
    private String fecha;
    private boolean soloIda;
    private int boletos;
    private String aerolinea;

    
    /** 
     * @param fecha
     * @param soloIda
     * @param boletos
     * @param aerolinea
     * @param username
     * @return vodi
     */
    public Reserva(String fecha, boolean soloIda, int boletos, String aerolinea, String username){
        this.username = username;
        this.fecha = fecha;
        this.soloIda = soloIda;
        this.boletos = boletos;
        this.aerolinea = aerolinea;
    }

    
    /** 
     * @return String
     */
    public String getUsername() {
        return username;
    }

    
    /** 
     * @return String
     */
    public String getFecha() {
        return fecha;
    }

    
    /** 
     * @return boolean
     */
    public boolean isSoloIda() {
        return soloIda;
    }

    
    /** 
     * @return int
     */
    public int getBoletos() {
        return boletos;
    }

    
    /** 
     * @return String
     */
    public String getAerolinea() {
        return aerolinea;
    }

    
    /** 
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    /** 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     * @param soloIda
     */
    public void setSoloIda(boolean soloIda) {
        this.soloIda = soloIda;
    }

    
    /** 
     * @param boletos
     */
    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }

    
    /** 
     * @param aerolinea
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "Fecha de vuelo: " + this.fecha +
                " Tipo de vuelo: " + traducirIda() +
                " Cantidad de boletos: " + this.boletos + 
                " Aerolínea: " + this.aerolinea;
    }

    
    /** 
     * @return String
     */
    public String traducirIda(){
        if(soloIda){
            return "solo ida";
        }
        return "ida y vuelta";
    }
    

}