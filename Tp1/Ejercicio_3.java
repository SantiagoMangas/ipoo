package Tp1;
public class Ejercicio_3 {
    public static void main(String[] args) {
        int a,b;
        a = 1; b = 1;
        if (a>b) b++;
        System.out.print(a++ + "hola"); //1
        System.out.print(++b); //2

        a = 1; b = 2;
        if (a > b){
           a = b-1;
        }else
        b = a+1;  //b=2
        System.out.print("\n" + a + " " + b); //1 2

        int d =10;
        if (a == d)
        d=0;
        System.out.print("\n" + d); //10

        a= 1;
        b= 2;
        if((a=20)>(b=10)){
           a = b; 
           System.out.print("\n" + a + " " + b); //10 10
        }else
        b = a; 



        a= 1; b= 2;
        if (a == b+1){
            //no entra
           b = a;
           a = 0; 
        }
        else
        {
            a = b; //a=2
            b = 0; //b=0
            System.out.print("\n" + a + " " + b); //2 0
        }



       a = 1; b = 2;
        if (a == b) {
            //no entra
        a=b++;
        b++;
    }
        else{ 
        b=a++; //b=1, despues suma uno!
        a--;  //a=1
        System.out.print("\n" + a + " " + b); //1 1
        }

    }
}
