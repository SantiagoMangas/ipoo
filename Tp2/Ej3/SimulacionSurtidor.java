package Tp2.Ej3;
import java.util.Scanner;

public class SimulacionSurtidor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Surtidor s = new Surtidor();
        int n;

        System.out.println("Elije la cantidad de iteraciones para la simulación: ");
        n = scanner.nextInt();

        for(int i=0; i<n; i++){
            // Simular alguna operación con el surtidor
            System.out.println("Litros de Gasoil disponibles: " + s.obtenerLitrosGasoil());
            System.out.println("Litros de Super disponibles: " + s.obtenerLitrosSuper());
            System.out.println("Litros de Premium disponibles: " + s.obtenerLitrosPremium());
            
            System.out.println("1: leer litros a cargar y cargar Gasoil\n" + //
                                " 2: leer litros a cargar y cargar Super\n" + //
                                " 3: leer litros a cargar y cargar Premium\n" + //
                                " 4: llenar Deposito Gasoil\n" + //
                                " 5: llenar Deposito Super\n" + //
                                " 6: llenar Deposito Premium\n" + 
                                "Opcion: ");
            int opcion = scanner.nextInt();
            int litros;

            switch(opcion){
                case 1:
                    System.out.println("Ingrese litros de Gasoil: ");
                    litros = scanner.nextInt();
                    s.extraerGasoil(litros);
                    break;
                case 2:
                    System.out.println("Ingrese litros de Super: ");
                    litros = scanner.nextInt();
                    s.extraerSuper(litros);
                    break;
                case 3:
                    System.out.println("Ingrese litros de Premium: ");
                    litros = scanner.nextInt();
                    s.extraerPremium(litros);
                    break;
                case 4: 
                    s.llenarDepositoGasoil();
                    break;
                case 5:
                    s.llenarDepositoSuper();
                    break;
                case 6:
                    s.llenarDepositoPremium();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
        scanner.close();
    }
}
