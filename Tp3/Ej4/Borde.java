public class Borde {
    // Atributos de instancia
    private int grosor;
    private Color color;

    // Constructor
    public Borde(int g, Color c) {
        grosor = g;
        color = c;
    }

    // Comandos
    public void establecerGrosor(int g) {
        grosor = g; 
    }

    public void establecerColor(Color c) {
        color = c;
    }

    public void copy(Borde b) {
        // Asume b ligado, sin if(b != null)
        this.grosor = b.obtenerGrosor();
        this.color = b.obtenerColor(); // Copia superficial de referencia
    }

    // Consultas
    public int obtenerGrosor() {
        return grosor;
    }

    public Color obtenerColor() {
        return color;
    }

    public Borde clone() {
        // Clonación superficial (pasa la misma referencia de color)
        return new Borde(grosor, color);
    }

    public boolean equals(Borde b) {
        // Asume b ligado y usa == para igualdad superficial del color
        return this.grosor == b.obtenerGrosor() &&
               this.color == b.obtenerColor();
    }

    public String toString() {
        return "color: " + color + " grosor: " + grosor;
    }
}