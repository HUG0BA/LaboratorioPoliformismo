import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArchivoKayak{
    private File archivoRestaurante;
    

    /** 
     * @param nombreArchivo
     * @description Constructor asgina parámetros ingresados para crear nuevo archivo
     */
    public ArchivoKayak(String nombreArchivoRestaurante){
        archivoRestaurante = new File(nombreArchivoRestaurante);
    }

    public void escribirArchivo(ArrayList<Restaurante> restaurantes) throws Exception{
        PrintWriter escritor = new PrintWriter(archivoRestaurante, "UTF-8");
        String linea = "";
        if(archivoRestaurante.length() > 0){
            PrintWriter cleaner = new PrintWriter(archivoRestaurante, "UTF-8");
            cleaner.write("");
            cleaner.close();
        }
        linea = "id_restaurante,nombre_restaurante,descripcion,horario,disponibilidad,productos";
        escritor.println(linea);

        for(Restaurante restaurante : restaurantes){
            linea = restaurante.getIdRest() + "," + restaurante.getNombre() + "," + restaurante.getDes() + "," + restaurante.getHorario() + "," + restaurante.getDisp(); 
            ArrayList<Producto> produtos = restaurante.getProductos();
            String textProductos = "";
            for(Producto producto : produtos){
                textProductos = textProductos + producto.getIdProducto() + ";" + producto.getTitulo() + ";" + producto.getDetalles() + ";" + producto.getCosto() + ";" + producto.getDisponible() + "|";
            }
            linea = linea + "," + textProductos;
            escritor.println(linea);    
        }
        escritor.close();

    }

    /** 
     * @return ArrayList<Dispositivo>
     * @description Método obtener datos del archivo CSV y convertirlos a las clases de Celular y Computadora
     * @throws Exception
     */
    public ArrayList<Restaurante> leerArchivo() throws Exception{
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        if(!archivoRestaurante.exists()){
            return restaurantes;
        }
        
        BufferedReader br = new BufferedReader(new FileReader(archivoRestaurante));
        String line = "";


        while((line = br.readLine()) != null){
            
            String[] values = line.split(",");
            ArrayList<Producto> productos = new ArrayList<Producto>();
            if(values[5] != null){
                String[] textProductos  = values[5].split("|");  
                for(String textProducto : textProductos){
                    String[] infoProducto = textProducto.split(";");
                    Producto producto = new Producto(Integer.parseInt(infoProducto[0]), infoProducto[1], infoProducto[2], Double.parseDouble(infoProducto[3]), Boolean.parseBoolean(infoProducto[4]));
                    productos.add(producto);
                } 
            }
             
            Restaurante restaurante = new Restaurante(Integer.parseInt(values[0]), values[1], values[2], values[3], Boolean.parseBoolean(values[4]), productos);
            restaurantes.add(restaurante);
        }
        
        br.close();

        return restaurantes;
    }
}