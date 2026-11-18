package Tp2.Ej4;

public class Refugio {

    // Atributos de clase (Constantes compartidas)
    private static final int capacidadAlacena = 20;
    private static final int capacidadCamas = 10;

    // Atributos de instancia (SIN static)
    private int alimentos;
    private int bebidas;
    private int camas; // Indica la cantidad de camas OCUPADAS

    // Constructor
    public Refugio(int a, int b, int c) {
        if (a + b > capacidadAlacena) {
            alimentos = capacidadAlacena / 2;
            bebidas = capacidadAlacena / 2;
        } else {
            alimentos = a;
            bebidas = b;
        }

        if (c > capacidadCamas) {
            camas = capacidadCamas;
        } else {
            camas = c;
        }
    }

    // Comandos
    public void consumirAlimento() {
        alimentos--;
    }

    public void consumirBebida() {
        bebidas--;
    }

    public boolean ocuparCama() {
        if (camas < capacidadCamas) {
            camas++;
            return true;
        }
        return false;
    }

    public boolean desocuparCama() {
        if (camas > 0) {
            camas--;
            return true;
        }
        return false;
    }

    public boolean reponerAlimentos(int n) {
        if (n > 0 && (alimentos + bebidas + n <= capacidadAlacena)) {
            alimentos += n;
            return true;
        }
        return false;
    }

    public boolean reponerBebidas(int n) {
        if (n > 0 && (alimentos + bebidas + n <= capacidadAlacena)) {
            bebidas += n;
            return true;
        }
        return false;
    }

    // Consultas
    public int obtenerAlimentos() {
        return alimentos;
    }

    public int obtenerBebidas() {
        return bebidas;
    }

    public int obtenerCamas() {
        return camas;
    }

    public int obtenerCapacidadAlacena() {
        return capacidadAlacena;
    }

    public boolean esHabitable() {
        return (alimentos > 0 || bebidas > 0 || disponibilidad() > 0);
    }

    public int disponibilidad() {
        return capacidadCamas - camas;
    }

    public int diasSupervivencia() {
        return Math.min(alimentos, bebidas);
    }

    public boolean mayorAlimentos(Refugio r) {
        return (r != null && alimentos > r.obtenerAlimentos());
    }

    public boolean equals(Refugio r) {
        return (r != null && alimentos == r.obtenerAlimentos() 
                         && bebidas == r.obtenerBebidas() 
                         && camas == r.obtenerCamas());
    }

    public Refugio clone() {
        return new Refugio(alimentos, bebidas, camas);
    }

    public String toString() {
        return "Alimentos: " + alimentos + " | Bebidas: " + bebidas + " | Camas ocupadas: " + camas;
    }
}