public class Coleccion extends Elemento{
    protected  Elemento[] col;
    protected  int cant;

    public Coleccion(int max){
        col = new Elemento[max];
        cant = 0;
    }

    public void insertar(Elemento e){
        col[cant] = e;
        cant++;
    }

    public void eliminar(Elemento e){
        if(e != null){
            int p = -1;
            for(int i = 0; i < cant && p==-1; i++){
                if(col[i].esEquivalente(e)){
                    p = i;
                }
            }
            if(p!=-1){
                for(int j = p; j < cant - 1; j++){
                    col[j] = col[j + 1];
                }
                cant--;
                col[cant] = null;
            }   
        }
    }

    public void ordenada(){
        int izq = 0;
        int der = cant - 1;
        int ultimo = der;
        boolean huboIntercambio = true;

        while (izq < der && huboIntercambio) {
            huboIntercambio = false;
            
            // Pasada de izquierda a derecha (lleva el mayor al final)
            for (int i = izq; i < der; i++) {
                if (col[i].esMayor(col[i + 1])) {
                    intercambiar(i, i + 1);
                    huboIntercambio = true;
                    ultimo = i;
                }
            }
            der = ultimo;

            // Pasada de derecha a izquierda (lleva el menor al principio)
            if (huboIntercambio) {
                huboIntercambio = false;
                for (int i = der; i > izq; i--) {
                    if (col[i - 1].esMayor(col[i])) {
                        intercambiar(i - 1, i);
                        huboIntercambio = true;
                        ultimo = i;
                    }
                }
                izq = ultimo;
            }
        }
    }

    public boolean estaLlena(){
        return cant == col.length;
    }

    public boolean hayElementos(){
        return cant>0;
    }

    public int cantElementos(){
        return cant;
    }

    public boolean existePosicion(int p){
        return 0 <= p && p <= cant;
    }

    public Elemento recuperarElemento(int p){
        Elemento rta = null;
        if(existePosicion(p)){
            rta = col[p];
        }
        return rta;
    }

    public boolean estaElemento(Elemento e){
        if(e!=null){
            boolean esta = false;
            for(int i = 0; i < cant && !esta; i++){
                if(col[i].esEquivalente(e)){
                    esta = true;
                }
            }
        }
        return esta;
    }
}
