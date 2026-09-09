package Tp1;
public class Ejercicio_2 {

    public static void main(String[] args) {
        int a, b;
        int c = 10, d = 10;

        a = 2;
        a++;
        b = a++; //b=3 a = 3+1 
        c = ++a; //a=4+1 c=a=5 d = 10

        System.out.println(a + " " + b); // a=5 - b =3
        System.out.println(c + " " + d); // c=5 d=10

        a += b; //a= 5+3 = 8    
        b *= 2; //b= 3*2 = 6
        c--; //c= 5-1 = 4
        --d; //d= 10-1 = 9

        System.out.println(a + " " + b); //a = 8 , b = 6
        System.out.println(c + " " + d); //c = 4 , d = 9

        a = 1; b = 1; c = 10; d = 10;

        System.out.println((a == b) || (a++ == b)); // como la primera es true ya queda true
        System.out.println((c == d) | (c++ == d)); // En c++ == d: evalúa 10 == 10 (true), y luego $c$ se incrementa a 11.

        System.out.println(a + " " + b);
        System.out.println(c + " " + d); //11 - 10

        a = 1; b = 1; c = 10; d = 10;

        System.out.println((a != b) & (--a != b)); // 1 != 1 (false), --a = 0, 0 != 1 (true)
        System.out.println((c != d) && (--c != d)); // 10 != 10 (false), --c = 9, 9 != 10 (true) igual no se evalua

        System.out.println(a + " " + b); // 0 - 1 
        System.out.println(c + " " + d); // 10(no se ejecuta la resta) - 10
    }
}