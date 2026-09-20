public class TesterPrestamo {
    public static void main(String[] args) {
        Prestamo p1 = new Prestamo(
            new Libro("El Principito", "Antoine de Saint-Exupéry", "Editorial", 'c'), 
            new Fecha(1, 1, 2023), 
            new Fecha(15, 1, 2023), 
            "Juan"
        );
        
        System.out.println(p1.obtenerLibro());
        System.out.println(p1.obtenerSocio());
        System.out.println(p1.obtenerFechaPrestamo());
        System.out.println(p1.obtenerFechaDevolucion());
        System.out.println(p1.estaDevuelto()); // false
        
        Fecha hoy = new Fecha(17, 9, 2026);

        System.out.println(p1.estaAtrasado(hoy)); // true

        Prestamo p2 = new Prestamo(
            new Libro("Habitos Atomicos", "No se", "Editorial2", 'd'),
            new Fecha(24, 1, 2025),
            new Fecha(14, 7, 2026),
            "Matias"
        );
 
        System.out.println(p2.estaAtrasado(hoy)); // true

        System.out.println(p1.equals(p2)); // false
        System.out.println(p2.equals(p1)); // false
        
        // Corregido: Ahora se imprimen por pantalla
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        Prestamo p3 = new Prestamo(
            new Libro("Habitos Atomicos", "No se", "Editorial2", 'd'),
            new Fecha(24, 1, 2025),
            new Fecha(14, 10, 2026),
            "Dylan"
        );

        System.out.println(p3.estaAtrasado(hoy)); // false

        System.out.println(p1.equals(p3)); // false
        System.out.println(p2.equals(p3)); // false
        
        p3 = p2;
        System.out.println(p1.equals(p3)); // false
        System.out.println(p2.equals(p3)); // true

        System.out.println(p1.masAntiguo(p2)); // p1
        System.out.println(p1.masAntiguo(p3)); // p1
        System.out.println(p2.masAntiguo(p3)); // p2 (o p3, ya que apuntan al mismo)
    }
}