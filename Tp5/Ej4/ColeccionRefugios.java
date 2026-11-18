public class ColeccionRefugios {
    private Refugio[] col;
    private int cant;

    public ColeccionRefugios(int n){
        col = new Refugio[n];
        cant = 0;
    }

    public void insertarRefugio(Refugio r){
        if(cant < cantFila()){
            col[cant] = r;
            cant++;
        }
    }

    public void eliminarEscasaSupervivencia(){
        int posicionLibre = 0;
        
        for(int i = 0; i < cant; i++){
            // Si tiene más de 1 día, se salva (lo guardamos)
            if(col[i].diasSupervivencia() > 1){
                col[posicionLibre] = col[i];
                if (i != posicionLibre) {
                    col[i] = null;
                }
                posicionLibre++;
            } else {
                col[i] = null; // Lo eliminamos
            }
        }
        cant = posicionLibre; // Actualizamos la cantidad oficial de refugios
    }

    public Refugio obtenerRefugio(int pos){
        Refugio aux = null;
        if(0<=pos && pos <cantRefugios()){
            aux = col[pos];
        }
        return aux;
    }

    public boolean hayNSeguidosHabitables(int n){
        int contador = 0;
        for(int i = 0; i <cant && contador < n; i++){
            if(col[i] != null && col[i].esHabitable()){
                contador++;
            }else{
                contador=0;
            }
        }
        return contador == n;
    }

    public boolean equals(ColeccionRefugios c){
        boolean sonIguales = true;  
        if (c == null || tamanoColeccion() != c.tamanoColeccion() || cantRefugios() != c.cantRefugios()) {
            sonIguales = false;
        } else {
            for(int i = 0; i < cant && sonIguales; i++){
                sonIguales = col[i].equals(c.obtenerRefugio(i));
            }
        }
        return sonIguales;
    }
}
