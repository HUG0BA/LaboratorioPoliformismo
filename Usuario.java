public class Usuario{
    private String nombre;
    private String password;
    private boolean plan;

    
    /** 
     * @param nombre
     * @param password
     * @param plan
     * @description Constructor predeterminado que recibo los datos del registro
     */
    public Usuario(String nombre, String password, boolean plan){
        this.nombre = nombre;
        this.password = password;
        this.plan = plan;
    }

    
    /** 
     * @return String
     * @description geter
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @return String
     * @description geter
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * @return boolean
     * @description geter
     */
    public boolean isPlan() {
        return plan;
    }

    
    /** 
     * @param nombre
     * @description seter
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @param password
     * @description seter
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * @param plan
     * @description seter
     */
    public void setPlan(boolean plan) {
        this.plan = plan;
    }

    
    /** 
     * @return String
     * @description Sobreescritura del método toString para devolver los valores de la clase
     */
    public String toString(){
        return "Nombre: " + nombre +
                " Contraseña: " + password + 
                " " + traducirPlan();
    }

    
    /** 
     * @return String
     * @description El atributo plan tiene valor verdadero si el usuario tiene un plan premium y false si su plan es base. Este método traduce estos valores a una cadena de texto.
     */
    public String traducirPlan(){
        if(plan){
            return"Plan premium";
        }
        return "Plan base";
    }


}