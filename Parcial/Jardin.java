public class Jardin {
    private static final int cantFilas = 5;

    private Personaje [][] g;

    public Jardin(int cantCols){
        g = new Personaje[cantFilas][cantCols];
    }

    public void establecerPersonaje(int f, int c, Personaje p){
        g[f][c] = p;
    }

    public Personaje obtenerPersonaje(int f, int c){
        Personaje p = null;
        if(f >= 0 && f < cantFilas && c >=0 && c<g[0].length){
            p = g[f][c];
        }
        return p;
    }

    public int primerFilaConNconFuerzaF(int n, int f){
        int posFila = -1;
        int contador = 0;

        for(int i = 0; i < g.length && posFila == -1; i++){
            contador = 0;
            for(int j = 0; j < g[0].length && contador<n; j++){
                if(g[i][j]!=null && g[i][j].obtenerFuerza() == f){
                    contador++;
                }
            }if(contador >= n){
                    posFila = i;
                }
        }
        return posFila;
    }

    public TablaPersonajes personajesEquiv(Personaje p){
        TablaPersonajes tp = null;
        if(p!=null){
            tp = new TablaPersonajes(cantFilas * g[0].length);
            for(int i = 0; i < g.length; i++){
                for(int j = 0; j < g[0].length; j++){
                    if(g[i][j] != null && g[i][j].equals(p)){
                        tp.agregarPersonaje(g[i][j]);
                    }
                }
            }
        }
        return tp;
    }

    public boolean hayFilasConVivosFuertes(int n, int f){
        int contFil = 0;
        int contCol = 0;

        for(int i = 0; i <g.length; i++){
            contCol = 0;
            for(int j = 0; j < g[0].length && contCol < 1; j++){
                if(g[i][j] != null && g[i][j].obtenerFuerza() > f && g[i][j].obtenerSalud() > 0){
                    contCol++;
                }
            }
            if(contCol >= 1){
                contFil++;
            }
        }
        return contFil == n;
    }
}
