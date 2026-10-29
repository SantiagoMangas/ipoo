public class Historicos {
    //atributos de instancia
    private Jugador[] jugadoresHistoricos;
    private int cant;

    public Historicos(int n){
        jugadoresHistoricos = new Jugador[n];
        cant = 0;
    }

    public void establecerJugador(Jugador j){
        // no esta llena y j ligada
        jugadoresHistoricos[cant] = j;
        cant++;
    }

    public void ordenar(){
        for (int i = 0; i < cant - 1; i++) {
            for (int j = 0; j < cant - 1 - i; j++) {
                // compareTo devuelve > 0 si el primer String es alfabéticamente mayor
                if (jugadoresHistoricos[j].obtenerNombre().compareTo(jugadoresHistoricos[j + 1].obtenerNombre()) > 0) {
                    // Intercambio
                    Jugador aux = jugadoresHistoricos[j];
                    jugadoresHistoricos[j] = jugadoresHistoricos[j + 1];
                    jugadoresHistoricos[j + 1] = aux;
                }
            }
        }
    }

    //consultas

    public boolean estaLlena(){
        boolean llena = true;
        for(int i = 0; i <cantJugadores() && llena; i++){
            if(jugadoresHistoricos[i] == null){
                llena = false;
            }
        }
        return llena;
    }

    public int cantPosiciones(){
        return jugadoresHistoricos.length;
    }

    public int cantJugadores(){
        return cant;
    }

    public Jugador obtenerJugador(int p){
        return jugadoresHistoricos[p];
    }

    public boolean mMayores(int g, int m){
        int jugadores = 0;
        
        if(g >= 0 && m >= 0){
            for(int i = 0; i < cantJugadores(); i++){
                if(jugadoresHistoricos[i].obtenerGolesConvertidos() > g){
                    jugadores++;
                }
            }
        }

        return jugadores==m;
    }

    public boolean alMenosMMayores(int g, int m) {
        boolean hayMayores = false;
        int jugadores = 0;
        if(g >= 0 && m >= 0){
            for(int i = 0; i < cantJugadores() && !hayMayores; i++){
                if(jugadoresHistoricos[i].obtenerGolesConvertidos() > g){
                    jugadores++;
                    if(jugadores >= m){
                    hayMayores = true;
                    }
                }
            }
        }
        return hayMayores;
    }

    public Historicos goleadores(int g){
        // 1. Primero contamos cuántos superan 'g' 
        // para saber de qué tamaño crear la nueva colección
        int cantidadGoleadores = 0;
        for (int i = 0; i < cantJugadores(); i++) {
            if (jugadoresHistoricos[i].obtenerGolesConvertidos() > g) {
                cantidadGoleadores++;
            }
        }

        // 2. Creamos la nueva colección 
        // (si es 0, creamos de tamaño 1 para no violar el n>0 del Requiere)
        int tamaño = cantidadGoleadores;
        if (tamaño == 0) {
            tamaño = 1; 
        }
        Historicos aux = new Historicos(tamaño);
        
        for(int i = 0; i < cantidadGoleadores; i++) {
           if (jugadoresHistoricos[i].obtenerGolesConvertidos() > g) {
                aux.establecerJugador(jugadoresHistoricos[i]);
            }
        }

        return aux;
    }
}
