public class ColeccionOrdenada {
    private Elemento[] t;
    private int cant;

    public ColeccionOrdenada(int max){
        t = new Elemento[max];
        cant = 0;
    }

    public void insertar(Elemento e) {
        for(int i =0; i< cant; i++){
            if(t[i-1].esMayor(e)){
                t[i] = t[i-1];
            } else{
                t[i]= e;
            cant++;
            }
        }
    }

    public void eliminar(Elemento e){
        if(e!=null){
            int p = -1;
            for(int i = 0; i < cant && p ==-1; i++){
                if(t[i].esEquivalente(e)){
                    p = i;
                }
            }
            if(p!=-1){
                for (int j = i + 1; j < cant; j++) {
                    t[j - 1] = t[j];
                }
                cant--;
                t[cant] = null;
            }
        }
    }

    // Consultas
    public boolean estaLlena() {
        return cant == t.length;
    }

    public boolean hayElementos() {
        return cant > 0;
    }

    public int cantElementos() {
        return cant;
    }

    public boolean existePosicion(int p) {
        return p >= 0 && p < cant;
    }

    public Elemento recuperarElemento(int p){
        Elemento rta = null;
        if(existePosicion(p)){
            rta = t[p];
        }
        return rta;
    }

    public boolean estaElemento(Elemento e){
        int ini = 0;
        int fin = cant - 1;
        boolean encontre = false;

        while (ini <= fin && !encontre) {
            int med = (ini + fin) / 2;
            if (t[med].esEquivalente(e)) {
                encontre = true;
            } else if (t[med].esMayor(e)) {
                fin = med - 1;
            } else {
                ini = med + 1;
            }
        }
        return encontre;
    }

    public ColeccionOrdenada intercalar(ColeccionOrdenada c){
        int maxTotal = cant + c.cantElementos();
        // Si ambas colecciones están vacías, evita crear un arreglo de tamaño 0 (max > 0)
        if(maxTotal == 0)
            maxTotal = 1;

        ColeccionOrdenada rta = new ColeccionOrdenada(maxTotal);
        int i = 0;
        int j = 0;

        while (i<cant && j < cantElementos()){
            Elemento elemC = c.recuperarElemento(j);
            if (elemC.esMayor(t[i])) {
                res.insertarAlFinal(t[i]);
                i++;
            } else if (t[i].esMayor(elemC)) {
                res.insertarAlFinal(elemC);
                j++;
            } else {
                // Si tienen el mismo criterio de orden (ej. mismo legajo), 
                // se insertan ambos solo si no son equivalentes
                res.insertarAlFinal(t[i]);
                if (!t[i].esEquivalente(elemC)) {
                    res.insertarAlFinal(elemC);
                }
                i++;
                j++;
            }
        }
    }
    // Método auxiliar privado para insertar en O(1) durante la intercalación
    private void insertarAlFinal(Elemento e) {
        t[cant] = e;
        cant++;
    }
}
