public class Territorio {
    private Refugio[][] tablero;

    public Territorio(int nf, int nc){
        tablero = new Refugio[nf][nc];
    }

    public boolean establecerRefugio(Refugio r, int f, int c){
        boolean establece = false;
        
        if(0 <= f && f < cantFilas() && 0 <= c && c < cantColumnas()){
            tablero[f][c] = r;
            establece = true;
        }
        return establece;
    }

    public int cantFilas(){
        return tablero.length;
    }

    public int cantColumnas(){
        return tablero[0].length;
    }

    public int cantRefugios(){
        int cantRefugio = 0;
        for(int i = 0; i<cantFilas();i++){
            for(int j = 0; j<cantColumnas(); j++){
                if(tablero[i][j] != null){
                    cantRefugio++;
                }
            }
        }
        return cantRefugio;
    }

    public int filaMasPoblada(){
        int contador = 0;
        int memoria = 0;
        int numFila = 0;
        if(cantFilas() > 0 && cantColumnas() > 0){
            for(int i = 0; i < cantFilas();i++){
                for(int j = 0; j <cantColumnas();j++){
                    if(tablero[i][j] != null){
                        contador++;
                    }
                }
                if(contador > memoria){
                    memoria = contador;
                    numFila = i;
                } 
                contador = 0;
            }
        }
        return numFila;
    }

    public boolean maximoNRefugiosHabitables(int f, int n){
        int contador = 0;
        if(f>=0 && n >= 0){
            for(int j = 0; j < cantColumnas() && contador <= n; j++){
                if(tablero[f][j] != null && tablero[f][j].esHabitable()){
                    contador++;
                }
            }
        }
        return contador <= n;
    }

    public int cantConDisponibilidadMayor(int m){
        int contador = 0;
        boolean encontrada = false;
        if(m >= 0){
            for(int i = 0; i < cantColumnas();i++){
                for(int j = 0; j < cantFilas() && !encontrada; j++){
                    if(tablero[j][i] != null && tablero[j][i].disponibilidad() > m){
                        contador++;
                        encontrada = true;
                    }
                }
            encontrada = false;
            }
        }
        return contador;
    }

    public boolean territorioEspejo(){
        boolean esEspejo = false;
        if(cantColumnas() > 0 && cantFilas() > 0 && cantColumnas() % 2 == 1){
            int mitad = cantColumnas() / 2;
            esEspejo = true;
            for(int i = 0; i < cantFilas() && esEspejo; i++){
                esEspejo = tablero[i][mitad-1].equals(tablero[i][mitad+1]) || (tablero[i][mitad-1] == null && tablero[i][mitad+1] == null);
            }
        }
        return esEspejo;
    }

    public ColeccionRefugios coleccionFila(){
        ColeccionRefugios aux = new ColeccionRefugios(cantFilas());
        
        for(int i = 0; i < cantFilas(); i++){
            boolean encontrado = false;
            for(int j = 0; j < cantColumnas() && !encontrado; j++){ // Agregado && !encontrado acá
                if(tablero[i][j] != null){ // Corregido a tablero[i][j]
                    aux.insertarRefugio(tablero[i][j]);
                    encontrado = true;
                }
            }
        }
        return aux;
    }

    public Territorio clone(){
        Territorio aux = new Territorio(cantFila(), cantColumnas());

        for(int i = 0; i < cantFilas();i++){
            for(int j = 0; j <cantColumnas();j++){
                if(this.tablero[i][j] != null)
                    aux.establecerRefugio(tablero[i][j].clone(), i, j);
            }
        }
        return aux;
    }
}
