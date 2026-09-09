package Tp2.Ej8;

public class TesterFecha {
    public static void main(String[] a){
        Fecha f1 = new Fecha(23,6,2004);
        Fecha f2 = new Fecha(24,1,2005);

        System.out.println("Fecha 1: " + f1.obtenerDia() + "/" + f1.obtenerMes() + "/" + f1.obtenerAnio());
        System.out.println("Es bisiesto: " + f1.esBisiesto()); //true
        System.out.println("Fecha 2: " + f2.obtenerDia() + "/" + f2.obtenerMes() + "/" + f2.obtenerAnio());
        System.out.println("Es bisiesto: " + f2.esBisiesto());  //false
        System.out.println("Fecha 1 es anterior a Fecha 2: " + f1.esAnterior(f2)); 
        System.out.println("Fecha 2 es anterior a Fecha 1: " + f2.esAnterior(f1)); 
        System.out.println("Fecha 1 y Fecha 2 son del mismo año: " + f1.mismoAnio(f2));
        System.out.println("Fecha 1 y Fecha 2 son iguales: " + f1.equals(f2));

        f1 = f2;

        System.out.println("Fecha 1 y Fecha 2 son iguales: " + f1.equals(f2));
        System.out.println("Fecha 1 y Fecha 2 son del mismo año: " + f2.mismoAnio(f1));
        System.out.println("Fecha 1 y Fecha 2 son del mismo año: " + f1.mismoAnio(f2));
    }
}
