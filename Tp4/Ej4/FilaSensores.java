public class FilaSensores {
    private Sensor [] fs;

    public FilaSensores(int cant){
        fs = new Sensor[cant];
    }

    //Comandos
    public void establecerSensor(int p, Sensor s){
        if(p> 0 && p <= fs.length){
            fs[p-1] = s;
        }
    }
    public void intercambiar(int p1, int p2){
        if(p1 > 0 && p2 > 0 && p1 <= fs.length && p2 <= fs.length){
            Sensor aux = fs[p1- 1];

            fs[p1-1] = fs[p2-1];
            fs[p2-1] = aux;
        }
    }

    public void copy(FilaSensores a){
        for (int i = 1; i <= cantFila(); i++) {
            Sensor sensorDeA = a.obtenerSensor(i);
            // A nuestro sensor (que está en el subíndice i-1) le decimos 
            // que copie el estado del sensorDeA. ¡Esto es copia en profundidad!
            this.fs[i - 1].copy(sensorDeA);
        }
    }

    //Consultas
    public Sensor obtenerSensor(int p){
        Sensor aux = null;
        if(p > 0 && p <= cantFila()){
            aux = fs[p-1];
        }
        return aux;
    }

    public boolean posicionValida(int p){
        boolean aux = false;
        if(p > 0 && p <= cantFila()){
            aux = true;
        }
        return aux;
    }
    public int cantFila(){
        return fs.length;
    }
    public int cantSensores() {
        int contador = 0;
        for (int i = 0; i < cantFila(); i++) {
            if (fs[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    public int cantidadRiesgo() {
        int contador = 0;
        for (int i = 0; i < cantFila(); i++) {
            if (fs[i].riesgo()) { 
                contador++;
            }
        }
        return contador;
    }
    
    public boolean hayNRiesgo(int n) {
        return cantidadRiesgo() >= n; 
    }

    public boolean dosConsecutivosEmergencia(){
        boolean aux = false;
        for(int i = 0; i < cantFila() - 1 && !aux ;i++){
            if(fs[i].riesgo() && fs[i+1].riesgo()){
                aux = true;
            }
        }
        return aux;
    }
    public boolean equals(FilaSensores a){
        boolean iguales = false;

        if(a.cantFila() == cantFila()){
            iguales = true;

            for(int i = 1; i <= cantFila() && iguales; i++){
                if (obtenerSensor(i) != a.obtenerSensor(i)) {
                    iguales = false;
                }
            }
        }
        return iguales;
    }

    public FilaSensores clone(){
        FilaSensores aux = new FilaSensores(cantFila());
        
        for (int i = 1; i <= cantFila(); i++) {
            Sensor sensorActual = obtenerSensor(i);
            // El contrato dice que las referencias están ligadas (no hay nulos).
            // Le pedimos al SENSOR que se clone y lo guardamos en la fila nueva.
            aux.establecerSensor(i, sensorActual.clone());
        }
        
        return aux;
    }

public FilaSensores filaCompleta() {
        int posNueva = 1;
        FilaSensores aux = new FilaSensores(cantFila());
        
        for (int i = 0; i < cantFila(); i++) {
            if (fs[i] != null) {
                // Usamos el comando que ya sabe manejar las posiciones del 1 a N
                aux.establecerSensor(posNueva, fs[i]);
                posNueva++;
            }  
        }
        return aux;
    }
}
