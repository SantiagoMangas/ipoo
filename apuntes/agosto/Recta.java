public class Recta {
    private Punto p1;
    private Punto p2;
//constructor
    public Recta(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
//comandos
    public void copy(Recta r) {
        if (r != null) {
            p1 = r.obtenerP1();
            p2 = r.obtenerP2();
        }
    }
    //consultas
    public Punto obtenerP1() {
        return p1;
    }

    public Punto obtenerP2() {
        return p2;
    }

    public void establecerP1(Punto p1) {
        this.p1 = p1;
    }

    public void establecerP2(Punto p2) {
        this.p2 = p2;
    }
    public boolean equals(Recta r) {
        return p1.equals(r.obtenerP1()) && p2.equals(r.obtenerP2());
    }
    public Recta clone() {
        return new Recta(p1.clone(), p2.clone());
    }
    public String toString() {
        return "Recta: " + p1.toString() + " - " + p2.toString();
    }
    public float longitud() {
        return p1.distancia(p2);
    }
    public void mayor(Recta r) {
        if (longitud() > r.longitud()) {
            System.out.println("La recta es mayor");
        } else if (longitud() < r.longitud()) {
            System.out.println("La recta es menor");
        } else {
            System.out.println("Las rectas son iguales");
        }
    }
}
