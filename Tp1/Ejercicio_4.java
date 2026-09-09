package Tp1;
public class Ejercicio_4 {
    //Analice si los siguientes segmentos de código son equivalentes considerando la compilación y la ejecución. Justifique su respuesta.   
    public static void main(String[] args) {
        int sum=0; 
        int i;

        for (i = 10; i > 0; i--)
        sum = sum + i;
        System.out.println(sum); //10+9+8+7+6+5+4+3+2+1=55 
    }
    public static void Hola(String[] args) {
        int sum=0; 
        int i;
        for (i = 10; i > 0; i--); // <-- El punto y coma termina el for aquí
        sum = sum + i; // <-- Esto se ejecuta una vez después del for, con i = 0 
        System.out.println(sum);  //0 
    }
    public static void Hola2(String[] args) {
        int sum=0;
        for (int i = 10; i > 0; i--)
            sum = sum + i;
            System.out.println(sum); //10+9+8+7+6+5+4+3+2+1=55
    }
     public static void Hola3(String[] args) {
        for (int sum = 0, i = 10; i > 0; i--)
            sum = sum + i; //porque con el ; termina el bucle for y el sum no se ejecuta dentro del bucle, sino que se ejecuta una vez después del bucle con i=0
        System.out.println(sum); // <-- ERROR DE COMPILACIÓN
    } 
}
