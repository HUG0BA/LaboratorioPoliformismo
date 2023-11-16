interface IReserva{
    
    
    /** 
     * @param userName
     * @param password
     * @return Usuario
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public Usuario login(String userName, String password);

    /** 
     * @param username
     * @param password
     * @param tipo
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void registroUsuario(String username, String password, String tipo);

    /** 
     * @param nuevaPassword
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void cambiarPassword(String nuevaPassword);

    /**
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void cambiarTipoUsuario();

    
    /** 
     * @param fechaVuelo
     * @param tipoVuelo
     * @param cantidadBoletos
     * @param aerolinea
     * @param user
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String user);
    
    /** 
     * @param numeroTarjeta
     * @param cuotas
     * @param claseVuelo
     * @param numeroAsiento
     * @param cantidadMaletas
     */
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas);
    
    /** 
     * @return String
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public String itinerario();

    /**
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void guardarReserva();

    /**
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void leerReserva();

    /**
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void guardarUsuario();

    /**
     * @description Método de la interfaz enviada al grupo de discord, su implementación se explica en la clase controladora Kayak.
     */
    public void leerUsuario();
}
