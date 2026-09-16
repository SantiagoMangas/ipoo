package septiembre;

public class Tester {
    public static void main(String[] args) {
        TempMinEstacion t = new TempMinEstacion(7);
        t.establecerTempMin(1, 15.0f);
        t.establecerTempMin(2, 20.0f);
        float x = t.obtenerTempMin(1);
        System.out.println(x);
    }
}
