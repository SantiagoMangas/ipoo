public class Alumno extends Elemento {
    private int nroIngreso;
    private String nombre;
    private float promedio;

    public Alumno(int l, String n, float p){
        nroIngreso = l;
        nombre = n;
        promedio = p;
    }

    public int obtenerNroIngreso(){
        return nroIngreso;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public float obtenerPromedio(){
        return promedio;
    }

    public boolean esEquivalente(Elemento e){
        boolean eq = false;
        if(e == this){
            eq = false;
        } else if(getClass() == e.getClass()){
            Alumno a = (Alumno) e;
            eq = nroIngreso == a.obtenerNroIngreso() &&
                    nombre.equals(a.obtenerNombre()) &&
                    promedio == a.obtenerPromedio();
        }
        return eq;
    }

    public boolean esMayor(Elemento e){
        return nroIngreso > e.obtenerNroIngreso();
    }
}
