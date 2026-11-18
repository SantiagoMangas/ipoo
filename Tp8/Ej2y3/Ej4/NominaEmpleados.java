public class NominaEmpleados extends Coleccion {
    public NominaEmpleados(int n) {
        super(n);
    }
    //consultas
    public int contarSupHoras(int h){
        int cont = 0;
        for(int i = 0; i < cantElementos(); i++){
            Empleado e = (Empleado) recuperarElemento(i);
            if(e.obtenerCantHoras() > h){
                cont++;
            }
        }
        return cont;
    }

    public float sumarSueldos(){
        float suma = 0;
        for(int i = 0; i < cantElementos(); i++){
            Empleado e = (Empleado) recuperarElemento(i);
            suma += e.obtenerSueldo();
        }
        return suma;    
    }   
}
