public class Juego {
    public static void main(String[] a){
        NaveEspacial n1 = new NaveEspacial('A',500);
        n1.establecerColor('V');
        NaveEspacial nave1 = new NaveEspacial ('V', 200); //crea el objeto, guarda en espacio de memoria para el estado interno del objeto 
        float v = nave1.obtenerAutonomia();
        NaveEspacial nave2 = new NaveEspacial ('V', 200);
        NaveEspacial nave3 = nave2; //nave3 y nave2 apuntan al mismo objeto
        nave1.copy(nave2); //copia el estado de nave2 a nave1
        boolean b1 = nave1 == nave2; //verifica si nave1 y nave2 apuntan al mismo objeto
        boolean b = nave1.equals(nave2); //verifica si nave1 y nave2 tienen el mismo estado


        /*la consulta equals

        boolean b1,b2;
        NaveEspacial nave1, nave2;
        nave1 = new NaveEspacial('V', 200);
        nave2 = new NaveEspacial('A', 500);
        b1 = nave1.equals(nave2);
        nave1.copy(nave2);
        b2 = nave1.equals(nave2);
        */

        NaveEspacial nave4 = nave2.clone(); //crea un nuevo objeto con el mismo estado, mismo estado interno
    }
}
