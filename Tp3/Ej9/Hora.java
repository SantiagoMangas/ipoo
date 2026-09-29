public class Hora {
    // Atributos de instancia privados
    private int hor;
    private int min;

    // Constructor
    public Hora(int h, int m) {
        hor = h;
        min = m;
    }

    // Comandos
    public void establecerHora(int c) {
        hor = c;
    }

    public void establecerMinutos(int c) {
        min = c;
    }

    public void copy(Hora h) {
        if (h != null) {
            this.hor = h.obtenerHora();
            this.min = h.obtenerMinutos();
        }
    }

    // Consultas
    public int obtenerHora() {
        return hor;
    }

    public int obtenerMinutos() { 
        return min;
    }

    public boolean equals(Hora c) {
        // La consigna dice "Requiere c ligado", así que asumimos que no es nulo
        return this.hor == c.obtenerHora() && this.min == c.obtenerMinutos();
    }

    public int diferenciaMinutos(Hora c) {
        if (c != null) {
            int auxThis = this.min + (this.hor * 60);
            int auxC = c.obtenerMinutos() + (c.obtenerHora() * 60);
            
            if (auxThis > auxC) {
                return auxThis - auxC;
            } else {
                return auxC - auxThis;
            }
        }
        return 0; // Un método 'int' no puede retornar 'null', retornamos 0 por defecto
    }

    public boolean anterior(Hora c) {
        if (c != null) {
            int auxThis = this.min + (this.hor * 60);
            int auxC = c.obtenerMinutos() + (c.obtenerHora() * 60);
            // Simplemente evaluamos si los minutos totales de "this" son estrictamente menores a los de "c"
            return auxThis < auxC; 
        }
        return false;
    }
}