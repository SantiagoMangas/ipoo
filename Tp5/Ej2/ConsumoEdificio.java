public class ConsumoEdificio {
    private MedicionServicios[] consumoXPiso;

    public ConsumoEdificio(int pisos){
        consumoXPiso = new MedicionServicios[pisos];
    }

    //Comandos
    public boolean registrarConsumo(MedicionServicios m, int p){
        boolean rta = false;
        if(p > 0 && p <= consumoXPiso.length){
            consumoXPiso[p - 1] = m;
            rta =true;
        }
        return rta;
    }
    public boolean eliminarConsumo(int p){
        boolean eliminado = false;
        if(p > 0 && p <= consumoXPiso.length){
            consumoXPiso[p-1] = null;
            eliminado = true;
        }
        return eliminado;
    }

    public void eliminarCeros(){
        for(int i =0; i<cantPosiciones(); i++){
            if (consumoXPiso[i] != null) {
                int ceros = 0;
                if (consumoXPiso[i].obtenerGas() == 0) ceros++;
                if (consumoXPiso[i].obtenerAgual() == 0) ceros++;
                if (consumoXPiso[i].obtenerElectricidad() == 0) ceros++;
                
                if (ceros >= 2) {
                    consumoXPiso[i] = null; // Eliminamos la referencia
                }
        }   }
    }

    //consultas
    public int cantPosiciones() {
        return consumoXPiso.length;
    }

    public int cantRegistrosConsumo() {
        int registrados = 0;
        for (int i = 0; i < consumoXPiso.length; i++) {
            if (consumoXPiso[i] != null) {
                registrados++;
            }
        }
        return registrados;
    }

    public MedicionServicios obtenerMedicionServicio(int p){
        return consumoXPiso[p-1];
    }

    public boolean hayMayorConsumo(int c) {
        boolean hayMayor = false;
        for(int i =0; i < cantPosiciones() && !hayMayor; i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c){
                hayMayor = true;
            }
        }
        return hayMayor;
    }

    public int cuantasMayores(int c) {
        int contador = 0;
        for(int i =0; i < cantPosiciones(); i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c){
                contador++;
            }
        }
        return contador;
    }

    public int primerPisoMayor(int c){
        int pisoEncontrado = -1;
        for(int i =0; i < cantPosiciones() && pisoEncontrado == -1; i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c){
                pisoEncontrado = i+1;
            }
        }
        return pisoEncontrado;
    }

    public int ultimoPisoMayor(int c) {
        int pisoEncontrado = -1;
        for(int i =cantPosiciones()-1; i >= 0 && pisoEncontrado == -1; i--){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c){
                pisoEncontrado = i+1;
            }
        }
        return pisoEncontrado;
    }
    public boolean nMayores(int c, int n) {
        int cant = 0;
        for(int i = 0; i < cantPosiciones() && cant != n; i++){
            if(consumoXPiso[i] != null && consumoXPiso[i].costoServicios() > c){
                cant++;
            }
        }
        return cant == n;
    }
    public boolean todosMayores(int c){
        return cuantasMayores(c) == cantPosiciones();
    }
    public boolean todosMayores(MedicionServicios m){
        boolean todos = true;
        for (int i = 0; i < consumoXPiso.length && todos; i++) {
            if (consumoXPiso[i] != null) {
                // Si alguno de los 3 servicios no supera al de la medición m, retornamos false
                if (consumoXPiso[i].obtenerGas() <= m.obtenerGas() ||
                    consumoXPiso[i].obtenerAgual() <= m.obtenerAgual() ||
                    consumoXPiso[i].obtenerElectricidad() <= m.obtenerElectricidad()) {
                    todos = false;
                }
            }
        }
        return todos;
    }
}
