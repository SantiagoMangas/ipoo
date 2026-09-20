public class Equipo {
    private String nombre;
    private Jugador capitan;
    private int pG, pE, pP;
    private int gFavor, gContra;

    public Equipo(String nom, Jugador cap){
        nombre = nom;
        capitan = cap;
    }

    //comandos
    public void incrementarPG(boolean jugoElCap){
        pG++; // Aumenta los partidos ganados del equipo
        if(jugoElCap){
            capitan.aumentarUnPartido(); // Envía el mensaje al capitán
        }
    }

    public void incrementarPE(boolean jugoElCap){
        pE++;
        if(jugoElCap){
            capitan.aumentarUnPartido();
        }
    }
    public void incrementarPP(boolean jugoElCap){
        pP++;
        if(jugoElCap){
            capitan.aumentarUnPartido();
        }
    }
    public void aumentarGFavor(int total, int delCap){
        gFavor = gFavor + total;
        if(delCap > 0)
            capitan.aumentarGoles(delCap);
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
        return this.obtenerPG() * 3 + this.obtenerPE();
    }
    
    public Equipo mejorPuntaje(Equipo e){
        Equipo aux = this; // Por defecto asumimos que 'this' es mejor
        
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

    public Jugador capitanConMasGoles(Equipo e){
        // Le pedimos al capitán de este equipo que resuelva quién tiene más goles
        return this.capitan.jugConMasGoles(e.obtenerCapitan());
    }

    public String toString(){
        return "nombre =" + nombre + "Capitan: " + capitan + "partidos ganados: "
         + pG + "Partidos periddos: " + pP + "Partidos empatados" + pE +
         "Goles a favor:" + gFavor + "goles en contra:" + gContra;
    }

    public boolean equals(Equipo e){
        return this.nombre.equals(e.obtenerNombre()) &&
               this.pG == e.obtenerPG() &&
               this.pE == e.obtenerPE() &&
               this.pP == e.obtenerPP() &&
               this.gFavor == e.obtenerGFavor() &&
               this.gContra == e.obtenerGContra() &&
               this.capitan.equals(e.obtenerCapitan());
    }
}
