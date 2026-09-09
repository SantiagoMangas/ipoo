package Tp2.Ej5;

public class Sensor {
    //atributos de clase
    private static final double max = 0.01;
    //atributos de instancia
    private double p1, p2;

    //constructor
    public Sensor(double p1, double p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    //comandos
    public void establecerP1(double p){
        p1 = p;
    }
    public void establecerP2(double p){
        p2 = p;
    }
    public void copy(Sensor s){
        if (s != null){
            p1 = s.obtenerP1();
            p2 = s.obtenerP2(); //esto modifica el estado interno del sensor
            //s.p1 = p1; //esto no modifica el estado interno del sensor
        }
    }
    //consultas
    public double obtenerP1(){
        return p1;
    }
    public double obtenerP2(){
        return p2;
    }
    public boolean riesgo(){
        return (p2 > p1);  //si p2 es mayor que p1, hay riesgo, devuelve true, sino devuelve false
    }
    public boolean emergencia(){
        return (p1 < max); //si p1 es menor que max, hay emergencia, devuelve true, sino devuelve false
    }
    public boolean equals(Sensor s){
        return (s!= null && p1 == s.obtenerP1() && p2 == s.obtenerP2()); //si p1 y p2 son iguales a los de s, devuelve true, sino devuelve false
    }
    public Sensor clone(){
        return new Sensor(p1, p2); //devuelve un nuevo sensor con los mismos valores de p1 y p2
    }
}
