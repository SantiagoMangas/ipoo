public class MatrizGenerica{
    private Elemento[][] m;
    public MatrizGenerica(int nf, int nc){
        m = new Elemento[nf][nc];
    }

    public  void establecer(int f, int c, Elemento e){
        if(f >= 0 && f < m.length && c >= 0 && c < m[0].length){
            m[f][c] = e;
        }
    }

    public Elemento obtener(int f, int c){
        if(f >= 0 && f < m.length && c >= 0 && c < m[0].length){
            return m[f][c];
        }
        return null;
    }

    public int cantFilas(){
        return m.length;
    }
    public int cantColumnas(){
        return m[0].length;
    }

    public boolean pertenece(Elemento e){
        boolean pertenece = false;
        for(int i = 0; i < m.length && !pertenece; i++){
            for(int j = 0; j < m[0].length && !pertenece; j++){
                if(m[i][j] != null && m[i][j].equals(e)){
                    pertenece = true;
                }
            }
        }
        return pertenece;
    }

    public int contarElem(Elemento e){
        int contador = 0;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j] != null && m[i][j].equals(e)){
                    contador++;
                }
            }
        }
        return contador;
    }

    public boolean esEquivalente(MatrizGenerica c) {
        boolean esEquivalente = (c != null && cantFilas() == c.cantFilas() && cantColumnas() == c.cantColumnas());
        for (int i = 0; i < cantFilas() && esEquivalente; i++) {
            for (int j = 0; j < cantColumnas() && esEquivalente; j++) {
                if (m[i][j] == null || c.obtener(i, j) == null) {
                    esEquivalente = (m[i][j] == c.obtener(i, j));
                } else {
                    esEquivalente = m[i][j].equals(c.obtener(i, j));
                }
            }
        }
        return esEquivalente;
    }
    public boolean esComplemento(MatrizGenerica c){
        boolean esComplemento = (c != null && cantFilas() == c.cantFilas() && cantColumnas() == c.cantColumnas());
        for(int i = 0; i < m.length && esComplemento; i++){
            for(int j = 0; j < m[0].length && esComplemento; j++){
                if(m[i][j] != null && c.obtener(i, j) == null){
                    esComplemento = true;
                } else if(m[i][j] == null && c.obtener(i, j) != null){
                    esComplemento = false;
                } else{
                    esComplemento = obtener(i, j).equals(c.obtener(i, j).complemento());
                }
        }
        }
        return esComplemento;
    }
    public MatrizGenerica clone(){
        MatrizGenerica mg = new MatrizGenerica(cantFilas(), cantColumnas());
        for(int i = 0; i < cantFilas(); i++){
            for(int j = 0; j < cantColumnas(); j++){
                if(obtener(i, j) == null)
                    mg.establecer(i,j, obtener(i, j));
                else{
                    mg.establecer(i,j, obtener(i, j).clone());
                }
            }
        }
        return mg;
    }
    
}