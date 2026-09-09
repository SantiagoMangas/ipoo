package Tp2.Ej4;

import java.util.Scanner;

public class TesterRefugio {

    public static void main(String args[]) {

        Refugio r1, r2, r3, r4, r5, r;
        int a, b, c, alim, llenar, camas, a1, a2;
        Scanner scanner = new Scanner(System.in);

        // TESTING DE CONSTRUCTOR
        System.out.println("Testeando constructor con valores previamente establecidos");

        r1 = new Refugio(16, 4, 10);
        System.out.println("Primer refugio creado con 16,4,10: " + r1.toString());

        r2 = new Refugio(17, 5, 3);
        System.out.println("Segundo refugio creado con 17,5,3 pero deberia quedar 10,10,3: " + r2.toString());

        r3 = new Refugio(12, 3, 17);
        System.out.println("Tercer refugio creado con 12,3,17 pero deberia quedar 12,3,10: " + r3.toString());

        System.out.println("Testeando constructor... Ingrese 3 valores enteros:");

        do {
            System.out.println("Ingrese alimentos y bebidas de modo que el total sea a lo sumo 20:");
            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println("Ingrese el número de camas, a lo sumo 10:");
            c = scanner.nextInt();

        } while ((a + b > 20) || (c > 10));

        scanner.close();

        r = new Refugio(a, b, c);
        System.out.println("\nCuarto refugio creado con " + a + "," + b + "," + c + " : " + r.toString());
        System.out.println("----------------------------------------------------------");

        // TESTING DE METODOS
        System.out.println("Testeando metodo consumirAlimento()...");
        alim = r.obtenerAlimentos();
        if (alim > 0) {
            r.consumirAlimento();
            if (r.obtenerAlimentos() != (alim - 1)) {
                System.out.println("ERROR: revisar metodo consumirAlimento()");
            } else {
                System.out.println("Metodo consumirAlimento() funciona correctamente");
            }
        }
        System.out.println("\n" + r.toString());
        System.out.println("----------------------------------------------------------");

        System.out.println("Testeando metodo consumirBebida()...");
        llenar = r.obtenerBebidas();
        if (llenar > 0) {
            r.consumirBebida();
            if (r.obtenerBebidas() != (llenar - 1)) {
                System.out.println("ERROR: revisar metodo consumirBebida()");
            } else {
                System.out.println("Metodo consumirBebida() funciona correctamente");
            }
        }
        System.out.println("\n" + r.toString());
        System.out.println("----------------------------------------------------------");

        System.out.println("Testeando método reponerAlimentos()...");
        if (!r.reponerAlimentos(-3)) {
            System.out.println("reponerAlimentos(negativo) se comportó correctamente retornando false");
        }

        alim = r.obtenerAlimentos() + r.obtenerBebidas();
        llenar = 20 - alim;

        if (!r.reponerAlimentos(llenar + 1)) {
            System.out.println("reponerAlimentos(supera capacidad) se comportó correctamente retornando false");
        }

        if (r.reponerAlimentos(llenar)) {
            System.out.println("Método reponerAlimentos() funciona correctamente al completar capacidad");
        } else {
            System.out.println("ERROR en reponerAlimentos()");
        }
        System.out.println("\n" + r.toString());
        System.out.println("----------------------------------------------------------");

        System.out.println("Testeando método desocuparCama()...");
        camas = r.obtenerCamas();
        if (r.desocuparCama()) {
            if (r.obtenerCamas() == camas - 1) {
                System.out.println("Método desocuparCama() funciona correctamente");
            } else {
                System.out.println("ERROR: revisar método desocuparCama()");
            }
        } else {
            if (camas == 0) {
                System.out.println("Método desocuparCama() funciona correctamente (no había camas ocupadas)");
            } else {
                System.out.println("ERROR: revisar metodo desocuparCama()");
            }
        }
        System.out.println("----------------------------------------------------------");

        System.out.println("Testeando método ocuparCama()...");
        camas = r.obtenerCamas();
        if (r.ocuparCama()) {
            if (r.obtenerCamas() == camas + 1) { // Corregido: si ocupa, las camas ocupadas aumentan
                System.out.println("Método ocuparCama() funciona correctamente");
            } else {
                System.out.println("ERROR: revisar método ocuparCama()");
            }
        } else {
            if (camas == 10) {
                System.out.println("Método ocuparCama() funciona correctamente (no había camas disponibles)");
            } else {
                System.out.println("ERROR: revisar metodo ocuparCama()");
            }
        }
        System.out.println("----------------------------------------------------------");

        System.out.println("Testeando metodo mayorAlimentos()...");
        r4 = null;
        if (!r.mayorAlimentos(r4)) {
            System.out.println("Método mayorAlimentos() funciona correctamente con r4 null");
        }

        a1 = r.obtenerAlimentos();
        r4 = new Refugio(1, 1, 1);
        a2 = r4.obtenerAlimentos();

        if (a1 > a2) {
            if (r.mayorAlimentos(r4)) System.out.println("Metodo mayorAlimentos() funciona correctamente");
            else System.out.println("ERROR: revisar metodo mayorAlimentos()");
        } else {
            if (!r.mayorAlimentos(r4)) System.out.println("Método mayorAlimentos() funciona correctamente");
            else System.out.println("ERROR: revisar metodo mayorAlimentos()");
        }
        System.out.println("----------------------------------------------------------");

        System.out.println("Testeando método clone()...");
        r5 = r.clone();
        if (r.obtenerAlimentos() == r5.obtenerAlimentos() &&
            r.obtenerBebidas() == r5.obtenerBebidas() &&
            r.obtenerCamas() == r5.obtenerCamas()) {
            System.out.println("Método clone() funciona correctamente");
        } else {
            System.out.println("ERROR en clone()");
        }
        System.out.println("----------------------------------------------------------");

        // --- MÉTODOS RESTANTES COMPLETADOS ---

        System.out.println("Testeando método equals()...");
        if (r.equals(r5) && !r.equals(r1) && !r.equals(null)) {
            System.out.println("Método equals() funciona correctamente");
        } else {
            System.out.println("ERROR en método equals()");
        }

        System.out.println("Testeando método esHabitable()...");
        if (r.esHabitable()) {
            System.out.println("El refugio es habitable correctamente");
        } else {
            System.out.println("El refugio no es habitable");
        }

        System.out.println("Testeando disponibilidad() y diasSupervivencia()...");
        System.out.println("Camas disponibles: " + r.disponibilidad());
        System.out.println("Días de supervivencia: " + r.diasSupervivencia());

        System.out.println("----------------------------------------------------------");
        System.out.println("FIN DEL TESTING");
    }
}