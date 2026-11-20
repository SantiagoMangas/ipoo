public class TesterImagen {

    public static void main(String[] args) {
        // 1. Creamos una imagen de 2x2 y la cargamos con matices de gris
        Imagen img1 = new Imagen(2);
        img1.establecer(0, 0, new Color(0, 0, 0));       // Negro (gris)
        img1.establecer(0, 1, new Color(100, 100, 100)); // Gris oscuro
        img1.establecer(1, 0, new Color(200, 200, 200)); // Gris claro
        img1.establecer(1, 1, new Color(255, 255, 255)); // Blanco (gris)

        System.out.println("=== IMAGEN 1 ===");
        mostrarImagen(img1);
        System.out.println("¿Todos grises en img1? (esperado true): " + img1.todosGrises());

        // 2. Creamos img2 con los colores complementarios de img1
        Imagen img2 = new Imagen(2);
        for (int f = 0; f < img1.cantFilas(); f++) {
            for (int c = 0; c < img1.cantColumnas(); c++) {
                Elemento comp = img1.obtener(f, c).complemento();
                img2.establecer(f, c, comp);
            }
        }

        System.out.println("\n=== IMAGEN 2 (Complemento de Imagen 1) ===");
        mostrarImagen(img2);
        System.out.println("¿img1 es complemento de img2? (esperado true): " + img1.esComplemento(img2));
        System.out.println("¿Todos grises en img2? (esperado true): " + img2.todosGrises());

        // 3. Modificamos un píxel de img1 con un color puro (rojo)
        img1.establecer(0, 0, new Color(255, 0, 0));

        System.out.println("\n=== LUEGO DE MODIFICAR (0,0) A ROJO EN IMAGEN 1 ===");
        System.out.println("¿Todos grises en img1? (esperado false): " + img1.todosGrises());
        System.out.println("¿img1 es complemento de img2? (esperado false): " + img1.esComplemento(img2));
        
        // 4. Verificamos también clone() y esEquivalente() heredados de MatrizGenerica
        MatrizGenerica clon = img1.clone();
        System.out.println("¿clon es equivalente a img1? (esperado true): " + img1.esEquivalente(clon));
    }

    private static void mostrarImagen(Imagen img) {
        for (int f = 0; f < img.cantFilas(); f++) {
            for (int c = 0; c < img.cantColumnas(); c++) {
                System.out.print(img.obtener(f, c) + "\t");
            }
            System.out.println();
        }
    }
}