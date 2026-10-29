public class TableroSensores {
    private Sensor[][] grilla;

    public TableroSensores(int cantFil, int cantCol){
        grilla = new Sensor[cantFil][cantCol];
    }
    //comandos
    public void establecerSensor(int f, int c, Sensor s){
        grilla[f][c] = s;
    }

    public void intercambiar(int f1, int f2){
        int ind1 = f1 - 1;
        int ind2 = f2 - 1;
        
        Sensor[] aux = grilla[ind1];
        grilla[ind1] = grilla[ind2];
        grilla[ind2] = aux;
    }

    public void copy(TableroSensores t){
        // copy superficial si cumple las condiciones
        if(t != null && cantFilas() == t.cantFilas() && cantColumnas() == t.cantColumnas()){
            for (int i = 0; i < cantFilas(); i++) {
                for (int j = 0; j < cantColumnas(); j++) {
                    grilla[i][j] = t.obtenerSensor(i, j);
                }
            }
        }
    }
    // Consultas
    public int cantFilas() {
        return grilla.length;
    }

    public int cantColumnas() {
        return grilla[0].length;
    }

    public Sensor obtenerSensor(int f, int c) {
        return grilla[f][c];
    }

    public int cantidadFilasRiesgo(){
        int contador = 0;
        for(int i = 0; i<cantFilas();i++){
            boolean riesgo = false;
            for(int j=0; j<cantColumnas() && !riesgo;j++){
                if(grilla[i][j] != null && grilla[i][j].riesgo()){
                    riesgo=true;
                }
            }
            if(riesgo){
                contador++;
            }
        }
        return contador;
    }

    public boolean todosEnEmergencia(){
        boolean rta = true;
        for(int i = 0; i<cantFilas() && rta;i++){
            for(int j=0; j<cantColumnas() && rta;j++){
                if(grilla[i][j] == null || !grilla[i][j].riesgo()){
                    rta = false;
                }
            }
        }
        return rta;
    }

    public boolean hayNRiesgoCol(int c, int n){
        int contador = 0;
        for(int i = 0; i<cantFilas() && contador <= n;i++){
            if(grilla[i][c] != null && grilla[i][c].riesgo()){
                contador++;
            }
        }
        return contador <= n;
    }

    public boolean dosConsecutivosEmergenciaFila(int f){
        boolean encontrado = false;
        for(int j = 0; j < cantColumnas() - 1 && !encontrado;j++){
            if(grilla[f][j] != null && grilla[f][j+1] != null && grilla[f][j].riesgo() && grilla[f][j+1].riesgo()){
                encontrado = true;
            }   
        }
        return encontrado;
    }

    public int contarCoincidencias(TableroSensores gs){
        int coincidencias = 0;

        if (gs != null) {
            // Se calcula el tamaño mínimo entre ambos tableros para evitar ArrayIndexOutOfBounds
            int minFilas = cantFilas();
            if (gs.cantFilas() < minFilas) {
                minFilas = gs.cantFilas();
            }
            
            int minCol = cantColumnas();
            if (gs.cantColumnas() < minCol) {
                minCol = gs.cantColumnas();
            }

            for(int i = 0; i < minFilas; i++){
                for(int j = 0; j < minCol; j++){
                    if(grilla[i][j] !=null && gs.grilla[i][j] != null && 
                        grilla[i][j].equals(gs.obtenerSensor(i, j))){
                        coincidencias++;
                    }
                }
            }
        }
        return coincidencias;
    }

    public boolean equals(TableroSensores t){
        boolean coinciden = true;
        if(t == null) {
            coinciden = false;
        } else if(cantFilas() != t.cantFilas() || cantColumnas() != t.cantColumnas()){
            coinciden = false;
        }else {
            for(int i = 0; i < cantFilas() && coinciden; i++){
                for(int j = 0; j < cantColumnas() && coinciden; j++){
                    Sensor s1 = grilla[i][j];
                    Sensor s2 = t.obtenerSensor(i, j);
                    
                    if (s1 == null && s2 != null) {
                        coinciden = false;
                    } else if (s1 != null && s2 == null) {
                        coinciden = false;
                    } else if (s1 != null && s2 != null && !s1.equals(s2)) {
                        coinciden = false;
                    }
                }
            }
        }
        return coinciden;
    }

    public TableroSensores clone(){
        TableroSensores aux = new TableroSensores(cantFilas(), cantColumnas());
        for (int i = 0; i < cantFilas(); i++) {
            for (int j = 0; j < cantColumnas(); j++) {
                aux.establecerSensor(i, j, grilla[i][j].clone());
            }
        }
        return aux;
    }
}
