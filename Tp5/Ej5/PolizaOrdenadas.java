public class PolizaOrdenadas {
    private Poliza[] polOrd;
    private int n;

    public PolizasOrdenadas(int max){
        polOrd = new Poliza[max];
        n = 0;
    }

    public void insertar(Poliza pol) {
        // Requiere pol ligado, que no haya duplicado y que haya lugar.
        // Hacemos el corrimiento hacia la derecha para hacerle lugar manteniendo el orden.
        int i = n - 1;
        
        while (i >= 0 && polOrd[i].obtenerNroPoliza() > pol.obtenerNroPoliza()) {
            polOrd[i + 1] = polOrd[i]; // Desplaza a la derecha
            i--;
        }
        
        polOrd[i + 1] = pol; // Lo inserta en el hueco que quedó
        n++;
    }

    public void actualizar(int d, int h, int p){
        for(int i = 0; i < n; i++){
            if(d < polOrd[i].obtenerCostoPoliza() && polOrd[i].obtenerCostoPoliza() < h){
                polOrd[i].actualizarPorcentaje(p);
            }
        }
    }

    public void copy(PolizaOrdenadas p){
        if(p != null && polOrd.length == p.cantPolizas()){
            n = p.cantElementos();
            for(int i = 0; i < n; i++){
                polOrd[i] = p.obtenerPoliza(i);
            }
        }
    }

    public int cantPolizas(){
        return polOrd.length; // Capacidad máxima
    }

    public int cantElementos(){
        return n; // Cantidad ligada actual
    }

    public boolean estaLlena(){
        return polOrd.length == n;
    }

    public boolean existePoliza(int nro){
        boolean aux = false;
        if(nro >= 0){
            for(int i = 0; i < n && !aux; i++){
                if(polOrd[i].obtenerCostoPoliza() == nro){
                    aux = true;
                }
            }
        }
        return aux;
    }

    public boolean existePoliza(Poliza pol){
        boolean encontrada = false;
        // Búsqueda binaria porque sabemos que el arreglo está SIEMPRE ordenado
        int izq = 0;
        int der = n - 1;
        
        while (izq <= der && !encontrada) {
            int medio = (izq + der) / 2;
            if (polOrd[medio].obtenerNroPoliza() == nro) {
                encontrada = true;
            } else if (polOrd[medio].obtenerNroPoliza() < nro) {
                izq = medio + 1;
            } else {
                der = medio - 1;
            }
        }
        return encontrada;
    }

    public Poliza obtenerPoliza(int pos){
        Poliza aux = null;
        if(pos >= 0 && pos < n){
            aux = polOrd[pos];
        }
        return aux;
    }

    public PolizasOrdenadas intercalar(PolizaOrdenadas p){
        PolizasOrdenadas aux = null;
        if (p != null) {
            aux = new PolizasOrdenadas(cantPolizas() + p.cantPolizas());
            
            int i = 0; // Puntero de nuestro arreglo
            int j = 0; // Puntero del arreglo parámetro

            while(i < cantElementos() && j <p.cantElementos()){
                Poliza p1 = polOrd[i];
                Poliza p2 = p.obtenerPoliza(j);

                if (p1.obtenerNroPoliza() == p2.obtenerNroPoliza()) {
                    aux.insertar(p1);
                    i++;
                    j++;
                }else if(p1.obtenerNroPoliza() < p2.obtenerNroPoliza()){
                    aux.insertar(p1);
                    i++;
                } else {
                    aux.insertar(p2);
                    aux.n++;
                    j++;
                }
            }
        }return aux;
    }

}
