package septiembre;

public class TempMinEstacion {
    private float [] tMin;

    public TempMinEstacion(int cant) {
        tMin = new float[cant];
    }
    //comandos
    public void establecerTempMin(int dia, float t){
        tMin[dia-1] = t;
    }
    public float obtenerTempMin(int dia){
        return tMin[dia-1];
    }
    public int cantDias(){
        return tMin.length;
    }
    public int cantHelados(){
        //un recorrido es exahustivo cuando se visita cada elemento de la coleccion
        //un recorrido es no exahustivo cuando se visita solo una parte de la coleccion
        int cont = 0;
        for (int i = 0; i < cantDias(); i++) {
            if (tMin[i] <= 0) {
                cont++;
            }
        }
        return cont;
    }
    public boolean huboHeladas(){
        //el recorrido es no exahustivo cuando se visita solo una parte de la coleccion
        boolean hay = false;
        for (int i = 0; i < cantDias() && !hay; i++) 
            if (tMin[i] <= 0) 
                hay = true;
        return hay;
    }
    public int contarMayores(int t){
        //el recorrido es exahustivo cuando se visita cada elemento de la coleccion
        int cont = 0;
        for (int i = 0; i < cantDias(); i++) {
            if (tMin[i] > t) {
                cont++;
            }
        }
        return cont;
    }
    public float primerMayor(float t){
        //el recorrido es no exahustivo cuando se visita solo una parte de la coleccion
        float pri = t;
        boolean encontro = false;
        for (int i = 0; i < cantDias() && !encontro; i++) {
            if (tMin[i] > t) {
                encontro = true;
                pri = tMin[i];
            }
        }
        return pri;
    }
    public float ultimaMayor(float t){
        //el recorrido es no exahustivo cuando se visita solo una parte de la coleccion
        float ult = t;
        boolean encontro = false;
        for (int i = cantDias() - 1; i >= 0 && !encontro; i--) {
            if (tMin[i] > t) {
                encontro = true;
                ult = tMin[i];
            }
        }
        return ult;
    }
    public int diaMayor(float t){
        //el recorrido es no exahustivo cuando se visita solo una parte de la coleccion
        int dia = 0;
        boolean encontro = false;
        for (int i = 0; i < cantDias() && !encontro; i++) {
            if (tMin[i] > t) {
                encontro = true;
                dia = i + 1; //el dia es el indice + 1 porque el indice comienza en 0
            }
        }
        return dia;
    }
    public boolean equals(TempMinEstacion e){
        //el recorrido es no exahustivo cuando se visita solo una parte de la coleccion
        boolean iguales = e!=null && cantDias() == e.cantDias();
        for (int i = 0; i < cantDias() && iguales; i++) {
            iguales = tMin[i] == e.obtenerTempMin(i+1);
        }
        return iguales;
    }
}
