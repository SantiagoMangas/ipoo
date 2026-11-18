public class Empleado extends Elemento {
    private int legajo;
    private String nombre;
    private int cantHoras;
    private float valorHora;

    public Empleado(int leg, String nombre, int canth, float valorh){
        legajo = leg;
        this.nombre = nombre;
        valorHora = valorh;
        cantHoras = canth;
    }
    
    public int obtenerLegajo(){
        return legajo;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public int obtenerCantHoras(){
        return cantHoras;
    }

    public float obtenerValorHora(){
        return valorHora;
    }

    public float obtenerSueldo(){
        return cantHoras * valorHora;
    }

    public boolean esEquivalente(Elemento e){
        Empleado otro = (Empleado) e;
        return legajo == otro.obtenerLegajo();
    }

    public boolean esMayor(Elemento e){
        return legajo > e.obtenerLegajo();
    }
}
