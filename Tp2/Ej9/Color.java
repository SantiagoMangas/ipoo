package Tp2.Ej9;

public class Color {
    //Atributos de instancia
    private int rojo, verde, azul;
    //Contructores
    public Color(){
        rojo = 255; 
        verde = 255; 
        azul = 255;
    }
    public Color(int r, int a, int v) {
        // Si AL MENOS UNO está fuera de rango, todo es blanco
        if (r < 0 || r > 255 || a < 0 || a > 255 || v < 0 || v > 255) {
            rojo = 255;
            azul = 255;
            verde = 255;
        } else {// Si TODOS están en rango, asigno los valores
            rojo = r;
            azul = a;
            verde = v;
        }
    }
    //Comandos
    public void variar (int val){
        variarAzul(val);
        variarRojo(val);
        variarVerde(val);   
    }
    public void variarRojo(int val){
        if (rojo + val <= 255 && rojo + val >= 0){
            rojo += val;
        } else if(rojo + val > 255 ){
            rojo = 255;
        } else{
            rojo = 0;
        }
    }
    public void variarAzul(int val){
        if (azul + val <= 255 && azul + val >= 0) {
            azul += val;
        } else if (azul + val > 255) {
            azul = 255;
        } else {
            azul = 0;
        }
    }
    public void variarVerde(int val){
        if (verde + val <= 255 && verde + val >= 0) {
            verde += val;
        } else if (verde + val > 255) {
            verde = 255;
        } else {
            verde = 0;
        }
    }

    public void copy(Color c){
        if(c != null){
            rojo = c.obtenerRojo();
            azul = c.obtenerAzul();
            verde = c.obtenerVerde();
        }
    }

    public void establecerRojo(int val){
        // (Asumo que el cliente envia valor entre 0 y 255)
        rojo = val;
    }
    public void establecerAzul(int val){
        azul = val;
    }
    public void establecerVerde(int val){
        verde = val;
    }
    //Consultas
    public int obtenerRojo(){
        return rojo;
    }
    public int obtenerVerde(){
        return verde;
    }
    public int obtenerAzul(){
        return azul;
    }
    public boolean esRojo(){
       return rojo == 255 && verde == 0 && azul == 0;
    }
    public boolean esGris(){
        return rojo == verde && verde == azul; //con esto alcanza
    }
    public boolean esNegro(){
        return rojo == 0 && verde == 0 && azul == 0;
    }
    public Color complemento() {
        int r = 255 - rojo;
        int a = 255 - azul;
        int v = 255 - verde;

        return new Color(r, a, v); 
    }
    public boolean equals(Color c){
        if(c != null){
            return rojo == c.obtenerRojo() && verde == c.obtenerVerde() && azul == c.obtenerAzul();
        }
        return false;
    }
    public Color clone() {
        return new Color(rojo, azul, verde);
    }
    public String toString(){
        return rojo + "/" + verde + "/" + azul;
    }
}
