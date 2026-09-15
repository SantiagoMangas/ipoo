public class Punto {
    private float x;
    private float y;
//constructor
    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }
//comandos
    public void establecerX(float x) {
        this.x = x;
    }

    public void establecerY(float y) {
        this.y = y;
    }   
    public void copy(Punto p) {
        if (p == null) {
            x = p.obtenerX();
            y = p.obtenerY();
        }
    }
    //consultas
    public float obtenerX() {
        return x;
    }
    public float obtenerY() {
        return y;
    }
    public boolean equals(Punto p) {
        return x == p.obtenerX() && y == p.obtenerY();
    }
    public Punto clone() {
        return new Punto(x, y);
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    public float distancia(Punto p) {
        float base = Math.abs(x - p.obtenerX());
        float altura = Math.abs(y - p.obtenerY());
//requiere queda para la clase cliente
        return (float) Math.sqrt(base * base + altura * altura);
    }    
}
