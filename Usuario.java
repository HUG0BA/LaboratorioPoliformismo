public class Usuario{
    private String nombre;
    private String password;
    private boolean plan;

    public Usuario(String nombre, String password, boolean plan){
        this.nombre = nombre;
        this.password = password;
        this.plan = plan;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPlan() {
        return plan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlan(boolean plan) {
        this.plan = plan;
    }

    public String toString(){
        return "Nombre: " + nombre +
                " Contraseña: " + password + 
                " " + traducirPlan();
    }

    public String traducirPlan(){
        if(plan){
            return"Plan premium";
        }
        return "Plan base";
    }


}