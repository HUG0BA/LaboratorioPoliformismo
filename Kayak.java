public class Kayak implements IReserva{

    private Usuario usuarioActual;
    private Reserva reservaActual; 
    private Confirmacion confrimacionActual;
    private ArchivoKayak archivo;

    @Override
    public void login(String userName, String password){   
        System.out.println("HI");
    }
    @Override
    public void registro(String username, String password, String tipo){

    }
    @Override
    public void cambiarPassword(String nuevaPassword){

    }
    @Override
    public void cambiarTipoUsuario(){

    }
    @Override
    public void reserva(String fechaVuelo, String tipoVuelo, int cantidadBoletos, String aerolinea, String user){

    }
    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas){

    }
    @Override
    public String itinerario(){
        if(reservaActual == null) return "Aún no ha realizado el itinerario de la reserva";
        return reservaActual.toString();
    }
}