package Tp2.Ej5;

public class TesterSensor {

    public static void main(String[] args) {
        System.out.println("--- INCISO B ---");
        Sensor s1, s2, s3;
        s1 = new Sensor(1.5, 1.6);
        s2 = s1.clone();
        s3 = new Sensor(1.5, 1.5);

        System.out.println("s1 == s2: " + (s1 == s2));           // false
        System.out.println("s1.equals(s2): " + s1.equals(s2));   // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));   // false

        System.out.println("\n--- INCISO C ---");
        s3.copy(s1);
        s1 = s2;

        System.out.println("s1 == s2: " + (s1 == s2));           // true
        System.out.println("s1.equals(s2): " + s1.equals(s2));   // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));   // true
    }
}