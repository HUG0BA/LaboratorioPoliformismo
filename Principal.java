import java.util.Scanner;

import javax.swing.text.Style;

public class Principal{
    
    /** 
     * @param args
     * @description Clase vista del programa que implementa un obejto de tipo IReserva
     */
    public static void main(String[] args){
        IReserva kayak = null;
        Scanner scanner = new Scanner(System.in);
        boolean programa = true;

        boolean isPlan = false;

        try{
            kayak = new Kayak();
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al iniciar el programa. Error: " + e.toString());
            programa = false;
        }

        while(programa){
            System.out.println("¡Bienvenido a Kayak!");
            System.out.println("Ingrese el número de opción que desea realizar: \n 1. Registrar usuario \n 2. Login usuario \n 3. Modo reserva \n 4. Mostrar itinerario\n 5. Modo confirmacion \n 6.Modo perfil \n 7. Guardar usuarios \n 8. Guardar reservas \n 9. Salir");
            int opcion = -1;

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Asegúrse de ingresar valores numéricos enteros. Error: " + e.toString());
                scanner.nextLine();
            }
            

            switch(opcion){
                case 1:
                    String username = "";
                    String password = "";
                    String plan = "";

                    try {
                        System.out.println("Ingrese su nobmre de usuario");
                        username = scanner.nextLine();
                        System.out.println("Ingerse su contraseña");
                        password = scanner.nextLine();
                        System.out.println("Ingrese su tipo de plan: \n 1. Plan base \n 2. Plan premium ");
                        int planIndex = scanner.nextInt();
                        scanner.nextLine();

                        if(planIndex == 1){
                            plan = "base";
                        }else if(planIndex == 2){
                            plan = "premium";
                        }else{
                            System.out.println("Ingrese un número de plan válido");
                            break;
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Asegúrse de ingresar valores válidos enteros. Error: " + e.toString());
                        scanner.nextLine();
                    }
                    

                    try {
                        kayak.registroUsuario(username, password, plan);
                        kayak.guardarUsuario();
                        System.out.println("Usuario registrado exitosamente");
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error al realizar la operación. Error: " + e.toString());
                    }
                    break;

                case 2:
                    String userLogin = "";
                    String passLogin = "";
                    
                    try {
                        System.out.println("Ingrese su nombre de usuario");
                        userLogin = scanner.nextLine();
                        System.out.println("Ingrese su contraseña");
                        passLogin = scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Asegúrse de ingresar valores válidos enteros. Error: " + e.toString());
                    }

                    try {
                        int mejorar = 0;
                        if(kayak.login(userLogin, passLogin) == null){
                            System.out.println("Usuario no encontrado");
                            break;
                        }
                        if(kayak.itinerario().contains(".")){
                            System.out.println("Bienvenido al sistema");
                            isPlan = true;
                        }else if(kayak.itinerario().contains(",")){
                            System.out.println("Bienvenido al sistema. Hemos notado que usted no es un usuario premium, ¿Desea subir de cateogría?");
                            isPlan = false;
                            System.out.println("1. Si \n 2. No");
                            mejorar = scanner.nextInt();
                            scanner.nextLine();

                            if(mejorar == 1){
                                kayak.cambiarTipoUsuario();
                                System.out.println("¡Ahora es un usuairo premium!");
                                isPlan = true;
                            }else{
                                System.out.println("Muy bien :C, Continue con su compra");
                                isPlan = false;
                            }
                        }
                        

                        

                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error tratando de realizar la operación. Error: " + e.toString());
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    if(kayak.itinerario().contains("-")){
                        System.out.println("Aún no ha iniciado sesión");
                        break;
                    }
                    
                    String fecha = "";
                    boolean soloIda = false;
                    int boletos = 0;
                    String aerolinea = "";

                    try {
                        System.out.println("Ingrese la fecha de vuelo");
                        fecha = scanner.nextLine();
                        System.out.println("Tipo de vuelo: \n 1. Solo ida \n 2. Ida y vuelta");
                        int tipoVuelo = scanner.nextInt();
                        scanner.nextLine();
                        if(tipoVuelo == 1){
                            soloIda = true;
                        }else if(tipoVuelo == 2){
                            soloIda = false;
                        }else{
                            System.out.println("Asegúrese de ingresar un valor numérico válido.");
                            break;
                        }

                        System.out.println("Cantidad de boletos: ");
                        boletos = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Aerolínea: ");
                        aerolinea = scanner.nextLine();
                        
                    } catch (Exception e) {
                        System.out.println("Asegúrse de ingresar valores válidos enteros. Error: " + e.toString());
                        scanner.nextLine();
                    }
                    

                    try {
                        kayak.reservacion(fecha, soloIda, boletos, aerolinea, "");
                        System.out.println("Reserva exitosa");
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error al realizar la operación. Error: " + e.toString());
                    }                    
                    break;

                case 4: 
                    if(kayak.itinerario().contains("-")){
                        System.out.println("Aún no ha iniciado sesión");
                        break;
                    }

                    try {
                        System.out.println(kayak.itinerario());
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error al realizar la operación. Error: " + e.toString());
                    }
                    break;

                case 5:
                    if(kayak.itinerario().contains("-")){
                        System.out.println("Aún no ha iniciado sesión");
                        break;
                    }

                    if(kayak.itinerario().toLowerCase().contains("no")){
                        System.out.println("Primero debe ingresar una reserva");
                        break;
                    }
                    String tarjeta = "";
                    int cuotas = 0;
                    String clase = "";
                    String numeroAsiento = "";
                    int cantidadMaletas = 0;

                    try {
                        System.out.println("Ingrese el número de su tarjeta: ");
                        tarjeta = scanner.nextLine();

                        if(isPlan){
                            System.out.println("Como usuario premium su pago será realizado en una cuota");
                            //cuotas = 1;
                        }else{
                            System.out.println("Ingrese la cantidad de cuotas a pagar (1-24)");
                            cuotas = scanner.nextInt();
                            scanner.nextLine();
                            if(cuotas < 0 || cuotas > 24){
                                System.out.println("Ingres un valor dentro del rango aceptado");
                                break;
                            }
                        }
                        
                        if(isPlan){
                            System.out.println("Como usuario premium sus viajes siempre son en primera clase");
                            //clase = "primera";
                        }else{
                            System.out.println("Clase de su vuelo: \n 1. Primera clase \n 2. Coach clase");
                            int tipoClase = scanner.nextInt();
                            scanner.nextLine();
                            if(tipoClase == 1){
                                clase = "primera";
                            }else if(tipoClase == 2){
                                clase = "coach";
                            }else{
                                System.out.println("Ingrese un valor numérico válido");
                                break;
                            }
                        }
                        

                        System.out.println("Número de asiento");
                        numeroAsiento = scanner.nextLine();

                        if(!isPlan){
                            System.out.println("Como usuario no premium únicamente puede llevar una maleta");
                            //cantidadMaletas = 1;
                        }else{
                            System.out.println("Cantidad de maletas: ");
                            cantidadMaletas = scanner.nextInt();
                            scanner.nextLine();
                        }
                        

                    } catch (Exception e) {
                        System.out.println("Asegúre de ingresar un valor válido. Error: " + e.toString());
                        scanner.nextLine();
                    }

                    try {
                        if(isPlan){
                            kayak.confirmacion(tarjeta, 1, "primera", numeroAsiento, cantidadMaletas);
                            System.out.println("¡Reserva exitosa! Feliz vuelo");
                            kayak.guardarReserva();
                        }else{
                            kayak.confirmacion(tarjeta, cuotas, clase, numeroAsiento, 1);
                            System.out.println("¡Reserva exitosa! Feliz vuelo");
                            kayak.guardarReserva();
                        }
                        
                        
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error al realizar la operación. Error: " + e.toString());
                    }

                    break;

                case 6:
                    if(kayak.itinerario().contains("-")){
                        System.out.println("Aún no ha iniciado sesión");
                        break;
                    }
                    
                    System.out.println("Modo perfil");

                    if(isPlan){
                        System.out.println("Ingrese la opción que desee ejecutar:  \n 1. cambiar contraseña");
                    }else{
                        System.out.println("Ingrese la opción que desee ejecutar: \n 1. Mejorar a cuenta premium \n 2. Aplicar cupón de descuento \n 3. cambiar contraseña");
                    }
                  
                    int opcionPerfil = -1;
                    try {
                        opcionPerfil = scanner.nextInt();
                        scanner.nextLine();
                        if(isPlan){
                            if(opcionPerfil != 1){
                                System.out.println("Ingrese una opción válida");
                                break;
                            }
                            opcionPerfil = 3;
                        }else{
                            if(opcionPerfil < 1 || opcionPerfil > 3){
                                System.out.println("Ingrese una opción válida");
                                break;
                            }
                        }                        
                    } catch (Exception e) {
                        System.out.println("Asegúrsese de ingresar un valor numérico válido. Error. " + e.toString());
                    }

                    switch (opcionPerfil) {
                        case 1:
                            try {
                                kayak.cambiarTipoUsuario();
                            } catch (Exception e) {
                                System.out.println("Ha ocurrdio un error tratando de realizar la operación"+ e.toString());
                            }
                            
                            break;

                        case 2:
                            System.out.println("Cupon de 10% de descuento aplicado" );
                            break;

                        case 3:
                            System.out.println("Ingrese su nueva contraseña");
                            String nueva = scanner.nextLine();

                            try {
                                kayak.cambiarPassword(nueva);
                                kayak.guardarUsuario();
                            } catch (Exception e) {
                                System.out.println("Ha ocurrdio un error tratando de realizar la operación"+ e.toString());
                            }
                            
                            break;
                    
                        default:
                            System.out.println("Ingrese un valor numérico dentro del rango");
                            break;
                    }
                    break;

                case 7:
                    if(kayak.itinerario().contains("-")){
                        System.out.println("Aún no ha iniciado sesión");
                        break;
                    }

                    try {
                        kayak.guardarUsuario();
                        System.out.println("Usuarios guardados exitosamente");
                    } catch (Exception e) {
                        System.out.println("Ha ocurrdio un error tratando de realizar la operación"+ e.toString());
                    }

                    break;
                
                case 8:
                    if(kayak.itinerario().contains("-")){
                        System.out.println("Aún no ha iniciado sesión");
                        break;
                    }

                    try {
                        kayak.guardarReserva();
                        System.out.println("Reservas guardados exitosamente");
                    } catch (Exception e) {
                        System.out.println("Ha ocurrdio un error tratando de realizar la operación"+ e.toString());
                    }
                    break;

                case 9:
                    System.out.println("Desea guardar los cambios realizados");
                    System.out.println("1. Si \n 2. No");
                    int guardar = 0;

                    try {
                        guardar = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Asegúrese de ingresar un valor entero. Error: " + e.toString());
                        scanner.nextLine();
                    }

                    if(guardar == 1){
                        kayak.guardarUsuario();
                    }
                    programa = false;
                    break;

                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        }


        

        
    }
}