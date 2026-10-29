public class GrillaReales {
    private float [][] grilla;

    public GrillaReales(int f, int c){
        grilla = new float[f][c];
    }
    //Comandos
    public void establecerReal(int f, int c, float r){
        // Requiere 0 <= f < cantFilas() y 
        // 0 <= c < cantColumnas()
        grilla[f][c] = r;
    }

    public void reemplazar(float r1, float r2){
        for (int i = 0; i < cantFilas();i++){
            for(int j = 0; j < cantColumnas(); j++){
                if(grilla[i][j] == r1){
                    grilla[i][j] = r2;
                }
            }
        }
    }

    public void reemplazar(float r1, float r2, int f){
        boolean encontrado = false;
        for(int i = cantColumnas() - 1; i >= 0 && !encontrado; i--){
            if(grilla[f][i] == r1){
                grilla[f][i] = r2;
                encontrado = true;
            }
        }
    }

    public boolean intercambiarFilas(int f1, int f2){
        boolean encontrado = false;
        if( 0 <= f1 && 0 <= f2 && f1 <cantFilas() && f2 < cantFilas()){
            float[] aux = grilla[f1];
            grilla[f1] = grilla[f2];
            grilla[f2] = aux;
            encontrado = true;
        }
        return encontrado;
    }
    //consultas
    public float obtenerReal(int f, int c){
        return grilla[f][c];
    }
    public int cantFilas() {
        return grilla.length;
    }

    public int cantColumnas() {
        return grilla[0].length;
    }

    public float total(){
        float rta =0;
        for(int i =0; i<cantFilas(); i++){
            for(int j = 0; j <cantColumnas();j++){
                rta += grilla[i][j];
            }
        }
        return rta;
    }

    public float totalColumna(int c){
        float rta=0;
        for(int i = 0; i < cantFilas() ;i ++){
            rta += grilla[i][c];
        }
        return rta;
    }

    public boolean estaNum(float r){
        boolean encontrado = false;
        for (int i = 0; i < cantFilas() && !encontrado;i++){
            for(int j = 0; j < cantColumnas() && !encontrado; j++){
                if(grilla[i][j] == r){
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }

    public int cantidadMayores(float r){
        int rta = 0;
        for (int i = 0; i < cantFilas();i++){
            for(int j = 0; j < cantColumnas(); j++){
                if(grilla[i][j] > r){
                    rta++;
                }
            }
        }
        return rta;
    }

    public boolean esFilaCreciente(int f){
        boolean esMayor = true;
        for(int i = 0; i <cantColumnas() -1 ; i++){
            if(grilla[f][i] >= grilla[f][i+1]){
                esMayor = false;
            } 
        }
        return esMayor;
    }

    public boolean hayNMayoresConsecutivos(int n, float r){
        boolean hayNMayores = false;
        
        for(int i = 0; i < cantFilas() && !hayNMayores;i++){
            int rta = 0;
            for(int j = 0; j < cantColumnas() && !hayNMayores; j++){
                if(grilla[i][j] > r){
                    rta++;
                    if(rta == n){
                        hayNMayores = true;
                    }
                } else {
                    rta = 0;
                }
            }
        }
        return hayNMayores;
    }

    public boolean esTraspuesta(GrillaReales g){
        boolean esTraspuesta = true;
        if(g.cantFilas() != cantColumnas() || 
            g.cantColumnas() != cantFilas()){
            esTraspuesta = false;
        }
        for(int i=0; i < g.cantFilas() && esTraspuesta; i++){
            for(int j=0; j< cantColumnas() && esTraspuesta; j++){
                if(grilla[i][j] != g.obtenerReal(j, i)){
                    esTraspuesta=false;
                }
            }
        }
        return esTraspuesta;
    }

    public GrillaReales transpuesta(){
        GrillaReales aux = new GrillaReales(cantColumnas(), cantFilas());
        for(int i=0; i < cantFilas();i++){
            for(int j=0; j< cantColumnas(); j++){
                aux.establecerReal(j, i, obtenerReal(i, j));
            }
        }
        return aux;
    }
}
