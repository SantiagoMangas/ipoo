public class Juego {
    public static void main(String[] a){
        NaveEspacial n1 = new NaveEspacial('A',500);
        n1.establecerColor('V');
        NaveEspacial nave1 = new NaveEspacial ('V', 200); //crea el objeto, guarda en espacio de memoria para el estado interno del objeto 
        float v = nave1.obtenerAutonomia();
    }
}
