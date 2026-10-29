public class PlayaSurtidores {
    private Surtidor[] Tabla;

    public PlayaSurtidores(int n) {
        Tabla = new Surtidor(n);
    }

    public PlayaSurtidores() {
        Tabla = new Surtidor[10];
        for (int i = 0; i < Tabla.length; i++) {
            Surtidor s = new Surtidor();
            s.llenarDepositoGasoil();
            s.llenarDepositoSuper();
            s.llenarDepositoPremium();
            Tabla[i] = s;
        }
    }

    public void establecerSurtidor(int p, Surtidor s){
        Tabla[p] = s;
    }
    public void establecerSurtidor(Surtidor s){
        boolean asignado = false;
        for (int i = 0; i < Tabla.length && !asignado; i++) {
            if (Tabla[i] == null) {
                Tabla[i] = s;
                asignado = true;
            }
        }
    }
    public void llenaDepositos(){
        for (int i = 0; i < Tabla.length; i++) {
            if(Tabla[i] != null){   
                Tabla[i].llenarDepositoGasoil();
                Tabla[i].llenarDepositoSuper();
                Tabla[i].llenarDepositoPremium();
            }
        }
    }
    public void agrupaSurtidores(){
        int posicionLibre = 0;
        for (int i = 0; i < Tabla.length; i++) {
            if(Tabla[i] != null){
                Tabla[posicionLibre] = Tabla[i];
                if( i != posicionLibre){
                    Tabla[i] = null;
                }
                posicionLibre++;
            }
        }
    }
    //consultas
    public int cantPosiciones(){
        return Tabla.length;
    }
    public int cantSurtidores(){
        int contador = 0;
        for (int i = 0; i < Tabla.length; i++) {
            if(Tabla[i] != null){
                contador++;
            }
        }
        return contador;
    }
    public Surtidor obtenerSurtidor(int p){
        return Tabla[p];
    }

    public int cantMaximaCarga(){
        int contador = 0;
        for (int i = 0; i < Tabla.length; i++) {
            if(Tabla[i] != null){
                // Comparación manual ya que depositosLlenos() no existe en el ej
                if(Tabla[i].obtenerLitrosGasoil() == Tabla[i].obtenerMaximaCarga() &&
                   Tabla[i].obtenerLitrosSuper() == Tabla[i].obtenerMaximaCarga() &&
                   Tabla[i].obtenerLitrosPremium() == Tabla[i].obtenerMaximaCarga()){
                    contador++;
                }
            }
        }
        return contador;
    }

    public boolean mismosNulos(PlayaSurtidores ps){
        boolean mismosNulos = true;
        if(ps == null || cantPosiciones() != ps.cantPosiciones()) {
            mismosNulos = false;
        } else {
            for (int i = 0; i < Tabla.length && mismosNulos; i++) {
                // 2. Usamos el getter en lugar de acceder directo a la variable privada
                if(Tabla[i] != null && ps.obtenerSurtidor(i) == null){
                    mismosNulos = false;
                }
                if(Tabla[i] == null && ps.obtenerSurtidor(i) != null){
                    mismosNulos = false;
                }
            }
        }
        return mismosNulos;
    }

    public PlayaSurtidores clone(){
        PlayaSurtidores aux = new PlayaSurtidores(Tabla.length);

        for (int i = 0; i < cantPosiciones(); i++) {
            aux.establecerSurtidor(Tabla[i], i);
        }
        return aux;
    }

    public PlayaSurtidores nLigados(int n){
        
    }
}
