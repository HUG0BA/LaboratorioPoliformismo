import java.util.ArrayList;

public class Kayak implements IReserva{

    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private ArrayList<Confirmacion> confirmaciones;
    private Usuario usuarioActual;
    private int indexUsuario;
    private Reserva reservaActual; 
    private Confirmacion confrimacionActual;
    private ArchivoKayak archivo;

    
    /** 
     * @throws Exception
     * @description Constructor de la clase controladora del programa que carga toda la información de los CSV y prepara los ArrayList
     */
    public Kayak() throws Exception{
        archivo = new ArchivoKayak("usuarios.csv", "reservas.csv");
        usuarios = archivo.leerUsuarios();
        reservas = new ArrayList<Reserva>();
        confirmaciones = new ArrayList<Confirmacion>();
    } 

    
    /** 
     * @param userName
     * @param password
     * @return Usuario
     * @description Inicia sesión si el nombre de usuario y la contraseña son correctas, establece el valor de usuarioActual que permite realizar el resto de las operaciones.
     */
    @Override
    public Usuario login(String userName, String password){   
        if(usuarioActual != null){
            usuarioActual = null;
        }

        for(Usuario usuario : usuarios){
            if(usuario.getNombre().equals(userName) && usuario.getPassword().equals(password)){
                usuarioActual = new Usuario(usuario.getNombre(), usuario.getPassword(), usuario.isPlan());
                indexUsuario = usuarios.indexOf(usuario);
            }
        }

        return usuarioActual;
    }
    
    /** 
     * @param username
     * @param password
     * @param tipo
     * @description Crea un objeto de tipo usuario con los parámetros recibidos y lo añade al ArrayList de usuarios que es utilizado en el CSV
     */
    @Override
    public void registroUsuario(String username, String password, String tipo){
        boolean plan = false;
        if(tipo.toLowerCase() == "base" || tipo.toLowerCase().contains("base")){
            plan = false;
        }else if(tipo.toLowerCase() == "premium" || tipo.toLowerCase().contains("premium")){
            plan = true;
        }
        Usuario usuario = new Usuario(username, password, plan);
        usuarios.add(usuario);
    }
    
    /** 
     * @param nuevaPassword
     * @description Unicamente se puede utilizar si algún usuario ha iniciado sesión, es decir, usuarioActual no es nulo
     */
    @Override
    public void cambiarPassword(String nuevaPassword){
        if(usuarioActual != null){
            usuarioActual.setPassword(nuevaPassword);
            usuarios.set(indexUsuario, usuarioActual);
        }
    }
    /**
     * @description Únicamente se puede llamar si el usuarioActual registrado es de plan tipo base 
     */
    @Override
    public void cambiarTipoUsuario(){
        if(!usuarioActual.isPlan()){
            usuarioActual.setPlan(true);
            usuarios.set(indexUsuario, usuarioActual);
        }
    }
    
    /** 
     * @param fechaVuelo
     * @param tipoVuelo
     * @param cantidadBoletos
     * @param aerolinea
     * @param user
     * @description Crea un objeto de tipo reservación pero no lo añade a su respectivo arreglo pues la reserva podría ser modificada, se la confirmacion
     */
    @Override
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String user){
        if(reservaActual != null) reservaActual = null;
        
        reservaActual = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, usuarioActual.getNombre());
    }
    
    /** 
     * @param numeroTarjeta
     * @param cuotas
     * @param claseVuelo
     * @param numeroAsiento
     * @param cantidadMaletas
     * @description Crea un objeto de tipo Confirmacion con los parámetros recibidos y, puesto que la orden esta confirmada, añade la reserva actual y su confirmación a sus respectivos arreglos para guardar la información en un CSV
     */
    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas){
        if(confrimacionActual != null) confrimacionActual = null;

        if(usuarioActual.isPlan()){
            confrimacionActual = new Confirmacion(numeroTarjeta, 1, true, numeroAsiento, cantidadMaletas);
        }else{
            boolean isPrimeraClase = false;
            if(claseVuelo.toLowerCase().contains("primera")){
                isPrimeraClase = true;
            }
            confrimacionActual = new Confirmacion(numeroTarjeta, cuotas, isPrimeraClase, numeroAsiento, 1);

            
        }
        reservas.add(reservaActual);
        confirmaciones.add(confrimacionActual);
    }
    
    /** 
     * @return String
     * @description Devuelve un String con la información de la reserva, además utilice este método para pasar información a la clase vista por lo que no creo funcione con la clase de otro compañero :C (¿Cómo podría haber utilizado la interfaz establecida para comprobar si se había iniciado sesión y el tipo de usuario?)
     */
    @Override
    public String itinerario(){
        String text = "";
        if(usuarioActual != null){
            if(usuarioActual.isPlan()){
                text = text + ".";
            }else{
                text = text + ",";
            }
        }else{
            text = text + "-";
        }
        
        if(reservaActual == null) return (text + "Aún no ha realizado el itinerario de la reserva");
        return (text + reservaActual.toString());
    }
    /**
     * @description Llama al método para almacenar la información en el archivo CSV de las reservas
     */
    @Override
    public void guardarReserva(){
        try {
            archivo.escribirArchivoReserva(reservas, confirmaciones);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    /**
     * @description Llama al método del archivo para obtener los valores del CSV
     */
    @Override
    public void leerReserva(){
        try {
            archivo.leerReservas();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * @description Llama al métod de la clase archivo para guardar y actualizar a todos los usuarios almacenados actualmente
     */
    @Override
    public void guardarUsuario(){
        try {
            archivo.escribirArchivoUsuario(usuarios);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * @description @description Llama al método de leerUsuario de la clase archivo para obtener a todos los usuarios registrados
     */
    @Override
    public void leerUsuario(){
        try {
            archivo.leerUsuarios();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}