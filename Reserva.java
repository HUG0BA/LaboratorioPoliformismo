public class Reserva{
    private String fecha;
    private boolean soloIda;
    private int boletos;
    private String aerolinea;

    public Reserva(String fecha, boolean soloIda, int boletos, String aerolinea){
        this.fecha = fecha;
        this.soloIda = soloIda;
        this.boletos = boletos;
        this.aerolinea = aerolinea;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isSoloIda() {
        return soloIda;
    }

    public int getBoletos() {
        return boletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setSoloIda(boolean soloIda) {
        this.soloIda = soloIda;
    }

    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String toString(){
        return "Fecha de vuelo: " + this.fecha +
                " Tipo de vuelo: " + traducirIda() +
                " Cantidad de boletos: " + this.boletos + 
                " Aerolínea: " + this.aerolinea;
    }

    public String traducirIda(){
        if(soloIda){
            return "solo ida";
        }
        return "ida y vuelta";
    }
    

}