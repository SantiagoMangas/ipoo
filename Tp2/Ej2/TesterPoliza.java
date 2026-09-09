package Tp2.Ej2;
import java.util.Scanner;

public class TesterPoliza {
    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        
        int np;
        float i, r;

        do {
            System.out.print("Ingrese el número de póliza (> 0): ");
            np = scanner.nextInt();
        } while (np <= 0);

        do {
            System.out.print("Ingrese el monto por incendio (> 0): ");
            i = scanner.nextFloat();
        } while (i <= 0);

        do {
            System.out.print("Ingrese el monto por robo (> 0): ");
            r = scanner.nextFloat();
        } while (r <= 0);

        Poliza poliza = new Poliza(np, i, r);
        System.out.println(poliza.obtenerNroPoliza() + " " + poliza.obtenerCostoPoliza() + " " + poliza.estaActiva());
        poliza.actualizarPorcentaje(20);
        poliza.desactiva();
        System.out.println(poliza.obtenerNroPoliza() + " " + poliza.obtenerCostoPoliza() + " " + poliza.estaActiva());
        poliza.actualizarPorcentaje(10);
        poliza.activa();
        System.out.println(poliza.obtenerNroPoliza() + " " + poliza.obtenerCostoPoliza() + " " + poliza.estaActiva());
        
        Poliza poliza2 = new Poliza(111);
        poliza2.establecerIncendio(1200);
        poliza2.establecerRobo(1000);      
        poliza2.actualizarPorcentaje(15);
        System.out.println(poliza2.obtenerNroPoliza() + " " + poliza2.obtenerCostoPoliza());
        
        scanner.close();
    }
}
