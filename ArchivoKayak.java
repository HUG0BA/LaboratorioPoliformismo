import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArchivoKayak{
    private File archivoUsuario;
    private File archivoReserva;
    
    

    /** 
     * @param nombreArchivo
     * @description Constructor asgina parámetros ingresados para crear nuevo archivo
     */
    public ArchivoKayak(String nombreArchivoUsuario, String nombreArchivoReserva){
        archivoUsuario = new File(nombreArchivoUsuario);
        archivoReserva = new File(nombreArchivoReserva);
        
    }

    
    /** 
     * @param usuarios
     * @throws Exception
     * @description Recibe un ArrayList con todos los usuarios actualmente en el programa. Verfica si ya existe un archivo y lo limpia para poder sobreescribir si en caso hay información actualizada en el csv.
     */
    public void escribirArchivoUsuario(ArrayList<Usuario> usuarios) throws Exception{
        PrintWriter escritor = new PrintWriter(archivoUsuario, "UTF-8");
        String linea = "";
        if(archivoUsuario.length() > 0){
            PrintWriter cleaner = new PrintWriter(archivoUsuario, "UTF-8");
            cleaner.write("");
            cleaner.close();
        }
        linea = "username,password,tipo_plan";
        escritor.println(linea);

        for(Usuario usuario : usuarios){
            linea = usuario.getNombre() + "," + usuario.getPassword() + "," + usuario.traducirPlan();
            escritor.println(linea);    
        }
        escritor.close();

    }

    
    /** 
     * @param reservas
     * @param confirmaciones
     * @throws Exception
     * @description Recibe como parametros dos ArrayList que contienen la información del modo reserva y del modo confirmación. Comprueba si el archivo ya existe y de lo contrario lo creo con los encabezados correctos y después añade la información.
     */
    public void escribirArchivoReserva(ArrayList<Reserva> reservas, ArrayList<Confirmacion> confirmaciones) throws Exception{
        PrintWriter escritor = new PrintWriter(archivoReserva, "UTF-8");
        String linea = "";
        if(archivoReserva.length() == 0){
            /*PrintWriter cleaner = new PrintWriter(archivoReserva, "UTF-8");
            cleaner.write("");
            cleaner.close();*/
            linea = "username,fecha,tipo_vuelo,cantidad_boletos,aerolinea,tarjeta,cantidad_cuotas,clase_vuelo,numero_asiento,cantidad_maletas";
            escritor.println(linea);
            
        }
        

        int i = 0;
        for(Reserva reserva : reservas){
            linea = reserva.getUsername() + "," + reserva.getFecha() + "," + reserva.traducirIda() + "," + reserva.getBoletos() + "," + reserva.getAerolinea() + "," + confirmaciones.get(i).getTarjeta() + "," + confirmaciones.get(i).getCuotas() + "," + confirmaciones.get(i).traducirClase() + "," + confirmaciones.get(i).getNumeroAsiento() + "," + confirmaciones.get(i).getCantidadMaletas();
            escritor.println(linea);    
        }
        escritor.close();
    }

    /** 
     * @return ArrayList<Usuario>
     * @description Obtiene todos los datos del archivo CSV de los usuarios y convierte los strings de cada columan en un objeto tipo usuario. Este objeto se añade a una lista que contiene todos los usuarios registrados en el CSV y se devuelve.
     * @throws Exception
     */
    public ArrayList<Usuario> leerUsuarios() throws Exception{
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        if(!archivoUsuario.exists()){
            return usuarios;
        }
        
        BufferedReader br = new BufferedReader(new FileReader(archivoUsuario));
        String line = "";


        while((line = br.readLine()) != null){       
            String[] values = line.split(",");

            boolean plan = false;
            if(values[2].toLowerCase().contains("premium")){
                plan = true;
            }else if(values[2].toLowerCase().contains("base")){
                plan = false;
            }else{
                continue;
            }

            Usuario usuario = new Usuario(values[0], values[1], plan);
            usuarios.add(usuario);   
        }
        
        br.close();

        return usuarios;
    }

    
    /** 
     * @return ArrayList<Reserva>
     * @description Obtiene toda la información del CSV pero únicamente convierte la parte del modo reserva a objetos de tipo reserva pues la confirmación no puede ser cambiada por el usuario (sin devoluciones)
     * @throws Exception
     */
    public ArrayList<Reserva> leerReservas() throws Exception{
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();

        if(!archivoReserva.exists()){
            return reservas;
        }
        
        BufferedReader br = new BufferedReader(new FileReader(archivoReserva));
        String line = "";

        

        while((line = br.readLine()) != null){       
            String[] values = line.split(",");

            boolean soloIda = false;
            if(values[2].toLowerCase().contains("solo")){
                soloIda = true;
            }
            else if(values[2].toLowerCase().contains("vuelta")){
                soloIda = false;
            }
            Reserva reserva = new Reserva(values[1], soloIda, Integer.parseInt(values[3]), values[4], values[0]);
            reservas.add(reserva);   
        }
        
        br.close();

        return reservas;
    }
}