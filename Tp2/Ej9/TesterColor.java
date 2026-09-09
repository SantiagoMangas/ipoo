package Tp2.Ej9;

public class TesterColor {

    public static void main(String[] args) {
        System.out.println("--- TESTING DE CLASE COLOR ---\n");

        // 1. Test de constructores y casos fuera de rango
        Color c1 = new Color(); // Debe ser blanco
        // Orden: Rojo, Azul, Verde
        Color c2 = new Color(300, 150, 150); // Fuera de rango, debe ser blanco
        Color c3 = new Color(255, 0, 0); // Rojo perfecto (255 rojo, 0 azul, 0 verde)
        
        System.out.println("c1 (Constructor sin param): " + c1.toString() + " (Esperado: 255/255/255)");
        System.out.println("c2 (Fuera de rango): " + c2.toString() + " (Esperado: 255/255/255)");
        System.out.println("c3 (Rojo válido): " + c3.toString() + " (Esperado: 255/0/0)\n");

        // 2. Test de consultas booleanas
        Color c4 = new Color(0, 0, 0);
        Color c5 = new Color(150, 150, 150);

        System.out.println("c3 es rojo? " + c3.esRojo() + " (Esperado: true)");
        System.out.println("c4 es negro? " + c4.esNegro() + " (Esperado: true)");
        System.out.println("c5 es gris? " + c5.esGris() + " (Esperado: true)\n");

        // 3. Test de variación (Límites 0 y 255)
        System.out.println("--- Test de comando variar() ---");
        // ATENCIÓN AL ORDEN AQUÍ: Rojo(10), Azul(100), Verde(250)
        Color c6 = new Color(10, 100, 250);
        // Al imprimir (toString) saldrá en orden Rojo/Verde/Azul: 10/250/100
        System.out.println("c6 Original: " + c6.toString());
        
        c6.variar(-20); // El rojo debe quedar en 0 (no puede ser negativo)
        System.out.println("c6 luego de variar(-20): " + c6.toString() + " (Esperado: 0/230/80)");
        
        c6.variar(50); // El verde (230+50=280) debe quedar topeado en 255
        System.out.println("c6 luego de variar(50): " + c6.toString() + " (Esperado: 50/255/130)\n");

        // 4. Test de Complemento
        Color comp = c3.complemento();
        System.out.println("Complemento de c3 (255/0/0): " + comp.toString() + " (Esperado: 0/255/255)\n");

        // 5. Test de equals, clone y copy
        System.out.println("--- Test de clone(), copy() y equals() ---");
        Color clonC5 = c5.clone();
        System.out.println("c5 equals clonC5? " + c5.equals(clonC5) + " (Esperado: true)");
        System.out.println("c5 == clonC5? " + (c5 == clonC5) + " (Esperado: false)");
        
        Color nulo = null;
        System.out.println("c5 equals null? " + c5.equals(nulo) + " (Esperado: false)");

        clonC5.copy(c3);
        System.out.println("clonC5 luego de copy(c3): " + clonC5.toString() + " (Esperado: 255/0/0)");
    }
}