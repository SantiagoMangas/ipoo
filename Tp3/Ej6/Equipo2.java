public class Equipo2 {
    private String nombre;
    private Jugador capitan;
    private int pG, pE, pP;
    private int gFavor, gContra;

    public Equipo2(String nom, Jugador cap){
        nombre = nom;
        capitan = cap;
    }

    //comandos
    // Ahora la responsabilidad del capitán pasó al cliente
    public void incrementarPG(boolean jugoElCap){
        pG++; 
    }

    public void incrementarPE(boolean jugoElCap){
        pE++;
    }
    public void incrementarPP(boolean jugoElCap){
        pP++;
    }
    public void aumentarGFavor(int total, int delCap){
        gFavor = gFavor + total;
    }
    public void aumentarGContra(int total){
        gContra = gContra + total;
    }
    //consultas
    public String obtenerNombre(){
        return nombre;
    }
    public Jugador obtenerCapitan(){
        return capitan;
    }
    public int obtenerPG(){
        return pG;
    }
    public int obtenerPE(){
        return pE;
    }
    public int obtenerPP(){
        return pP;
    }
    public int obtenerGFavor(){
        return gFavor;
    }
    public int obtenerGContra(){
        return gContra;
    }
    public int obtenerPartidos(){
        return pE + pG + pP;
    }
    public int obtenerPuntos(){
        return (pG * 3) + pE ; //es lo mismo creo
    }
    
    public Equipo2 mejorPuntaje(Equipo2 e){
        Equipo2 aux = this; // Por defecto asumimos que 'this' es mejor
        
        if (e.obtenerPuntos() > this.obtenerPuntos()) {
            aux = e;
        } else if (e.obtenerPuntos() == this.obtenerPuntos()) {
            // Empate en puntos -> miramos goles a favor (mayor)
            if (e.obtenerGFavor() > this.obtenerGFavor()) {
                aux = e;
            } else if (e.obtenerGFavor() == this.obtenerGFavor()) {
                // Empate en goles a favor -> miramos goles en contra (MENOR)
                if (e.obtenerGContra() < this.obtenerGContra()) {
                    aux = e;
                }
                // Si también empatan en goles en contra, se queda con 'this' (que ya estaba en aux)
            }
        }
        return aux;
    }

    public Jugador capitanConMasGoles(Equipo2 e){
        // Le pedimos al capitán de este equipo que resuelva quién tiene más goles
        return this.capitan.jugConMasGoles(e.obtenerCapitan());
    }

    public String toString(){
        return "nombre =" + nombre + "Capitan: " + capitan + "partidos ganados: "
         + pG + "Partidos periddos: " + pP + "Partidos empatados" + pE +
         "Goles a favor:" + gFavor + "goles en contra:" + gContra;
    }

    public boolean equals(Equipo2 e){
        if(e == null){
            return false;
        }
        return this.nombre == e.obtenerNombre() &&
               this.capitan == e.obtenerCapitan() &&
               this.pG == e.obtenerPG() &&
               this.pE == e.obtenerPE() &&
               this.pP == e.obtenerPP() &&
               this.gFavor == e.obtenerGFavor() &&
               this.gContra == e.obtenerGContra();
    }
}
