interface IReserva{
    public void login(String userName, String password);
    public void registro(String username, String password, String tipo);
    public void cambiarPassword(String nuevaPassword);
    public void cambiarTipoUsuario();
    public void reserva(String fechaVuelo, String tipoVuelo, int cantidadBoletos, String aerolinea, String user);
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas);
    public String itinerario();
}
