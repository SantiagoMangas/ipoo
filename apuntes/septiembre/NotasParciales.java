package septiembre;

class NotasParciales {
    private static final int minimo = 60;
    private int [][] np;
    
    //constructor
    public NotasParciales(int nFil, int nCol){
        np = new int[nFil][nCol];
    }

    public void establecerNota(int n, int f, int c){
        if(n <= 100 && n >= 0)
            np[f][c] = n;
    }

    public int obtenerNotas(int f, int c){
        return np[f][c];
    }
    public int cantFilas(){
        return np.length;
    }
    public int cantColumnas(){
        return np[0].length;
    }
    public int cantAprobados(){
        int cont = 0;
        for(int j = 0; j < cantFilas(); j++){
            for(int i = 0; i < cantColumnas(); i++){
                if(np[j][i] >= minimo)
                    cont++;
            }
        }
        return cont;
    }
    public int cantAprobadosFilas(int f){
        int cont = 0;
        for(int i = 0; i < cantColumnas(); i++){
            if(np[f][i] >= minimo)
                cont++;
        }
        return cont;
    }
    public int cantAprobadosColumnas(int c){
        int cont = 0;
        for(int j = 0; j < cantFilas(); j++){
            if(np[j][c] >= minimo)
                cont++;
        }
        return cont;
    }
    public boolean hayTodosDesaprobados(){
        //recorrido no exhaustivo por fila y no exahustivo por columna
        boolean todasDes = true;
        boolean hayAlu = false;
        for(int i = 0; i < cantFilas() && !hayAlu; i++){
            todasDes = true;
            for(int j = 0; j < cantColumnas() && todasDes; j++)
                todasDes = np[i][j] < minimo;
            hayAlu = todasDes;
        }
        return hayAlu;
    }
    public boolean dosConsecutivosDes(int f){
        boolean hayDos = false;
        if(f >= 0 && f < cantFilas()){
            for(int j = 0; j < cantColumnas()-1 && !hayDos; j++){
                if(np[f][j] < minimo && np[f][j+1] < minimo)
                    hayDos = true;  
            }
        }
        return hayDos;
    }
}
