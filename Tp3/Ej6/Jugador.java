public class Jugador {
    // Atributos de instancia
    private String nombre;
    private int nroCamiseta;
    private int posicion;
    private int golesConvertidos;
    private int partidosJugados;

    // Constructor
    public Jugador(String nom) {
        nombre = nom;
    }

    // Comandos
    public void establecerNroCamiseta(int n) {
        nroCamiseta = n;
    }

    public void establecerPosicion(int n) {
        posicion = n;
    }

    public void establecerGolesConvertidos(int n) {
        golesConvertidos = n;
    }

    public void establecerPartidosJugados(int n) { 
        partidosJugados = n;
    }

    public void aumentarGoles(int n) {
        if (n > 0) {
            golesConvertidos += n;
        }
    }

    public void aumentarUnPartido() {
        partidosJugados++;
    }

    // Consultas 
    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerNroCamiseta() {
        return nroCamiseta;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public int obtenerGolesConvertidos() {
        return golesConvertidos;
    }

    public int obtenerPartidosJugados() {
        return partidosJugados;
    }

    public int promedioGolesXPart() {
        if (partidosJugados > 0) {
            return golesConvertidos / partidosJugados;
        }
        return 0;
    }

    public boolean masGoles(Jugador j) {
        return j != null && golesConvertidos > j.obtenerGolesConvertidos();
    }

    public Jugador jugConMasGoles(Jugador j) {
        // Requiere j ligado
        if (j != null && j.obtenerGolesConvertidos() > golesConvertidos) {
            return j;
        }
        return this; // Si j es null o tiene igual/menos goles, retorna el actual
    }

    public String toString() {
        return "Jugador: " + nombre + 
               " | Camiseta: " + nroCamiseta + 
               " | Posición: " + posicion + 
               " | Goles: " + golesConvertidos + 
               " | Partidos: " + partidosJugados + 
               " | Promedio: " + promedioGolesXPart();
    }

    public Jugador clone() {
        // Usamos el constructor disponible y luego seteamos el resto de los atributos
        Jugador j = new Jugador(nombre);
        j.establecerNroCamiseta(nroCamiseta);
        j.establecerPosicion(posicion);
        j.establecerGolesConvertidos(golesConvertidos);
        j.establecerPartidosJugados(partidosJugados);
        return j;
    }

    public boolean equals(Jugador j) {
        // Requiere j ligado y compara estado interno completo
        return nombre.equals(j.obtenerNombre()) && 
               nroCamiseta == j.obtenerNroCamiseta() && 
               posicion == j.obtenerPosicion() && 
               golesConvertidos == j.obtenerGolesConvertidos() && 
               partidosJugados == j.obtenerPartidosJugados();
    }
}