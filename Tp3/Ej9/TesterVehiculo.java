public class TesterVehiculo {
    public static void main(String[] a){
        // 1. Creamos la Tarifa (ejemplo: $500 por 15min, 
        // $800 por 30min, $1200 por 60min, $2000 el día)
        Tarifa tarifa = new Tarifa(500, 800, 1200, 2000);

        // 2. Creamos horas de ingreso
        Hora ingreso1 = new Hora(10,0);
        Hora ingreso2 = new Hora(17,17);

        //Creamos vehiculos
        Vehiculo v1 = new Vehiculo(ingreso1, 1 , "JZI891");
        Vehiculo v2 = new Vehiculo(ingreso2, 2, "OHB762");

        System.out.println(v1.anterior(v2)); //true
        System.out.println(v2.anterior(v1)); //false

        Hora egreso1 = new Hora(10, 14);
        v1.egresaVehiculo(egreso1, tarifa);
        System.out.println("Cobro v1 (14 min): $" + v1.obteneraCobrar());

        Hora egreso2 = new Hora(18, 07); //1200
        v2.egresaVehiculo(egreso2, tarifa);
        System.out.println("Cobro v2 (50 min): $" + v2.obteneraCobrar()); 
        System.out.println("equals v1 con v2:" + v1.equals(v2)); // false

        Vehiculo v3 = new Vehiculo(new Hora(8,0), 99, "Temporal");
        v3.copy(v1); // v3 copia todos los datos de v1
        
        System.out.println("¿v1 es igual a v3 luego del copy?: " + v1.equals(v3)); // Debería dar true
    }
}
