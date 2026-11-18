public class Tecnico extends Empleado{

    public Tecnico(int leg, String nombre, int canth, float valorh) {
        super(leg, nombre, canth, valorh);
    }

    public float obtenerSueldo(){
        return super.obtenerSueldo() * 1.15f ;
    }
}
