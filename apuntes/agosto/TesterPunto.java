public class TesterPunto {
    public static void main(String[] args) {
        Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(4,4);
        System.out.println("Vamos a verificar el metodo de distancia con los puntos:"+p1.toString()+" y "+p2.toString());
        System.out.println("Tendria que dar 4.24");
        System.out.println("La distancia entre los puntos es:"+p1.distancia(p2));
    }
}
